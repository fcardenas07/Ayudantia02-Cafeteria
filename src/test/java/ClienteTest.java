import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    private Cliente clienteSinDinero;
    private Cliente clienteConDinero;
    private Cafe cafe;
    private Leche leche;
    private Te te;

    @BeforeEach
    void setUp() {
        clienteSinDinero = new Cliente("Cliente1", 0);
        clienteConDinero = new Cliente("Cliente2", 10_000);

        cafe = new Cafe(CafeTipo.EXPRESSO, Size.GRANDE, 100, 100);
        leche = new Leche(Size.GRANDE);
        te = new Te(TeTipo.NORMAL, Size.PEQUEÑO, 100, 100);
    }

    @Test
    void comprarVariosProductos_debeDescontarElPrecio_cuandoTieneDinero() {
        clienteConDinero.comprarCafe(cafe); //1300
        clienteConDinero.comprarTe(te); //1100
        clienteConDinero.comprarLeche(leche); //1300

        int dineroRestante = clienteConDinero.getDinero();

        assertEquals(6_300, dineroRestante);
    }

    @Test
    void comprarCafe_debeArrojarExcepcion_cuandoNoTieneDineroSuficiente() {
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> clienteSinDinero.comprarCafe(cafe));

        assertEquals("Sin suficiente dinero", exception.getMessage());
        assertEquals(0, clienteSinDinero.getDinero());
    }

}