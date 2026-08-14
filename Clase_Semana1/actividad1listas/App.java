import java.util.Scanner;

public class App {
  public void main(String[] args) throws Exception{
    Scanner scan = new Scanner(System.in);
    ListaEnlazada<Object> lista = null;
    int tipoSelecccionado = 0;
    int opcion = 0;
    System.out.println("SISTEMA DE DEMOSTRACION DE LISTAS");
    do {
      System.out.println("MENU");
      System.out.println("1. Elegir tipo de lista");
      System.out.println("2. Ver los tipos de datos");
      System.out.println("3. Insertar elemento");
      System.out.println("4. Mostrar elemento");
      System.out.println("5. Buscar elemento");
      System.out.println("6. Eliminar elemento");
      System.out.println("7. Salir");
      opcion = scan.nextInt();
      switch (opcion) {
        case 1:
          System.out.println("Selecciona el tipo de lista");
          System.out.println("1. Enlazada");
          System.out.println("2. Doblemente enlazada");
          System.out.println("3. Circular");
          tipoSelecccionado = scan.nextInt();
          lista = new ListaEnlazada<>(tipoSelecccionado);
          System.out.println("Lista creada");
          break;
        case 2:
          tiposDeDatos.demostrarTipos();
          break;
        case 3:
          if (lista == null) {
            System.out.println("Primero crea la lista");
          }
          System.out.println("¿Que deseas ingresar?:");
          System.out.println("1. Numeros enteros");
          System.out.println("2. Texto");
          System.out.println("3. Alumnos");
          int opcionTipo = scan.nextInt();
          if (opcionTipo == 1) {
            System.out.println("Ingresa el numero: ");
            int val = scan.nextInt();
            lista.appendNode(val);
            System.out.println("Numero agregado a la lista");
          } else if (opcionTipo == 2) {
            System.out.println("Ingresa la palabra: ");
            String txt = scan.nextLine();
            lista.appendNode(txt);
            System.out.println("Palabra agregada a la lista");
          } else if (opcion == 3) {
            System.out.print("Nombre: ");
            String nombre = scan.nextLine();
            System.out.print("Telefono: ");
            String telefono = scan.nextLine();
            System.out.print("Matricula: ");
            String matricula = scan.nextLine();
            System.out.print("Correo: ");
            String correo = scan.nextLine();
            lista.appendNode(new Alumnos(nombre, telefono, matricula, correo));
            System.out.println("Alumbo agregado a la lista");
          }
          break;
        case 4:
          if (lista == null) {
            System.out.println("No hay lista que mostrar");
            break;
          }
          lista.showlist();
          break;
        case 5:
          if (lista == null) {
            System.out.println("No hay lista en la que buscar");
            break;
          }
          System.out.println("Ingresa el dato a buscar");
          String busqueda = scan.next();
          boolean encontrado = lista.search(busqueda);
          if (encontrado) {
            System.out.println("Elemento encontrado en la lista");
          } else {
            System.out.println("Elemento no encontrado en la lista");
          }
          break;
        case 6:
          if (lista == null) {
            System.out.println("No hay lista a eliminar");
          }
          System.out.println("Ingresa el dato a a eliminar");
          String eliminar = scan.next();
          lista.delete(eliminar);
          break;
        case 7:
          System.out.println("Saliendo del sistema...");
          break;
        default:
          System.out.println("Opcion no valida");
          break;
      }
    } while (opcion != 7);
    scan.close();
  }
}
