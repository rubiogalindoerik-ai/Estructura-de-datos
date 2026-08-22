public class App {
    public static void main(String[] args) throws Exception{
        HistorialNavegacion historial = new HistorialNavegacion();

        historial.visitaPagina("tecimilenio.com");
        historial.visitaPagina("google.com");
        historial.visitaPagina("jkanime.com");

        historial.mostrarHistorial();

        System.out.println("Mostrando la ultima pagina visitada: ");
        historial.mostrarUltima();

        System.out.println("Borrando ultima pagina visitada: ");
        historial.borrarUltima();

        System.out.println("Mostrando el historial actualizado: ");
        historial.mostrarHistorial();
    }
}
