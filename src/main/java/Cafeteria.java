import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Cafeteria {
    private final String nombre;
    private final String direccion;
    private final List<String> redesSociales;
    private final List<Cafe> cafesALaVenta = new ArrayList<>();

    private final List<Te> tesALaVenta = new ArrayList<>();

    private final List<Leche> lecheALaVenta = new ArrayList<>();
    private final List<Trabajador> trabajadores = new ArrayList<>();
    private final List<Cliente> clientes = new ArrayList<>();

    public Cafeteria(String nombre, String direccion, List<String> redesSociales) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.redesSociales = redesSociales;
    }

    public List<Cafe> getCafesALaVenta() {
        return cafesALaVenta;
    }

    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void agregarCafeALaVenta(Cafe cafe) {
        if (buscarCafe(cafe) != -1) {
            System.out.println("No se pudo agregar, el cafe ya esta a la venta");
            return;
        }
        cafesALaVenta.add(cafe);
    }

    public void eliminarCafeALaVenta(Cafe cafe) {
        int indiceCafe = buscarCafe(cafe);
        if (indiceCafe == -1) {
            System.out.println("No se pudo eliminar, el cafe no esta a la venta");
            return;
        }
        cafesALaVenta.remove(indiceCafe);
    }

    public int buscarCafe(Cafe cafe) {
        return IntStream.range(0, cafesALaVenta.size())
                .filter(indice -> cafe.sonIguales(cafesALaVenta.get(indice)))
                .findFirst()
                .orElse(-1);
    }

    public void agregarTrabajador(Trabajador trabajador) {
        trabajadores.add(trabajador);
    }

    public void asociarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public String toString() {
        return "Cafeteria{" + "sizesDisponibles=" + Arrays.toString(Size.values()) + ", nombre='" + nombre + '\'' + ", direccion='" + direccion + '\'' + ", redesSociales=" + redesSociales + ", cafesALaVenta=" + cafesALaVenta + "}";
    }
}
