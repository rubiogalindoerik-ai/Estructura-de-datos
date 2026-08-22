public class App {
    public static void main(String[] args) throws Exception{
        // Prueben todos los metodos que hicimos
        QueueSimple fila = new QueueSimple();

        fila.enqueue("Alberto");
        fila.enqueue("Cynthia");
        fila.enqueue("Jose");

        fila.mostrarFila();
        fila.dequeue();
        fila.mostrarFila();
    }
}
