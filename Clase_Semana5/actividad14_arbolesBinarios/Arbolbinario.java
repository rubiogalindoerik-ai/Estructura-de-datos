public class Arbolbinario {
    public static class Nodo {
        int data;
        Nodo left;
        Nodo right;

        public Nodo(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Nodo raiz;

    public Arbolbinario() {
        this.raiz = null;
    }

    // Metodo de insercion
    private Nodo insertarRecursivo(Nodo actual, int dato) {
        // Caso Base: Si llegamos a un espacio vacio, creamos el nuevo nodo ahi
        if (actual == null) {
            return new Nodo(dato);
        }
        // Si el dato es menor, va a la izquierda
        if (dato < actual.data) {
            actual.left = insertarRecursivo(actual.left, dato);
        }
        // Si el dato es mayor, va a la derecha
        else if (dato >= actual.data) {
            actual.right = insertarRecursivo(actual.right, dato);
        }
        return actual;
    }

    public void insertar(int dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    // Recorridos
    public void preOrdenRecursivo(Nodo nodo) {
        if (nodo == null) return;
        System.out.println(nodo.data + " ");
        preOrdenRecursivo(nodo.left);
        preOrdenRecursivo(nodo.right);
    }

    public void postOrdenRecursivo(Nodo nodo) {
        if (nodo == null) return;
        postOrdenRecursivo(nodo.left);
        postOrdenRecursivo(nodo.right);
        System.out.println(nodo.data + " ");
    }

    public void inOrdenRecursivo(Nodo nodo) {
        if (nodo == null) return;
        inOrdenRecursivo(nodo.left);
        System.out.println(nodo.data + " ");
        inOrdenRecursivo(nodo.right);
    }    

    public void mostrarPreOrden() {
        System.out.println("PreOrden: ");
        preOrdenRecursivo(raiz);
        System.out.println();
    }

    public void mostrarPostOrden() {
        System.out.println("PostOrden: ");
        postOrdenRecursivo(raiz);
        System.out.println();
    }

    public void mostrarInOrden() {
        System.out.println("InOrden: ");
        inOrdenRecursivo(raiz);
        System.out.println();
    }

    public static void main(String[] args) throws Exception{
        Arbolbinario arbol = new Arbolbinario();

        int[] valores = {50,30,70,20,40,60,80};

        System.out.println("Insertando elenmentos en el arbol");
        for(int v: valores) {
            arbol.insertar(v);
            System.out.println(v + " ");
        }
        System.out.println("\n");
        System.out.println("Probando los recorridos: ");
        arbol.mostrarPreOrden();
        arbol.mostrarPostOrden();
        arbol.mostrarInOrden();
    }
}
