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


    public void exibirArvorePreOrdem() {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
        } else {
            System.out.print("Pré-ordem: ");
            preOrdem(raiz);
            System.out.println();
        }
    }
    public void exibirArvoreEmOrdem() {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
        } else {
            System.out.print("Em ordem: ");
            emOrdem(raiz);
            System.out.println();
        }
    }
    public void exibirArvorePosOrdem() {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
        } else {
            System.out.print("Pós-ordem: ");
            posOrdem(raiz);
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

    
    private void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.getConteudo() + " ");
            preOrdem(no.getEsquerda());
            preOrdem(no.getDireita());
        }
    }

    private void emOrdem(No no) {
        if (no != null){
            emOrdem(no.getEsquerda());
            System.out.print(no.getConteudo() + " ");
            emOrdem(no.getDireita());
        }
    }

    private void posOrdem(No no){
        if (no != null){
            posOrdem(no.getEsquerda());
            posOrdem(no.getDireita());
            System.out.print(no.getConteudo() + " ");
        }
    }

}