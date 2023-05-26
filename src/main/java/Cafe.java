public class Cafe {
    private final Categoria categoria = Categoria.CAFE;
    private final CafeTipo tipo;
    private final Size size;
    private final int precio;
    private double gramos;
    private double mlAgua;

    public Cafe(CafeTipo tipo, Size size, double mlAgua, double gramos) {
        verificarParametros(tipo, size, mlAgua, gramos);

        this.tipo = tipo;
        this.gramos = gramos;
        this.mlAgua = mlAgua;
        this.size = size;
        this.precio = calcularPrecio();
    }

    public void verificarParametros(CafeTipo tipo, Size size, double mlAgua, double gramos) {
        if (tipo == null) {
            throw new IllegalArgumentException("Debe indicar un tipo de cafe");
        }
        if (gramos <= 0) {
            throw new IllegalArgumentException("Los gramos deben ser mayores a cero");
        }
        if (mlAgua <= 0) {
            throw new IllegalArgumentException("Los ml de agua deben ser mayores a cero");
        }
        if (size == null) {
            throw new IllegalArgumentException("Debe ser un tamaño que este disponible");
        }
    }

    public boolean sonIguales(Cafe cafe) {
        return tipo.equals(cafe.tipo) && size.equals(cafe.size);
    }

    public int calcularPrecio() {
        return tipo.getPrecio() + size.getPrecio();
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "tipo='" + tipo + '\'' +
                ", gramos=" + gramos +
                ", mlAgua=" + mlAgua +
                ", size='" + size + '\'' +
                '}';
    }
}
