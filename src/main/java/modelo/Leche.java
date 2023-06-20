package modelo;

public class Leche extends Producto {

    public Leche(Size size) {
        super(Categoria.LACTEOS, size);
        super.precio = calcularPrecio();
    }

    public int calcularPrecio() {
        return 1000 + size.getPrecio();
    }

    @Override
    public boolean sonIguales(Producto producto) {
        Leche leche = (Leche) producto;
        return size == leche.size;
    }
}
