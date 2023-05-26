public class Te {
    private final Categoria categoria = Categoria.TE;
    private final TeTipo tipo;
    private final Size size;
    private final int precio;
    private final double gramos;
    private final double mlAgua;

    public Te(TeTipo tipo, Size size, double gramos, double mlAgua) {
        this.tipo = tipo;
        this.size = size;
        this.gramos = gramos;
        this.mlAgua = mlAgua;
        this.precio = calcularPrecio();
    }

    public int calcularPrecio() {
        return tipo.precio() + size.getPrecio();
    }

    @Override
    public String toString() {
        return "Te{" +
                "tipo='" + tipo + '\'' +
                ", size=" + size +
                ", gramos=" + gramos +
                ", mlAgua=" + mlAgua +
                '}';
    }
}
