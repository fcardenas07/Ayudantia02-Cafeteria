public class Trabajador {
    private final String nombre;
    private final Rol rol;

    public Trabajador(String nombre, Rol rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public void trabajar() {
        System.out.println("Trabajando...");
    }

    public enum Rol {
        BARISTA, MESERO, COCINERO
    }
}
