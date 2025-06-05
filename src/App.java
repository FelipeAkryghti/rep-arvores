public class App {
    public static void main(String[] args) {
        // implementação de arvore avl
        Arvore arvore = new Arvore();
        arvore.inserirNo(10);
        arvore.inserirNo(20);
        arvore.inserirNo(30);

        arvore.exibirArvorePreOrdemRecursivo();
    }
}