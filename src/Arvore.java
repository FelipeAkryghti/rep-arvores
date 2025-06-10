import java.util.Stack;

public class Arvore {
    private No raiz;

    public Arvore() {
        this.raiz = null;
    }

    // Métodos auxiliares para implementação dos métodos de Inserção e Remoção que não dependem da instância de árvore
    private static int altura(No no) {
        if (no == null) {
            return 0;
        } else {
            return no.getAltura();
        }
    }

    private static void atualizarAlturaNo(No no) {
        int alturaEsquerda = altura(no.getEsquerda());
        int alturaDireita = altura(no.getDireita());

        if (alturaEsquerda > alturaDireita) {
            no.setAltura(alturaEsquerda + 1);
        } else {
            no.setAltura(alturaDireita + 1);
        }
    }

    private static int getBalanceamento(No no) {
        if (no == null) {
            return 0;
        }
        return altura(no.getEsquerda()) - altura(no.getDireita());
    }

    private static No encontrarMenor(No no) {
        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no;
    }

    // Métodos de Rotação para balanceamento da Árvore AVL
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

    //Método de Inserção
    public void inserirNo(int elemento) {
        raiz = inserirNo(raiz, elemento);
    }

    private No inserirNo(No no, int conteudo) {
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

        atualizarAlturaNo(no);

        int balanceamento = getBalanceamento(no);

        // Verifica o balanceamento e realiza as rotações caso necessárias
        // Rotação simples à esquerda
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

    // Método de Remoção
    public void removerNo(int conteudo) {
        raiz = removerNo(raiz, conteudo);
    }

    private No removerNo(No no, int conteudo) {
        if (no == null) {
            return null;
        }

        if (conteudo < no.getConteudo()) {
            no.setEsquerda(removerNo(no.getEsquerda(), conteudo));
        } else if (conteudo > no.getConteudo()) {
            no.setDireita(removerNo(no.getDireita(), conteudo));
        } else {
            if (no.getEsquerda() == null) {
                return no.getDireita();
            } else if (no.getDireita() == null) {
                return no.getEsquerda();
            }

            No sucessor = encontrarMenor(no.getDireita());
            no.setConteudo(sucessor.getConteudo());
            no.setDireita(removerNo(no.getDireita(), sucessor.getConteudo()));
        }

        atualizarAlturaNo(no);

        int balanceamento = getBalanceamento(no);

        if (balanceamento > 1 && getBalanceamento(no.getEsquerda()) >= 0) {
            return rotacaoDireita(no);
        }

        if (balanceamento > 1 && getBalanceamento(no.getEsquerda()) < 0) {
            no.setEsquerda(rotacaoEsquerda(no.getEsquerda()));
            return rotacaoDireita(no);
        }

        if (balanceamento < -1 && getBalanceamento(no.getDireita()) <= 0) {
            return rotacaoEsquerda(no);
        }

        if (balanceamento < -1 && getBalanceamento(no.getDireita()) > 0) {
            no.setDireita(rotacaoDireita(no.getDireita()));
            return rotacaoEsquerda(no);
        }

        return no;
    }

    // Métodos de Exibição
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

    // Métodos de Percuros Iterativos e Recursivos
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

    // Métodos de Contagem de Nós
    public int contaNos() {
        return contaNosRecursivo(raiz);
    }

    private int contaNosRecursivo(No no) {
        if (no == null) {
            return 0;
        } else {
            return 1 + contaNosRecursivo(no.getEsquerda()) + contaNosRecursivo(no.getDireita());
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
}