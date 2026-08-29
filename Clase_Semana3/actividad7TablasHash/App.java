public class App {
    public static void main(String[] args)throws Exception {
        SimpleHashTable<String, String> directorioTelefonico = new SimpleHashTable<>(5);
        directorioTelefonico.put("Erick", "442-463-5378");
        directorioTelefonico.put("Vero", "442-179-6397");
        directorioTelefonico.put("Fernando P", "442-142-1242");
        directorioTelefonico.put("Daisy", "442-668-4521");

        System.out.println("Telefono de Erick: " + directorioTelefonico.getV("Erick"));

        directorioTelefonico.showTable();
    }
}
