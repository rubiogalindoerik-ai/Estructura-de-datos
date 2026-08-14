public class tiposDeDatos {
  public static void demostrarTipos() {
    System.out.println("Demostracion de diferentes tipos de datos");
    // 1. Tipos de datos primitivos
    ListaEnlazada<Integer> listaPrimitivos = new ListaEnlazada<>(1);
    listaPrimitivos.appendNode(1);
    listaPrimitivos.appendNode(2);
    listaPrimitivos.appendNode(3);
    System.out.print("Lista de numeros enteros: ");
    listaPrimitivos.showlist();
    // 2. Tipos de datos complejos
    ListaEnlazada<String> listaComplejos = new ListaEnlazada<>(1);
    listaComplejos.appendNode("Hola");
    listaComplejos.appendNode("Buenas tardes");
    listaComplejos.appendNode("Adios");
    System.out.print("Lista de palabras: ");
    listaComplejos.showlist();
    // 3. Tipos abstractos
    ListaEnlazada<Alumnos> listaAbstractos = new ListaEnlazada<>(1);
    listaAbstractos.appendNode(new Alumnos("Erick", "4424635378", "AL07181596", "al07181596@tecmilenio.mx"));
    listaAbstractos.appendNode(new Alumnos("Vale", "4424777457", "AL07111813", "al07181596@tecmilenio.mx"));
    listaAbstractos.appendNode(new Alumnos("Daisy", "4424644984", "AL07616845", "al07181596@tecmilenio.mx"));
    System.out.print("Lista datos abstractos: ");
    listaAbstractos.showlist();
  }
}
