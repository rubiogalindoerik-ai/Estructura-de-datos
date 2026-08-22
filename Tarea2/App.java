import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("\n-- Menu Principal --");
      System.out.println("1. Ejemplos de tipos de datos y listas"); 
      System.out.println("2. Sistema de gestion de contactos");
      System.out.println("3. Estructura de pilas y colas");
      System.out.println("4. Salir");
      System.out.print("Elige una opcion: ");
      
      int opmenu = scanner.nextInt();
      scanner.nextLine(); 
      
      if (opmenu == 1) {
        System.out.println("Modulo de Tipos de Datos (Asumiendo que ya tienes esta clase).");
      } else if (opmenu == 2) {
        menuContactos(scanner);
      } else if (opmenu == 3) {
        menuPilasColas(scanner); 
      } else if (opmenu == 4) {
        System.out.println("Saliendo...");
        break;
      } else {
        System.out.println("Opcion no valida");
      }
    }
    scanner.close();
  }

  public static void menuContactos(Scanner scanner) {
      System.out.println("\n(Ingresando al modulo de contactos...)");
  }

  public static void menuPilasColas (Scanner scanner) {
    Cola<Proceso> queueCPU = new Cola<>();
    Pila<String> pilaLlamadas = new Pila<>();

    int opcion;
    do {
        System.out.println("\n-- Simulador de SO: Pilas y Colas --");
        System.out.println("1. [Queue] Registrar un nuevo proceso [Enqueue]");
        System.out.println("2. [Queue] Ejecutar siguiente proceso [Dequeue]");
        System.out.println("3. [Queue] Ver proceso al frente [Peek]");
        System.out.println("4. [Queue] Mostrar cola de procesos");
        System.out.println("5. [Pila] Simular llamada a funcion [Push]");
        System.out.println("6. [Pila] Retomar la funcion actual [Pop]");
        System.out.println("7. [Pila] Ver funcion en tope de pila [Peek]");
        System.out.println("8. [Pila] Mostrar pila de llamadas");
        System.out.println("9. Regresar al menu principal");
        System.out.print("Elige una opcion: ");
        
        opcion = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcion) {
            case 1:
                System.out.print("ID del proceso: ");
                int id = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Nombre del proceso: ");
                String nombre = scanner.nextLine();
                System.out.print("Usuario: ");
                String usuario = scanner.nextLine();
                System.out.print("Tiempo estimado: ");
                int tiempoEstimado = scanner.nextInt();
                scanner.nextLine(); 
                
                Proceso nuevoProceso = new Proceso(id, nombre, usuario, tiempoEstimado);
                queueCPU.enqueue(nuevoProceso); 
                System.out.println("Proceso registrado exitosamente.");
                break;
            case 2:
                System.out.println("Ejecutando proceso...");
                Proceso ejecutado = queueCPU.dequeue();
                if (ejecutado != null) {
                    System.out.println("Procesando tarea: " + ejecutado);
                } else {
                    System.out.println("No hay procesos pendientes.");
                }
                break;
            case 3:
                Proceso frente = queueCPU.peek();
                if (frente != null) {
                    System.out.println("Primer proceso a ejecutar: " + frente);
                } else {
                    System.out.println("No hay procesos en la cola.");
                }
                break;
            case 4:
                System.out.println("Cola de procesos actual: ");
                queueCPU.mostrarCola(); 
                break;
            case 5:
                System.out.print("Ingresa el nombre de la funcion: ");
                String funcion = scanner.nextLine(); 
                pilaLlamadas.push(funcion);
                System.out.println("Funcion apilada correctamente.");
                break;
            case 6:
                System.out.println("Retornando la funcion...");
                String terminada = pilaLlamadas.pop();
                if (terminada != null) {
                    System.out.println("Funcion terminada: " + terminada);
                } else {
                    System.out.println("No hay funciones activas en la pila.");
                }
                break;
            case 7:
                String tope = pilaLlamadas.peek();
                if (tope != null) {
                    System.out.println("Funcion actual en el tope: " + tope);
                } else {
                    System.out.println("Pila vacia, nada que mostrar.");
                }
                break;
            case 8:
                System.out.println("Estado de la Pila de llamadas:");
                pilaLlamadas.mostrarPila();
                break;
            case 9:
                System.out.println("Regresando al menu principal...");
                break;
            default:
                System.out.println("Opcion no disponible.");
                break;
        }
    } while (opcion != 9);
  }
}