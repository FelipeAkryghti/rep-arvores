import java.util.Stack;

public class Arvore {
    private No raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void inserirNo(String elemento) {
        No novo = new No(elemento);
        if (raiz == null) {
            raiz = novo;
            return;
        } else {
            No atual = raiz;
            while (true) {
                if (atual.getEsquerda() == null) {
                    atual.setEsquerda(novo);
                    return;
                } else if (atual.getDireita() == null) {
                    atual.setDireita(novo);
                    return;
                } else {
                    atual = atual.getEsquerda();
                }
            }
        }
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