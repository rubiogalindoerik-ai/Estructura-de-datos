public class Pila<T> {
    private ListaEnlazada<T> lista;

    public Pila() {
        this.lista = new ListaEnlazada<>(1);
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }

    public void push(T data) {
        lista.addFirst(data);
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Pila vacia");
            return null;
        }
        return lista.removeFirst();
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Pila vacia");
            return null;
        }
        return lista.getFirst();
    }

    public int getSize() {
        return lista.size;
    }

    public void mostrarPila() {
        if (isEmpty()) {
            System.out.println("Pila vacia");
            return;
        }
        System.out.print("Tope de la Pila -> ");
        lista.showlist();
    }
}