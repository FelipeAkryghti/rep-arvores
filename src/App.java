public class App {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        arvore.inserirNo("A");
        arvore.inserirNo("B");
        arvore.inserirNo("C");
        arvore.inserirNo("D");
        arvore.inserirNo("E");
        arvore.inserirNo("F");

        System.out.println("Total de nós: " + arvore.contaNos());
        System.out.println("Total de nós folha: " + arvore.contaNosFolha());
        System.out.println("Total de nós folha " + arvore.contaNosFolhaRecursivo());
    }
}