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
  public boolean isEmpty() {
    return head == null;
  }

  // MÉTODO para Pila 
  public void addFirst(T data) {
    Node<T> nuevo = new Node<>(data);
    if (isEmpty()) {
      head = nuevo;
      tail = nuevo;
      if (tipoLista == 3) head.next = head;
    } else {
      if (tipoLista == 1) {
        nuevo.next = head;
        head = nuevo;
      } else if (tipoLista == 2) {
        nuevo.next = head;
        head.prev = nuevo;
        head = nuevo;
      } else if (tipoLista == 3) {
        nuevo.next = head;
        head = nuevo;
        tail.next = head;
      }
    }
    size++;
  }

  // MÉTODO Pop
  public T removeFirst() {
    if (isEmpty()) return null;
    
    T dato = head.data;
    if (size == 1) {
      head = null;
      tail = null;
    } else {
      head = head.next;
      if (tipoLista == 2) head.prev = null;
      if (tipoLista == 3) tail.next = head;
    }
    size--;
    return dato;
  }

  // MÉTODO Peek
  public T getFirst() {
    if (isEmpty()) return null;
    return head.data;
  }

  // Meter datos para Cola
  public void appendNode(T data) {
    Node<T> nuevo = new Node<>(data);
    if (isEmpty()) {
      head = nuevo;
      tail = nuevo;
      if (tipoLista == 3) head.next = head;
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
    if (isEmpty()) {
      System.out.println("La lista esta vacia");
      return;
    }
    Node <T> actual = head;
    if (tipoLista == 2) System.out.print("null <- ");
    do {
      System.out.print(actual.data + " -> ");
      actual = actual.next;
      if (tipoLista == 3 && actual == head) break;
    } while (actual != null);
    
    if (tipoLista == 3) {
      System.out.println("Fin de la lista circular");
    } else {
      System.out.println("null");
    }
  }

  // 4. Buscar elementos
  public boolean search(T data) {
    if (isEmpty()) return false;
    Node <T> actual = head;
    do {
      if (actual.data.equals(data)) return true;
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

    if (size == 1) {
      head = null;
      tail = null;
    } else if (actual == head) {
      head = head.next;
      if (tipoLista == 2) head.prev = null;
      if (tipoLista == 3) tail.next = head;
    } else if (actual == tail) {
      tail = anterior;
      if (tipoLista == 1 || tipoLista == 2) tail.next = null;
      if (tipoLista == 3) tail.next = head;
    } else {
      anterior.next = actual.next;
      if (tipoLista == 2 && actual.next != null) {
        actual.next.prev = anterior;
      }
    }
    size--;
    System.out.println("Elemento eliminado");
  }
}