import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Cafeteria {
    private final String nombre;
    private final String direccion;
    private final List<String> rrss;
    private final List<Cafe> cafesALaVenta;

    private final List<Te> tesALaVenta;

    public Cafeteria(String nombre, String direccion, List<String> rrss, List<Cafe> cafesALaVenta, List<Te> tesALaVenta) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.rrss = rrss;
        this.cafesALaVenta = cafesALaVenta;
        this.tesALaVenta = tesALaVenta;
    }

    public List<Cafe> getCafesALaVenta() {
        return cafesALaVenta;
    }

    public void agregarCafeALaVenta(Cafe cafe) {
        if (cafeNoValido(cafe)) return;

        if (buscarCafe(cafe) != -1) {
            System.out.println("No se pudo agregar, el cafe ya esta a la venta");
            return;
        }
        cafesALaVenta.add(cafe);
    }

    public boolean cafeNoValido(Cafe cafe) {
        try {
            verificarParametrosCafe(cafe);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public void verificarParametrosCafe(Cafe cafe) {
        if (cafe.getTipo() == null) {
            throw new IllegalArgumentException("Debe indicar un tipo de cafe");
        }
        if (cafe.getGramos() <= 0) {
            throw new IllegalArgumentException("Los gramos deben ser mayor a cero");
        }
        if (cafe.getMlAgua() <= 0) {
            throw new IllegalArgumentException("Los ml de agua deben ser mayor a cero");
        }
        if (cafe.getSize() == null) {
            throw new IllegalArgumentException("Debe ser un tamaño que este disponible");
        }
    }

    public void eliminarCafeALaVenta(Cafe cafe) {
        if (cafeNoValido(cafe)) return;

        int indiceCafe = buscarCafe(cafe);
        if (indiceCafe == -1) {
            System.out.println("No se pudo eliminar, el cafe no esta a la venta");
            return;
        }
        cafesALaVenta.remove(indiceCafe);
    }

    public int buscarCafe(Cafe cafe) {
        return IntStream.range(0, cafesALaVenta.size())
                .filter(indice -> sonCafesIguales(cafesALaVenta.get(indice), cafe))
                .findFirst()
                .orElse(-1);
    }

    public boolean sonCafesIguales(Cafe cafeBuscado, Cafe cafe) {
        return cafe.getTipo().equals(cafeBuscado.getTipo()) &&
                cafe.getSize().equals(cafeBuscado.getSize());
    }

    @Override
    public String toString() {
        return "Cafeteria{" +
                "sizesDisponibles=" + Arrays.toString(Size.values()) +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", redesSociales=" + rrss +
                ", cafesALaVenta=" + cafesALaVenta +
                "}";
    }
}
