public class ListaEnlazada<T> {
  public Node<T> head;
  public Node<T> tail; // Listas circulares
  public int tipoLista; // 1. Simples 2. Doble 3. Circulares
  public int size;

  // Constructor
  public ListaEnlazada(int tipoLista) {
    this.tipoLista = tipoLista;
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  // Metodos
  // 1. Saber si la lista esta vacia
  public boolean isEmpty() {
    return head == null;
  }

  // 2. Insercion de nodos(datos) al final de la lista
  public void appendNode(T data) {
    Node<T> nuevo = new Node<>(data);
    // Verficar si la lista esta vacia
    if (isEmpty()) {
      head = nuevo;
      tail = nuevo;
      // Unicamente para listas circulares
      if (tipoLista == 3) {
        head.next = head;
      }
    } else {
      if (tipoLista == 1 ) {
        Node<T> actual = head;
        while (actual.next != null) {
          actual = actual.next;
        }
        actual.next = nuevo;
        tail = nuevo;
      } else if (tipoLista == 2) {
        tail.next = nuevo;
        nuevo.prev = tail;
        tail = nuevo;
      } else if (tipoLista == 3) {
        tail.next = nuevo;
        tail = nuevo;
        nuevo.next = head;
      }
    }
    size++;
  }

  // 3. Mostrar los elementos de las listas
  public void showlist() {
    // Verfificar si la lista esta vacia
    if (isEmpty()) {
      System.out.println("La lista esta vacia");
      return;
    }
    System.out.print("Elementos de la lista: ");
    Node <T> actual = head;
    do {
      System.out.print(actual.data + " -> ");
      // 1 -> 2 -> 3
      actual = actual.next;
      if (tipoLista == 3 && actual == head) {
        break;
      }
    } while (actual != null);
    if (tipoLista == 3) {
      System.out.println("Fin de la lista circular");
    } else {
      System.out.println("null");
    }
  }

  // 4. Buscar elementos
  public boolean search(T data) {
    // Verfificar si la lista esta vacia
    if (isEmpty()) return false;
    Node <T> actual = head;
    do {
      if (actual.data.equals(data)) {
        return true;
      }
      actual = actual.next;
      if (tipoLista == 3 && actual == head) break;
    } while (actual != null);
    return false;
  }

  // 5. Eliminar algun dato
  public void delete(T data) {
    if (isEmpty()) {
      System.out.println("La lista esta vacia");
      return;
    }
    Node<T> actual = head;
    Node<T> anterior = null;
    boolean encontrado = false;
    // i
    do {
      if (actual.data.equals(data)) {
        encontrado = true;
        break;
      }
      anterior = actual;
      actual = actual.next;
      if (tipoLista == 3 && actual == head) break;
    } while (actual != null);
    if (!encontrado) {
      System.out.println("Elemento no encontrado");
      return;
    }
    // Caso cuando solo hay un elemento
    if (size == 1) {
      head = null;
      tail = null;
    } else if (actual == head) { // Eliminar el primer elemento
      head = head.next;
      if (tipoLista == 2) head.prev = null;
      if (tipoLista == 3) tail.next = head;
    } else if (actual == tail) { // Eliminar el ultimo elemmento
      tail = anterior;
      if (tipoLista == 2) tail.next = null;
      if (tipoLista == 3) tail.next = head;
    } else { // Eliminar algun dato de en medio de la lista
      anterior.next = actual.next;
      if (tipoLista == 2 && actual.next != null) {
        actual.next.prev = anterior;
      }
    }
    size--;
    System.out.println("Elemento eliminado");
  }
}
