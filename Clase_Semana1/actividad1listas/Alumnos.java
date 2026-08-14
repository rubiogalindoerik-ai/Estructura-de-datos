public class Alumnos {
  public String nombre;
  public String telefono;
  public String matricula;
  public String correo;

  public Alumnos(String nombre, String telefono, String matricula, String correo) {
    this.nombre = nombre;
    this.telefono = telefono;
    this.matricula = matricula;
    this.correo = correo;
  }

  public String getNombre() {
    return nombre;
  }
  public String getTelefono() {
    return telefono;
  }
  public String getMatricula() {
    return matricula;
  }
  public String getCorreo() {
    return correo;
  }

  @Override
  public String toString(){
    return "\nAlumno: " + nombre + ", telefono: " + telefono + ", matricula: " + matricula + ", correo: " + correo;
  }
}
