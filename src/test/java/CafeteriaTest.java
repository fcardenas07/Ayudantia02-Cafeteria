import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CafeteriaTest {
    private Cafeteria cafeteria;

    @BeforeEach
    void setUp() {
        List<Cafe> cafesVenta = new ArrayList<>();
        cafesVenta.add(new Cafe("Normal", 150, 200, "Mediano"));
        cafesVenta.add(new Cafe("Express", 200, 250, "Grande"));

        cafeteria = new Cafeteria("Coffe Shop", "Av 01", cafesVenta);
    }

    @Test
    void debeRetornarTrue_cuandoElCafeBuscadoEstaAlaVenta() {
        Cafe cafeBuscado1 = new Cafe("Normal", 150, 200, "Mediano");
        Cafe cafeBuscado2 = new Cafe("Express", 200, 250, "Grande");

        assertTrue(cafeteria.cafeEstaEnVenta(cafeBuscado1));
        assertTrue(cafeteria.cafeEstaEnVenta(cafeBuscado2));
    }

    @Test
    void debeRetornarFalse_cuandoElCafeBuscadoNoEstaAlaVenta() {
        Cafe cafeBuscado = new Cafe("Moka", 150, 200, "Mediano");

        assertFalse(cafeteria.cafeEstaEnVenta(cafeBuscado));
    }

}