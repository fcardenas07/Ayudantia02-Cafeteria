import java.util.Random;

public class Cliente {
    private final String nombre;
    private int dinero;

    public Cliente(String nombre, int dinero) {
        this.nombre = nombre;
        this.dinero = dinero;
    }

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.dinero = new Random().nextInt(0, 10_001);
    }

    public int getDinero() {
        return dinero;
    }

    public void comprarCafe(Cafe cafe) {
        pagar(cafe.calcularPrecio());
    }

    public void comprarTe(Te te) {
        pagar(te.calcularPrecio());
    }

    public void comprarLeche(Leche leche) {
        pagar(leche.calcularPrecio());
    }

    private void pagar(int precio) {
        if (precio > dinero) throw new RuntimeException("Sin suficiente dinero");
        dinero -= precio;
    }

}
