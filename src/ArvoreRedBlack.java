public class ArvoreRedBlack {
    private NoRedBlack raiz;

    public ArvoreRedBlack() {
        this.raiz = null;
    }

    private boolean ehVermelho(NoRedBlack no) {
        if (no == null)
            return false;
        return no.getCor() == NoRedBlack.VERMELHO;
    }

    private NoRedBlack rotacaoEsquerda(NoRedBlack noDesbalanceado) {
        NoRedBlack noFilhoDireito = noDesbalanceado.getDireita();
        NoRedBlack subArvoreIntermed = noFilhoDireito.getEsquerda();

        noFilhoDireito.setEsquerda(noDesbalanceado);
        noDesbalanceado.setDireita(subArvoreIntermed);

        noFilhoDireito.setCor(noDesbalanceado.getCor());
        noDesbalanceado.setCor(NoRedBlack.VERMELHO);

        return noFilhoDireito;
    }

    private NoRedBlack rotacaoDireita(NoRedBlack noDesbalanceado) {
        NoRedBlack noFilhoEsquerdo = noDesbalanceado.getEsquerda();
        NoRedBlack subArvoreIntermed = noFilhoEsquerdo.getDireita();

        noFilhoEsquerdo.setDireita(noDesbalanceado);
        noDesbalanceado.setEsquerda(subArvoreIntermed);

        noFilhoEsquerdo.setCor(noDesbalanceado.getCor());
        noDesbalanceado.setCor(NoRedBlack.VERMELHO);

        return noFilhoEsquerdo;
    }

    private void inverterCores(NoRedBlack no) {
        no.setCor(NoRedBlack.VERMELHO);
        if (no.getEsquerda() != null) {
            no.getEsquerda().setCor(NoRedBlack.PRETO);
        }
        if (no.getDireita() != null) {
            no.getDireita().setCor(NoRedBlack.PRETO);
        }
    }

    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
        if (raiz != null) {
            raiz.setCor(NoRedBlack.PRETO); // Raiz sempre preta
        }
    }

    private NoRedBlack inserir(NoRedBlack noAtual, int valor) {
        if (noAtual == null) {
            return new NoRedBlack(valor); // novo nó vermelho por padrão no construtor
        }

        if (valor < noAtual.getConteudo()) {
            noAtual.setEsquerda(inserir(noAtual.getEsquerda(), valor));
        } else if (valor > noAtual.getConteudo()) {
            noAtual.setDireita(inserir(noAtual.getDireita(), valor));
        } else {
            // Ignora duplicatas
            return noAtual;
        }

        if (ehVermelho(noAtual.getDireita()) && !ehVermelho(noAtual.getEsquerda())) {
            noAtual = rotacaoEsquerda(noAtual);
        }

        if (ehVermelho(noAtual.getEsquerda()) && ehVermelho(noAtual.getEsquerda().getEsquerda())) {
            noAtual = rotacaoDireita(noAtual);
        }

        if (ehVermelho(noAtual.getEsquerda()) && ehVermelho(noAtual.getDireita())) {
            inverterCores(noAtual);
        }

        return noAtual;
    }

    public void exibirPreOrdem() {
        System.out.print("Pré-ordem: ");
        preOrdem(raiz);
        System.out.println();
    }

    private void preOrdem(NoRedBlack no) {
        if (no != null) {
            System.out.print(no.getConteudo() + "(" + (no.getCor() ? "V" : "P") + ") ");
            preOrdem(no.getEsquerda());
            preOrdem(no.getDireita());
        }
    }
}
