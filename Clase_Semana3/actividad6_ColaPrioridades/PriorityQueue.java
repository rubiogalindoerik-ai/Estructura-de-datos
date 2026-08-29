public class PriorityQueue<T> {
    public NodePrioridad<T> front;
    public int size;

    public PriorityQueue() {
        this.front = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(T data, int prioridad) {
        NodePrioridad<T> nuevo = new NodePrioridad<>(data, prioridad);
        // Verificamos si la cola esta vacia o si el nueva elemento
        // tiene mayor prioridad
        if (isEmpty() || prioridad < front.prioridad) {
            nuevo.next = front;
            front = nuevo;
        } else {
            // Buscar el lugar correcto del elemento
            NodePrioridad<T> actual = front;
            while (actual.next != null && actual.next.prioridad <= prioridad) {
                actual = actual.next;
            }
            // Insertar el nodo en el lugar correcto
            nuevo.next = actual.next;
            actual.next = nuevo;
        }
        size++;
        System.out.println("Elemento agregado correctamente");
    }

    // Metodo dequeue
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Nada que atender");
            return null;
        }
        T atendido = front.data;
        front = front.next;
        size--;
        System.out.println("Atendiendo el elemento con mayor priridad");
        return atendido;
    } 

    public T peek() {
        if (isEmpty()) {
            System.out.println("No hay nada que mostrar");
            return null;
        }
        return front.data; 
    }

    public void mostrar() {
        if (isEmpty()) {
            System.out.println("Nada que mostrar");
            return;
        }
        NodePrioridad<T> actual = front;
        System.out.println("Frente -> ");
        while (actual != null) {
            System.out.println(actual.data + " -> ");
            actual = actual.next;
        }
        System.out.println("FIN");
    }
}
