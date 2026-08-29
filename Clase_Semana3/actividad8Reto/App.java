import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        Cola<Cliente> filaEspera = new Cola<>();
        Pila<hisComp> historialCompras = new Pila<>();
        SimpleHashTable<String, Integer> directorioPrecio = new SimpleHashTable<>(5);
        directorioPrecio.put("Cafe", 45);
        directorioPrecio.put("Panini", 80);
        directorioPrecio.put("Jugo", 35);
        Cliente cliente1 = new Cliente("Carlos");
        Cliente cliente2 = new Cliente("Ana");
        Cliente cliente3 = new Cliente("Pedro");
        filaEspera.enqueue(cliente1);
        filaEspera.enqueue(cliente2);
        filaEspera.enqueue(cliente3);

        int op;
        int opc;
        do {
            System.out.println("----- CAFE TECMILENIO -----");
            System.out.println("1. Fila de espera de clientes");
            System.out.println("2. Historial de compras");
            System.out.println("3. Inventario");
            System.out.println("4. Salir");
            System.out.println("Introduce una opcion: ");
            op = scan.nextInt();
            switch (op) {
                case 1:
                    do {
                        System.out.println("----- Fila de espera de clientes -----");
                        System.out.println("1. Ver fila de espera");
                        System.out.println("2. Agregar cliente a la fila de espera");
                        System.out.println("3. Atender a cliente");
                        System.out.println("4. Salir");
                        opc = scan.nextInt();
                        scan.nextLine();
                        if (opc == 1) {
                            filaEspera.mostrarCola();
                        } else if (opc == 2) {
                            System.out.println("Nombre del cliente: ");
                            String nombre = scan.nextLine();
                            Cliente nuevoCliente = new Cliente(nombre);
                            filaEspera.enqueue(nuevoCliente);
                        } else if (opc == 3) {
                            System.out.println("Atendiendo cliente: ");
                            Cliente atendido = filaEspera.dequeue();
                            if (atendido != null) {
                                System.out.println("Atendiendo cliente: " + atendido);
                            }
                        } else if (opc == 4) {
                            System.out.println("Volviendo a menu principal");
                        } else {
                            System.out.println("Opcion no disponible, intente de nuevo");
                        }
                    } while (opc != 4);
                    break;
                case 2:
                    do {
                        System.out.println("----- Historial de compras -----");
                        System.out.println("1. Ver historial de compras");
                        System.out.println("2. Deshacer ultima venta");
                        System.out.println("3. Agregar compra");
                        System.out.println("4. Salir");
                        opc = scan.nextInt();
                        scan.nextLine();
                        if (opc == 1) {
                            historialCompras.mostrarPila();
                        } else if (opc == 2) {
                            System.out.println("Cancelando compra");
                            hisComp deshacer = historialCompras.pop();
                            if (deshacer != null) {
                                System.out.println("Compra: " + deshacer + " cancelada.");
                            }
                        } else if (opc == 3) {
                            System.out.println("Ingresa el nombre del cliente: ");
                            String cliente = scan.nextLine();
                            System.out.println("Ingresa el articulo: ");
                            String articulo = scan.nextLine();
                            System.out.println("Ingresa el precio total: ");
                            int total = scan.nextInt();
                            hisComp nuevaCompra = new hisComp(cliente, articulo, total);
                            historialCompras.push(nuevaCompra);
                            System.out.println("Compra registrada");
                        } else if (opc == 4){
                            System.out.println("Volviendo a menu principal");
                        } else {
                            System.out.println("Opcion no disponible, intente de nuevo");
                        }
                    } while (opc != 4);
                    break;
                case 3:
                    do {
                        System.out.println("----- Inventario -----");
                        System.out.println("1. Ver invetario");
                        System.out.println("2. Buscar en el inventario");
                        System.out.println("3. Salir");
                        opc = scan.nextInt();
                        scan.nextLine();
                        if (opc == 1) {
                            directorioPrecio.showTable();
                        } else if (opc == 2) {
                            System.out.println("Ingrese el nombre del producto: ");
                            String search = scan.nextLine();
                            System.out.println(directorioPrecio.getV(search));
                        } else if (opc == 3) {
                            System.out.println("Volviendo a menu pricipal");
                        } else {
                            System.out.println("Opcion no disponible, intente de nuevo");
                        }
                    } while (opc != 3);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no disponible, intente de nuevo");
                    break;
            }
        } while (op != 4);
        scan.close();
    }
}
