package modelo;

import datos.GestorDeArchivos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Cafeteria {
    private final String nombre;
    private final String direccion;
    private final String rutaRegistroVentas;
    private final List<String> redesSociales;
    private final List<Producto> productos = new ArrayList<>();
    private final List<Trabajador> trabajadores = new ArrayList<>();
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Venta> libroDiario;

    public Cafeteria(String nombre, String direccion, List<String> redesSociales) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.redesSociales = redesSociales;
        this.rutaRegistroVentas = "src/main/resources/Ventas.json";
        this.libroDiario = GestorDeArchivos.leerVentas(rutaRegistroVentas);
    }

    public Cafeteria(String rutaRegistroVentas) {
        this.nombre = "";
        this.direccion = "";
        this.redesSociales = new ArrayList<>();
        this.rutaRegistroVentas = rutaRegistroVentas;
        this.libroDiario = GestorDeArchivos.leerVentas(this.rutaRegistroVentas);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void agregarProducto(Producto producto) {
        if (buscarProducto(producto) != -1) throw new RuntimeException("Producto ya esta en venta");

        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        int indice = buscarProducto(producto);
        if (indice == -1) throw new RuntimeException("Producto no encontrado");

        productos.remove(indice);
    }

    public int buscarProducto(Producto productoBuscado) {
        return IntStream.range(0, productos.size())
                .filter(indice -> compararProductos(productoBuscado, productos.get(indice)))
                .findFirst()
                .orElse(-1);
    }

    private boolean compararProductos(Producto producto1, Producto producto2) {
        if (producto1 instanceof Cafe cafe) {
            return cafe.sonIguales(producto2);
        } else if (producto1 instanceof Te te) {
            return te.sonIguales(producto2);
        } else if (producto1 instanceof Leche leche) {
            return leche.sonIguales(producto2);
        }
        return false;
    }

    public void agregarTrabajador(Trabajador trabajador) {
        trabajadores.add(trabajador);
    }

    public void asociarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Venta> filtrarLibroDiario(LocalDate fecha) {
        return libroDiario.stream()
                .filter(venta -> venta.getFecha().isEqual(fecha))
                .collect(toList());
    }

    public void vender(Venta venta) {
        libroDiario.add(venta);
        GestorDeArchivos.agregarVenta(venta, rutaRegistroVentas);
    }
}
