public class NoRedBlack {
    public static final boolean VERMELHO = true;
    public static final boolean PRETO = false;

    private int conteudo;
    private NoRedBlack esquerda;
    private NoRedBlack direita;
    private boolean cor;

    public NoRedBlack(int conteudo) {
        this.conteudo = conteudo;
        this.esquerda = null;
        this.direita = null;
        this.cor = VERMELHO;
    }

    public int getConteudo() {
        return conteudo;
    }

    public void setConteudo(int conteudo) {
        this.conteudo = conteudo;
    }

    public NoRedBlack getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoRedBlack esquerda) {
        this.esquerda = esquerda;
    }

    public NoRedBlack getDireita() {
        return direita;
    }

    public void setDireita(NoRedBlack direita) {
        this.direita = direita;
    }

    public boolean getCor() {
        return cor;
    }

    public void setCor(boolean cor) {
        this.cor = cor;
    }
}
