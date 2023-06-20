package modelo;

public abstract class Producto {
    protected int precio;
    protected Size size;
    protected Categoria categoria;

    public Producto(Categoria categoria, Size size) {
        verificarParametros(categoria, size);

        this.categoria = categoria;
        this.size = size;
    }

    private void verificarParametros(Categoria categoria, Size size) {
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria no valida");
        }
        if (size == null) {
            throw new IllegalArgumentException("Size no valido");
        }
    }

    protected abstract int calcularPrecio();

    protected abstract boolean sonIguales(Producto producto);
}
