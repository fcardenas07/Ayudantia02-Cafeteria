package modelo;

public class Te extends Producto {
    private final TeTipo tipo;

    public Te(TeTipo tipo, Size size) {
        super(Categoria.TE, size);
        if (tipo == null) throw new IllegalArgumentException("Tipo no valido");

        this.tipo = tipo;
        super.precio = calcularPrecio();
    }

    public int calcularPrecio() {
        return tipo.getPrecio() + size.getPrecio();
    }

    @Override
    public boolean sonIguales(Producto producto) {
        Te te = (Te) producto;
        return tipo == te.tipo && size == te.size;
    }
}
