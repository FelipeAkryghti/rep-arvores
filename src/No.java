public class No {
    private String conteudo;
    private No esquerda;
    private No direita;
    private int fatorDeBalanceamento;

    public No(String conteudo){
        this.conteudo = conteudo;
        this.esquerda = null;
        this.direita = null;
        this.fatorDeBalanceamento = 0;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
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
