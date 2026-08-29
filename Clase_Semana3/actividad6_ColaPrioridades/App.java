public class App {
    public static void main(String[] args) throws Exception{
        PriorityQueue<String> urgencias = new PriorityQueue<>();

        System.out.println("Llegada de pacientes");
        urgencias.enqueue("Paciente con esguince", 3);
        urgencias.enqueue("Paciente con fractura expuesta", 1);
        urgencias.enqueue("Paciente con fiebre alta", 2);

        System.out.println("Lista de pacientes: ");
        urgencias.mostrar();

        urgencias.enqueue("Paciente con paro cardiorespiratorio", 1);
        System.out.println("Lista de pacientes: ");
        urgencias.mostrar();

        urgencias.dequeue();
        urgencias.dequeue();

        System.out.println("Lista de pacientes: ");
        urgencias.mostrar();
    }
}
