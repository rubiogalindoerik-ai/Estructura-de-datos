public class Cola<T> {
    public Node<T> front;
    public Node<T> back;
    public int size;

    public Cola() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    } 

    public void enqueue(T data) {
        Node<T> nuevoNodo = new Node<>(data);
        if (isEmpty()) {
            front = nuevoNodo;
            back = nuevoNodo;
        } else {
            back.next = nuevoNodo;
            back = nuevoNodo;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow: Nada de que mostrar");
            return null;
        }
        T dataRemovido = front.data;
        front = front.next;
        if (front == null) {
            back = null;
        }
        size--;
        return dataRemovido;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue underflow: Nada de que mostrar");
            return null;
        }
        return front.data;
    }

    public int getSize() {
        return size;
    }

    public void mostrarPila() {
        if (isEmpty()) {
            System.out.println("Nada que vacia");
        }
        Node<T> nodoActual = front;
        System.out.print("Primer elemento -> ");
        while (nodoActual != null) {
            System.out.println(nodoActual.data + " -> ");
            nodoActual = nodoActual.next;
        }
        System.out.println("Ultimo elemento");
    }
}
