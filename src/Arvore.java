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
                } 
                else if (atual.getDireita() == null) {
                    atual.setDireita(novo);
                    return;
                } else {
                    atual = atual.getEsquerda();
                }
            }
        }
    }
    
    // imprimi a árvore com a função preOrdem() para exibir para o usuário a árvore em pré-ordem
    public void exibirArvore() {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
        } else {
            System.out.print("Pré-ordem: ");
            preOrdem(raiz);
            System.out.println();
        }
    }

    // exibe a árvore em pré-ordem utilizando recursividade
    private void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.getConteudo() + " ");
            preOrdem(no.getEsquerda());
            preOrdem(no.getDireita());
        }
    }
}
