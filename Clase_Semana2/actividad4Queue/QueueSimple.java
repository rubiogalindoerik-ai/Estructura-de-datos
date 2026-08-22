public class QueueSimple {
    public Node<String> front;
    public Node<String> back;
    public int size;

    public QueueSimple() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    /// Enqueue(push) - Una persona llega a la fila
    public void enqueue(String nombre) {
        Node<String> nuevoNodo = new Node<String>(nombre);
        if (isEmpty()) {
            front = nuevoNodo;
            back = nuevoNodo;
        } else {
            back.next = nuevoNodo;
            back = nuevoNodo;
        }
        size++;
    }

    /// Dequeue(pop) - Atendeer a la primera persona de la fila
    public String dequeue(){
        if (isEmpty()) {
            System.out.println("La fila esta vacia");
            return null;
        }
        String atendido = front.data;
        front = front.next;
        if (front == null) {
            back = null;
        }
        size--;
        System.out.println("Atendiendo a " + atendido);
        return atendido;
    }

    ///Peek
    public String peek() {
        if (isEmpty()) return "La fila esta vacia";
        return front.data;
    }

    /// Mostrar la fila
    public void mostrarFila() {
        if (isEmpty()) {
            System.out.println("La fila esta vacia");
            return;
        }
        Node<String> nodoActual = front;
        System.out.println("Inicio de la fila -> ");
        while (nodoActual != null) {
            System.out.println(nodoActual.data + " -> ");
            nodoActual = nodoActual.next;
        }
        System.out.println("Final de la fila");
    }
}
