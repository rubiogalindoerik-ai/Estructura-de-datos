
// Clase generica para representar un nodo
public class Node<T> {
  public T data; // El dato del nodo
  public Node<T> next; // El enlace al siguiente nodo(apuntador)
  public Node<T> prev; // El enlace para el enlace anterior(apuntador)
  
  // Constructor
  public Node(T data){
    this.data = data;
    this.next = null;
    this.prev = null;
  }

  // Metodos
  // Metodo para mostrar el dato
  public String toString() {
    // Operadores ternarios
    return data != null ? data.toString() : "Null";
  }
}

class Main {
  public static void main(String[] args) {
  
  }
}

