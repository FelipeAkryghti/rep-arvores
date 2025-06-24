public class ArvoreRedBlack {
    private NoRedBlack raiz;

    public void inserir(int valor) {
        NoRedBlack novo = new NoRedBlack(valor);
        NoRedBlack y = null;
        NoRedBlack x = raiz;

        while (x != null) {
            y = x;
            if (valor < x.getConteudo()) x = x.getEsquerda();
            else x = x.getDireita();
        }

        novo.setPai(y);

        if (y == null) {
            raiz = novo;
        } else if (valor < y.getConteudo()) {
            y.setEsquerda(novo);
        } else {
            y.setDireita(novo);
        }

        novo.setEsquerda(null);
        novo.setDireita(null);
        novo.setCor(NoRedBlack.VERMELHO);

        insertFix(novo);
    }

    private void insertFix(NoRedBlack z) {
        while (z.getPai() != null && z.getPai().getCor() == NoRedBlack.VERMELHO) {
            if (z.getPai() == z.getPai().getPai().getEsquerda()) {
                NoRedBlack y = z.getPai().getPai().getDireita();
                if (y != null && y.getCor() == NoRedBlack.VERMELHO) {
                    z.getPai().setCor(NoRedBlack.PRETO);
                    y.setCor(NoRedBlack.PRETO);
                    z.getPai().getPai().setCor(NoRedBlack.VERMELHO);
                    z = z.getPai().getPai();
                } else {
                    if (z == z.getPai().getDireita()) {
                        z = z.getPai();
                        rotacaoEsquerda(z);
                    }
                    z.getPai().setCor(NoRedBlack.PRETO);
                    z.getPai().getPai().setCor(NoRedBlack.VERMELHO);
                    rotacaoDireita(z.getPai().getPai());
                }
            } else {
                NoRedBlack y = z.getPai().getPai().getEsquerda();
                if (y != null && y.getCor() == NoRedBlack.VERMELHO) {
                    z.getPai().setCor(NoRedBlack.PRETO);
                    y.setCor(NoRedBlack.PRETO);
                    z.getPai().getPai().setCor(NoRedBlack.VERMELHO);
                    z = z.getPai().getPai();
                } else {
                    if (z == z.getPai().getEsquerda()) {
                        z = z.getPai();
                        rotacaoDireita(z);
                    }
                    z.getPai().setCor(NoRedBlack.PRETO);
                    z.getPai().getPai().setCor(NoRedBlack.VERMELHO);
                    rotacaoEsquerda(z.getPai().getPai());
                }
            }
        }
        raiz.setCor(NoRedBlack.PRETO);
    }

    private void rotacaoEsquerda(NoRedBlack x) {
        NoRedBlack y = x.getDireita();
        x.setDireita(y.getEsquerda());
        if (y.getEsquerda() != null) y.getEsquerda().setPai(x);

        y.setPai(x.getPai());

        if (x.getPai() == null) raiz = y;
        else if (x == x.getPai().getEsquerda()) x.getPai().setEsquerda(y);
        else x.getPai().setDireita(y);

        y.setEsquerda(x);
        x.setPai(y);
    }

    private void rotacaoDireita(NoRedBlack y) {
        NoRedBlack x = y.getEsquerda();
        y.setEsquerda(x.getDireita());
        if (x.getDireita() != null) x.getDireita().setPai(y);

        x.setPai(y.getPai());

        if (y.getPai() == null) raiz = x;
        else if (y == y.getPai().getDireita()) y.getPai().setDireita(x);
        else y.getPai().setEsquerda(x);

        x.setDireita(y);
        y.setPai(x);
    }

    public NoRedBlack buscar(int valor) {
        NoRedBlack atual = raiz;
        while (atual != null && atual.getConteudo() != valor) {
            if (valor < atual.getConteudo()) atual = atual.getEsquerda();
            else atual = atual.getDireita();
        }
        return atual;
    }

    // ... (continua com remoção e deleteFix usando getters/setters)

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