public class App {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        arvore.inserirNo("C");
        arvore.inserirNo("A");
        arvore.inserirNo("B");
        arvore.inserirNo("D");

        arvore.exibirArvore(); // saída esperada: C A B D (pré-ordem)

        System.out.println("Total de nós: " + arvore.contaNos()); // Deve exibir: 4
    }
}