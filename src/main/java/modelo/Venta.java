package modelo;

import java.time.LocalDate;
import java.util.List;

public class Venta {
    private final LocalDate fecha;
    private final List<Producto> productos;
    private final int total;

    public Venta(LocalDate fecha, List<Producto> productos) {
        this.fecha = fecha;
        this.productos = productos;
        this.total = calcularTotal();
    }

    private int calcularTotal() {
        return productos.stream()
                .mapToInt(producto -> producto.precio)
                .sum();
    }

    public int getTotal() {
        return total;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
