public class HistorialNavegacion {
    public Node<String> top;
    public int size;

    public HistorialNavegacion() {
        this.top = null;
        this.size = 0;
    }

    // metodo push
    public void visitaPagina(String url) {
        Node<String> nuevoNodo = new Node<String>(url);
        nuevoNodo.next = top;
        top = nuevoNodo;
        size++;
    }

    /// metodo verificar si esta vacia
    public boolean isEmpty() {
        return top == null;
    }

    // Metodo pop (Borrar ultima pagina visistada)
    // borrarUltima
    public String borrarUltima() {
        if (isEmpty()) {
            System.out.println("El historial esta vacio");
            return null;
        }
        String paginaCerrada = top.data;
        top = top.next;
        size--;
        System.out.println("Borrando ultima pagina visitada");
        return paginaCerrada;
    }

    // Metodo peek (ver la ultima pagina visitada)
    // mostrarUltima
    public String mostrarUltima(){
        if (isEmpty()) return "El historial esta vacio";
        return top.data;
    }

    // Metodo mostrarHistorial (muestra toda la pila)
    public void mostrarHistorial() {
        if(isEmpty()) {
            System.out.println("El historial esta vacio");
            return;
        }
        Node<String> nodoActual = top;
        System.out.print("Tope de la pila -> ");
        while (nodoActual != null) {
            System.out.println(nodoActual + " -> ");
            nodoActual = nodoActual.next;
        }
        System.out.println(" Fondo de la pila");
    }
}
