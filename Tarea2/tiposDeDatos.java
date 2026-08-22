public class tiposDeDatos {
  public static void demostrarTipos() {
    System.out.println("\nDemostracion de diferentes tipos de datos y listas");
    // 1. Tipos de datos primitivos
    ListaEnlazada<Integer> listaPrimitivos = new ListaEnlazada<>(1);
    listaPrimitivos.appendNode(1);
    listaPrimitivos.appendNode(2);
    listaPrimitivos.appendNode(3);
    System.out.print("Lista de numeros enteros: ");
    listaPrimitivos.showlist();
    // 2. Tipos de datos complejos
    ListaEnlazada<String> listaComplejos = new ListaEnlazada<>(2);
    listaComplejos.appendNode("Hola");
    listaComplejos.appendNode("Buenas tardes");
    listaComplejos.appendNode("Adios");
    System.out.print("Lista de palabras: ");
    listaComplejos.showlist();
    // 3. Tipos abstractos
    ListaEnlazada<Contactos> listaAbstractos = new ListaEnlazada<>(3);
    listaAbstractos.appendNode(new Contactos("Erick", "Felipe Sevilla 213", "4424635378"));
    listaAbstractos.appendNode(new Contactos("Vale", "Palermo 107", "4424777457"));
    listaAbstractos.appendNode(new Contactos("Daisy", "1 de Mayo", "4424644984"));
    System.out.print("Lista datos abstractos: ");
    listaAbstractos.showlist();
  }
}
