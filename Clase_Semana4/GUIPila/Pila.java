public class Pila<T> {
    public static class Nodo<T> {
        public T data;
        public Nodo<T> next;
        
        public Nodo(T data) {
            this.data = data;
            this.next = null;
        }
    }
    private Nodo<T> cima;
    private int size;

    public Pila(){
        this.cima = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return cima==null; 
    }

    public void push(T data){
        Nodo<T> nuevo = new Nodo<>(data);
        nuevo.next = cima;
        cima = nuevo;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T datoRemovido = cima.data;
        cima=cima.next;
        size--;
        return datoRemovido;
    }

    public T peek() {
        if (isEmpty()) return null;
        return cima.data;
    }

    public String mostrarPila() {
        if (isEmpty()) return "[La pila esta vacia]\n";
        // Clase mutable que permite crear y modificar secuencias de caracteres de manera eficiente sin generar nuevos objetos en la memoria
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = cima;
        boolean esCima = true;
        while (actual != null) {
            if (esCima) {
                sb.append(" <- Cima").append(actual.data).append("\n");
                esCima = false;
            } else {
                sb.append("     ").append(actual.data).append("\n");
            }
            actual = actual.next;
        }
        return sb.toString();
    }
}
