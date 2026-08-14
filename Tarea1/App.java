import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("\n-- Menu --");
      System.out.println("1. Ejemplos de tipos de datos y listas"); 
      System.out.println("2. Sistema de gestion de contactos");
      System.out.println("3. Salir");
      int opmenu = scanner.nextInt();
      scanner.nextLine();
      if (opmenu == 1) {
        tiposDeDatos.demostrarTipos();
      } else if (opmenu == 2) {
        menuContactos(scanner);
      } else if (opmenu == 3) {
        System.out.println("Saliendo...");
        break;
      } else {
        System.out.println("Opcion no valida");
      }
    }
    scanner.close();
  }

  public static void menuContactos (Scanner scanner) {
    System.out.println("\n¿Qué tipo de lista deseas usar para los contactos?");
    System.out.println("1. Simple");
    System.out.println("2. Doble");
    System.out.println("3. Circular");
    System.out.print("Opcion: ");
    int tipoLista = scanner.nextInt();
    scanner.nextLine(); 
    ListaEnlazada<Contactos> listaContactos = new ListaEnlazada<>(tipoLista);
    int op = 0;
    do {
      System.out.println("\n-- Gestion de Contactos --");
      System.out.println("1. Agregar contacto");
      System.out.println("2. Mostrar contactos");
      System.out.println("3. Eliminar un contacto");
      System.out.println("4. Buscar un contacto");
      System.out.println("5. Regresar al menu principal");
      System.out.print("Opcion: ");
      op = scanner.nextInt();
      scanner.nextLine(); 

      switch (op) {
        case 1:
          System.out.print("Nombre: ");
          String nombre = scanner.nextLine();
          System.out.print("Direccion: ");
          String direccion = scanner.nextLine();
          System.out.print("Telefono: ");
          String telefono = scanner.nextLine();
          listaContactos.appendNode(new Contactos(nombre, direccion, telefono));
          System.out.println("Contacto agregado");
          break;
        case 2:
          listaContactos.showlist();
          break;
        case 3:
          if (listaContactos.isEmpty()) {
            System.out.println("La lista esta vacia");
            break;
          }
          listaContactos.showlist();
          System.out.print("Escribe el nombre del contacto a borrar: ");
          String nombreBorrar = scanner.nextLine();
          listaContactos.delete(new Contactos(nombreBorrar, "", ""));
          break;
        case 4:
          System.out.print("Escribe el nombre del contacto a encontrar: ");
          String nombreBuscar = scanner.nextLine();
          boolean existe = listaContactos.search(new Contactos(nombreBuscar, "", ""));
          if (existe) {
            System.out.println("Contacto encontrado");
          } else {
            System.out.println("Contacto no encontrado");
          }
          break; 
        case 5:
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opcion no valida");
          break;
      }
    } while (op != 5);
  }
}
