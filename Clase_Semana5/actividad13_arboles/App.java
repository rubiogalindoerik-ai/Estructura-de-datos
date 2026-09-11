public class App {
    public static void main(String[] args) throws Exception {
        Nodo raiz = new Nodo(1);
        raiz.left = new Nodo(2);
        raiz.right = new Nodo(3);
        raiz.left.left = new Nodo(4);
        raiz.right.right = new Nodo(5);
        raiz.left.right = new Nodo(6);
        raiz.right.left = new Nodo(7);
        System.out.println("Preorden");
        Nodo.preOrden(raiz);
        System.out.println("Postorden");
        Nodo.postOrden(raiz);
        System.out.println("Inorden");
        Nodo.inOrden(raiz);
    }
}
