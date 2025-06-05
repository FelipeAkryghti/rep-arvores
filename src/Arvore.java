import java.util.Stack;

public class Arvore {
    private No raiz;

    public Arvore() {
        this.raiz = null;
    }

    private int altura(No no) {
        if (no == null) {
            return 0;
        } else {
            return no.getAltura();
        }
    }

    public void atualizarAlturaNo(No no) {
        int alturaEsquerda = altura(no.getEsquerda());
        int alturaDireita = altura(no.getDireita());

        if (alturaEsquerda > alturaDireita) {
            no.setAltura(alturaEsquerda + 1);
        } else {
            no.setAltura(alturaDireita + 1);
        }
    }

    private int getBalanceamento(No no) {
        if (no == null) {
            return 0;
        }
        return altura(no.getEsquerda()) - altura(no.getEsquerda());
    }

    private No rotacaoDireita(No noDesbalanceado) {
        No noFilhoEsquerdo = noDesbalanceado.getEsquerda();
        No subArvoreIntermed = noFilhoEsquerdo.getDireita();

        noFilhoEsquerdo.setDireita(noDesbalanceado);
        noDesbalanceado.setEsquerda(subArvoreIntermed);

        atualizarAlturaNo(noDesbalanceado);
        atualizarAlturaNo(noFilhoEsquerdo);

        return noFilhoEsquerdo;
    }

    private No rotacaoEsquerda(No noDesbalanceado) {
        No noFilhoDireito = noDesbalanceado.getDireita();
        No subArvoreIntermed = noFilhoDireito.getEsquerda();

        noFilhoDireito.setEsquerda(noDesbalanceado);
        noDesbalanceado.setDireita(subArvoreIntermed);

        atualizarAlturaNo(noDesbalanceado);
        atualizarAlturaNo(noFilhoDireito);

        return noFilhoDireito;
    }

    public void inserirNo(int elemento) {
        raiz = inserirNo(raiz, elemento);
    }

    public No inserirNo(No no, int conteudo) {
        if (no == null) {
            return new No(conteudo);
        }

        // Inserir no raiz 30
        // Inserir 20 após 30:
        // 20 < 30 → esquerda de 30 → nó vazio → cria No(20)
        if (conteudo < no.getConteudo()) {
            no.setEsquerda(inserirNo(no.getEsquerda(), conteudo));
        } else if (conteudo > no.getConteudo()) {
            no.setDireita(inserirNo(no.getDireita(), conteudo));
        } else {
            // não permite duplicados
            return no;
        }

        int alturaEsquerda = altura(no.getEsquerda());
        int alturaDireita = altura(no.getDireita());

        if (alturaEsquerda > alturaDireita) {
            no.setAltura(alturaEsquerda + 1);
        } else {
            no.setAltura(alturaDireita + 1);
        }

        int balanceamento = getBalanceamento(no);

        if (balanceamento < -1 && conteudo > no.getDireita().getConteudo()) {
            return rotacaoEsquerda(no);
        }

        // Rotação simples à direita
        if (balanceamento > 1 && conteudo < no.getEsquerda().getConteudo()) {
            return rotacaoDireita(no);
        }

        // Rotação dupla esquerda-direita
        if (balanceamento > 1 && conteudo > no.getEsquerda().getConteudo()) {
            no.setEsquerda(rotacaoEsquerda(no.getEsquerda()));
            return rotacaoDireita(no);
        }

        // Rotação dupla direita-esquerda
        if (balanceamento < -1 && conteudo < no.getDireita().getConteudo()) {
            no.setDireita(rotacaoDireita(no.getDireita()));
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void exibirArvorePreOrdemRecursivo() {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
        } else {
            System.out.print("Pré-ordem recursiva: ");
            preOrdemRecursivo(raiz);
            System.out.println();
        }
    }

    public void exibirArvorePreOrdem() {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
        } else {
            System.out.print("Pré-ordem: ");
            preOrdem(raiz);
            System.out.println();
        }
    }

    public void exibirArvoreEmOrdemRecursivo() {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
        } else {
            System.out.print("Em ordem recursiva: ");
            emOrdemRecursivo(raiz);
            System.out.println();
        }
    }

    public void exibirArvorePosOrdemRecursivo() {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
        } else {
            System.out.print("Pós-ordem recursiva: ");
            posOrdemRecursivo(raiz);
            System.out.println();
        }
    }

    public int contaNos() {
        return contaNos(raiz);
    }

    private int contaNos(No no) {
        if (no == null) {
            return 0;
        } else {
            return 1 + contaNos(no.getEsquerda()) + contaNos(no.getDireita());
        }
    }

    public int contaNosFolhaRecursivo() {
        return contaNosFolhaRecursivo(raiz);
    }

    private int contaNosFolhaRecursivo(No no) {
        if (no == null) {
            return 0;
        }
        if (no.getEsquerda() == null && no.getDireita() == null) {
            return 1;
        }
        return contaNosFolhaRecursivo(no.getEsquerda()) + contaNosFolhaRecursivo(no.getDireita());
    }

    public int contaNosFolha() {
        return contaNosFolha(raiz);
    }

    private int contaNosFolha(No no) {
        if (no == null)
            return 0;
        Stack<No> pilha = new Stack<>();
        pilha.push(no);

        int contadorNoFolha = 0;

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            if (atual.getEsquerda() == null && atual.getDireita() == null) {
                contadorNoFolha++;
            }
            if (atual.getDireita() != null) {
                pilha.push(atual.getDireita());
            }
            if (atual.getEsquerda() != null) {
                pilha.push(atual.getEsquerda());
            }
        }
        return contadorNoFolha;
    }

    private void preOrdemRecursivo(No no) {
        if (no != null) {
            System.out.print(no.getConteudo() + " ");
            preOrdemRecursivo(no.getEsquerda());
            preOrdemRecursivo(no.getDireita());
        }
    }

    private void emOrdemRecursivo(No no) {
        if (no != null) {
            emOrdemRecursivo(no.getEsquerda());
            System.out.print(no.getConteudo() + " ");
            emOrdemRecursivo(no.getDireita());
        }
    }

    private void posOrdemRecursivo(No no) {
        if (no != null) {
            posOrdemRecursivo(no.getEsquerda());
            posOrdemRecursivo(no.getDireita());
            System.out.print(no.getConteudo() + " ");
        }
    }

    private void preOrdem(No no) {
        if (no == null)
            return;

        Stack<No> pilha = new Stack<>();
        pilha.push(no);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            System.out.print(atual.getConteudo() + " ");

            if (atual.getDireita() != null) {
                pilha.push(atual.getDireita());
            }
            if (atual.getEsquerda() != null) {
                pilha.push(atual.getEsquerda());
            }
        }
    }
}