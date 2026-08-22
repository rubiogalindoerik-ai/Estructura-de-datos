public class Cola<T> {
    private ListaEnlazada<T> lista;

    public Cola() {
        this.lista = new ListaEnlazada<>(1);
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }

    public void enqueue(T data) {
        lista.appendNode(data);
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow: Nada que mostrar");
            return null;
        }
        return lista.removeFirst();
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue underflow: Nada que mostrar");
            return null;
        }
        return lista.getFirst();
    }

    public int getSize() {
        return lista.size;
    }

    public void mostrarCola() {
        if (isEmpty()) {
            System.out.println("Cola vacia. Nada que mostrar.");
            return;
        }
        System.out.print("Frente de la Cola -> ");
        lista.showlist();
    }
}