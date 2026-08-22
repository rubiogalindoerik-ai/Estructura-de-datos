public class Contactos {
  public String nombre;
  public String direccion;
  public String telefono;

  public Contactos(String nombre, String direccion, String telefono) {
    this.nombre = nombre;
    this.direccion = direccion;
    this.telefono = telefono;
  }

  public String getNombre() {
    return nombre;
  }
  public String getDireccion() {
    return direccion;
  }
  public String getTelefono() {
    return telefono;
  }

  @Override
  public String toString(){
    return "Contacto: " + nombre + ", Direccion: " + direccion + ", telefono: " + telefono;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    Contactos contacto = (Contactos) obj;
    return nombre.trim().equalsIgnoreCase(contacto.nombre.trim()); 
  }
}
