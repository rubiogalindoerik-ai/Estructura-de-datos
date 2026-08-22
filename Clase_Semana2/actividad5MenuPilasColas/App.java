import java.util.Queue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        Cola<Proceso> queueCPU = new Cola<>();
        Pila<String> pilaLlamadas = new Pila<>();

        int opcion;
        do {
            System.out.println("1. [Queue] Registrar un nuevo proceso [Enqueue]");
            System.out.println("2. [Queue] Ejecutar siguiente proceso [Dequeue]");
            System.out.println("3. [Queue] Ver proceso al frnete [Peek]");
            System.out.println("4. [Queue] Mostrar cola de procesos");
            System.out.println("5. [Pila] Simular llamada a funcion [Push]");
            System.out.println("6. [Pila] Retomar la funcion actual [Pop]");
            System.out.println("7. [Pila] Ver funcion en tope de pila [Peek]");
            System.out.println("8. [Pila] Mostrar pila de llamadas");
            System.out.println("9. Salir");
            System.out.println("Eligue una opcion: ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("ID del proceso: ");
                    int id = scan.nextInt();
                    System.out.println("Nombre del proceso: ");
                    String nombre = scan.nextLine();
                    System.out.println("Usuario: ");
                    String usuario = scan.nextLine();
                    System.out.println("Tiempo estimado: ");
                    int tiempoEstimado = scan.nextInt();
                    Proceso nuevoProceso = new Proceso(id, nombre, usuario, tiempoEstimado);
                    System.out.println("Proceso registrado");
                    break;
                case 2:
                    System.out.println("Ejecutando proceso...");
                    Proceso ejecutado = queueCPU.dequeue();
                    if (ejecutado != null) {
                        System.out.println("Procesando tarea " + ejecutado);
                    }
                    break;
                case 3:
                    Proceso frente = queueCPU.peek();
                    if (frente != null) {
                        System.out.println("Primer proceso a ejecutar: " + frente);
                    } else {
                        System.out.println("No hay proccesos a ejecutar");
                    }
                    break;
                case 4:
                    System.out.println("Cola de procesos: ");
                    queueCPU.mostrarPila();
                    break;
                case 5:
                    System.out.println("Ingresa el nombre de la funcion: ");
                    String funcion = scan.nextLine();
                    pilaLlamadas.push(funcion);
                    System.out.println("Funcion apilada");
                    break;
                case 6:
                    System.out.println("Retornando la funcion");
                    String terminada = pilaLlamadas.pop();
                    if (terminada != null) {
                        System.out.println("Funcion: " + terminada + " terminada.");
                    }
                    break;
                case 7:
                    String tope = pilaLlamadas.peek();
                    if (tope != null) {
                        System.out.println("Primera funcion a ejecutar: " + tope);
                    } else {
                        System.out.println("Pila vacia, nada que mostrar");
                    }
                    break;
                case 8:
                    System.out.println("Pila de funciones");
                    pilaLlamadas.mostrarPila();
                    break;
                case 9:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no disponible");
                    break;
            }
        } while (opcion != 9);
        scan.close();
    }
}
