public class hisComp {
    public String cliente;
    public String articulo;
    public int total;

    public hisComp(String cliente, String articulo, int total) {
        this.cliente = cliente;
        this.articulo = articulo;
        this.total = total;
    }

    public String getCliente() {
        return cliente;
    }

    public String getArticulo() {
        return articulo;
    }

    public float getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente + " | Articulo: " + articulo + " | Total: " + total;
    }
}
