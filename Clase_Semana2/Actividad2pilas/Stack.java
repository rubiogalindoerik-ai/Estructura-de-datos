public class Stack<T> {
    public Node <T> top; // Tope de la fila
    public int size; // Tamaño de la fila

    public Stack(){
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // Insertar un elemento en la lista
    public void push(T data) {
        Node<T> nuevoNodo = new Node<>(data);
        nuevoNodo.next = top; // El nuevo nodo apunta al antiguo tope
        top = nuevoNodo; // El top se actualiza al nuevo nodo
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
            return null;
        } 
        T datoRemovido = top.data;
        top = top.next; // El top baja al siguiente nodo
        size--;
        return datoRemovido;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
            return null;
        } 
        return top.data;
    }

    public void showStack() {
    // Verfificar si la lista esta vacia
    if (isEmpty()) {
      System.out.println("La lista esta vacia");
      return;
    }
    System.out.print("\nElementos de la pila (de ultimo a primero): ");
    Node <T> actual = top;
    do {
      System.out.print(actual.data + " -> ");
      actual = actual.next;
    } while (actual != null);
    System.out.println("Fin de la pila");
  }
}
