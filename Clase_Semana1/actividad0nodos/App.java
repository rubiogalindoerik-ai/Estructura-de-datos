public class App {
  public static void main(String[] args) throws Exception {
    // Creando los nodos
    Node<Integer> n1 = new Node<Integer>(10);
    Node<Integer> n2 = new Node<Integer>(20);
    Node<Integer> n3 = new Node<Integer>(30);

    // Conectar los nodos
    n1.next = n2;
    n2.next = n3;

    // Rrcorrido de los nodos
    Node<Integer> actual = n1;
    while (actual != null) {
      System.out.println("Datos: " + actual.data);
      actual = actual.next;
    }
  }
}
