public class Pila<T> {
    public Node<T> top;
    public int size;

    public Pila() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push (T data) {
        Node<T> nuevoNodo = new Node<>(data);

        nuevoNodo.next = top;
        top = nuevoNodo;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Pila vacia");
            return null;
        }
        T datoRemovido = top.data;
        top = top.next;
        size--;
        return datoRemovido;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Pila vacia");
        }
        return top.data;
    } 

    public int getSize() {
        return size;
    }

    public void mostrarPila() {
        if (isEmpty()) {
            System.out.println("Pila vacia");
        }
        Node<T> nodoActual = top;
        System.out.print("Cima de la pila -> ");
        while (nodoActual != null) {
            System.out.println(nodoActual.data + " -> ");
            nodoActual = nodoActual.next;
        }
        System.out.println("Fondo de la pilas");
    }
}
