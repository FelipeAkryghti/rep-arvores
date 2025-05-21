public class App {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        arvore.inserirNo("A");
        arvore.inserirNo("B");
        arvore.inserirNo("C");
        arvore.inserirNo("D");
        arvore.inserirNo("E");
        arvore.inserirNo("F");

        arvore.exibirArvorePreOrdem(); // saída esperada: A B D F E C (pré-ordem)

        System.out.println("Total de nós: " + arvore.contaNos()); // Deve mostrar 6

        arvore.exibirArvoreEmOrdem(); // saída esperada é F D B E A C (em-ordem)
    }
}