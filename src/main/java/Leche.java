public class Leche {
    private final Categoria categoria = Categoria.LACTEOS;
    private final Size size;
    private final int precio = 1000;
    public Leche(Size size) {
        this.size = size;
    }
    public int calcularPrecio() {
        return precio + size.getPrecio();
    }

    @Override
    public String toString() {
        return "Leche{" +
                "categoria=" + categoria +
                ", size=" + size +
                ", precio=" + precio +
                '}';
    }
}
