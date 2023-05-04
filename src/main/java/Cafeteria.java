import java.util.ArrayList;
import java.util.List;

public class Cafeteria {
    private final List<String> sizesDisponibles = List.of("Pequeno", "Mediano", "Grande");
    private String nombre;
    private String direccion;
    private List<String> redesSociales;
    private List<Cafe> cafesALaVenta;

    public Cafeteria(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Cafeteria(String nombre, String direccion, List<Cafe> cafesALaVenta) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cafesALaVenta = cafesALaVenta;
    }

    public Cafeteria(String nombre, String direccion, ArrayList<String> redesSociales, ArrayList<Cafe> cafesALaVenta) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.redesSociales = redesSociales;
        this.cafesALaVenta = cafesALaVenta;
    }

    public Cafeteria(String nombre, String direccion, ArrayList<String> redesSociales) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.redesSociales = redesSociales;
        this.cafesALaVenta = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<String> getRedesSociales() {
        return redesSociales;
    }

    public List<Cafe> getCafesALaVenta() {
        return cafesALaVenta;
    }

    public void agregarCafeVenta(String tipo, double gramos, double mlAgua, String size) {
        try {
            agregarCafe(tipo, gramos, mlAgua, size);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void agregarCafe(String tipo, double gramos, double mlAgua, String size) throws IllegalArgumentException {
        validarParametrosCafe(tipo, gramos, mlAgua, size);
        Cafe cafe = new Cafe(tipo, gramos, mlAgua, size);
        cafesALaVenta.add(cafe);
    }

    public void validarParametrosCafe(String tipo, double gramos, double mlAgua, String size) {
        if (tipo.isBlank()) {
            throw new IllegalArgumentException("Debe indicar un tipo de cafe");
        }
        if (gramos <= 0) {
            throw new IllegalArgumentException("La cantidad de gramos debe ser mayor a cero");
        }
        if (mlAgua <= 0) {
            throw new IllegalArgumentException("La cantidad de ml de agua debe ser mayor a cero");
        }
        if (!sizesDisponibles.contains(size)) {
            throw new IllegalArgumentException("Debe ser un tamaño que este disponible");
        }
    }

    public void eliminarCafeALaVenta(Cafe cafe) {
        cafesALaVenta.remove(cafe);
    }

    public boolean cafeEstaEnVenta(Cafe cafeBuscado) {
        return cafesALaVenta.stream()
                .anyMatch(cafe -> sonCafesIguales(cafeBuscado, cafe));
    }

    public boolean sonCafesIguales(Cafe cafeBuscado, Cafe cafe) {
        return cafe.getTipo().equals(cafeBuscado.getTipo()) &&
                cafe.getSize().equals(cafeBuscado.getSize());
    }

    @Override
    public String toString() {
        return "Cafeteria{" +
                "sizesDisponibles=" + sizesDisponibles +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", redesSociales=" + redesSociales +
                ", cafesALaVenta=" + cafesALaVenta +
                "}";
    }
}
