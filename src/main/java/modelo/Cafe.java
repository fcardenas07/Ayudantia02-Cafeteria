package modelo;

public class Cafe extends Producto {
    private final CafeTipo tipo;

    public Cafe(CafeTipo tipo, Size size) {
        super(Categoria.CAFE, size);
        if (tipo == null) throw new IllegalArgumentException("Tipo no valido");

        this.tipo = tipo;
        super.precio = calcularPrecio();
    }

    public boolean sonIguales(Producto producto) {
        Cafe cafe = (Cafe) producto;
        return tipo == cafe.tipo && size == cafe.size;
    }

    public int calcularPrecio() {
        return tipo.getPrecio() + size.getPrecio();
    }
}
