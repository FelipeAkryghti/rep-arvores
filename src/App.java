public class App {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        arvore.inserirNo("C");
        arvore.inserirNo("A");
        arvore.inserirNo("B");
        arvore.inserirNo("D");

        arvore.exibirArvore(); // Deve imprimir: A B C D
    }
}
