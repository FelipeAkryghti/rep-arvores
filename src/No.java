public class No {
    private int conteudo;
    private No esquerda;
    private No direita;
    private int fatorDeBalanceamento;

    public No(int conteudo){
        this.conteudo = conteudo;
        this.esquerda = null;
        this.direita = null;
        this.fatorDeBalanceamento = 0;
    }

    public int getConteudo() {
        return conteudo;
    }

    public void setConteudo(int conteudo) {
        this.conteudo = conteudo;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public int getFatorDeBalanceamento() {
        return fatorDeBalanceamento;
    }

    public void setFatorDeBalanceamento(int fatorDeBalanceamento) {
        this.fatorDeBalanceamento = fatorDeBalanceamento;
    }

   

}
