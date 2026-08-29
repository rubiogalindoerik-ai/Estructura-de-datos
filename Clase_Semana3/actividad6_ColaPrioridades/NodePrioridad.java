public class NodePrioridad<T> {
  public T data;
  public NodePrioridad<T> next;
  public int prioridad;

  public NodePrioridad(T data, int prioridad) {
    this.data = data;
    this.prioridad = prioridad;
    this.next = null;
  }
}
