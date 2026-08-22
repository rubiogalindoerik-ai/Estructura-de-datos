public class Proceso {
    public int id;
    public String nombre;
    public String usuario;
    public int tiempoEstimado;

    public Proceso(int id, String nombre, String usuario, int tiempoEstimado) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.tiempoEstimado = tiempoEstimado;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }
    
    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    @Override
    public String toString() {
        return "Id: " + id + "| Proceso: " + nombre + "| Usuario: " + usuario + "| tiempo estimado: " + tiempoEstimado;
    }
}
