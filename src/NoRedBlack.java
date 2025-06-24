public class NoRedBlack {
    public static final boolean VERMELHO = true;
    public static final boolean PRETO = false;

    private int conteudo;
    private boolean cor;
    private NoRedBlack esquerda;
    private NoRedBlack direita;
    private NoRedBlack pai;

    public NoRedBlack(int valor) {
        this.conteudo = valor;
        this.cor = VERMELHO;
        this.esquerda = null;
        this.direita = null;
    }

    public int getConteudo() {
        return conteudo;
    }

    public boolean getCor() {
        return cor;
    }

    public void setCor(boolean cor) {
        this.cor = cor;
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

    public NoRedBlack getPai() {
        return pai;
    }

    public void setPai(NoRedBlack pai) {
        this.pai = pai;
    }
    
}
