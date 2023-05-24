import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CafeteriaTest {
    private Cafeteria cafeteria;

    @BeforeEach
    void setUp() {
        List<Cafe> cafesVenta = new ArrayList<>();
        cafesVenta.add(new Cafe(Tipo.NORMAL, 150, 200, Size.MEDIANO));
        cafesVenta.add(new Cafe(Tipo.EXPRESS, 200, 250, Size.GRANDE));

        cafeteria = new Cafeteria("Coffe Shop", "Av 01", new ArrayList<>(), cafesVenta, new ArrayList<>());
    }

    @Test
    void buscarCafe_noDebeRetornarMenosUno_cuandoElCafeBuscadoEstaAlaVenta() {
        Cafe cafeBuscado1 = new Cafe(Tipo.NORMAL, 150, 200, Size.MEDIANO);
        Cafe cafeBuscado2 = new Cafe(Tipo.EXPRESS, 200, 250, Size.GRANDE);

        assertNotEquals(-1, cafeteria.buscarCafe(cafeBuscado1));
        assertNotEquals(-1, cafeteria.buscarCafe(cafeBuscado2));
    }

    @Test
    void buscarCafe_debeRetornarMenosUno_cuandoElCafeBuscadoNoEstaAlaVenta() {
        Cafe cafeBuscado = new Cafe(Tipo.MOKA, 150, 200, Size.MEDIANO);

        assertEquals(-1, cafeteria.buscarCafe(cafeBuscado));
    }

    @Test
    void verificarParametrosCafe_debeArrojarUnaExcepcion_cuandoSeAgregaCafeConTipoNull() {
        Cafe cafe = new Cafe(null, 200, 250, Size.GRANDE);

        var exception = assertThrows(IllegalArgumentException.class,
                () -> cafeteria.verificarParametrosCafe(cafe));

        assertEquals("Debe indicar un tipo de cafe", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void verificarParametrosCafe_debeArrojarUnaExcepcion_cuandoSeAgregaCafeConGramosMenoresACero(int gramos) {
        Cafe cafe = new Cafe(Tipo.MOKA, gramos, 250, Size.GRANDE);

        var exception = assertThrows(IllegalArgumentException.class,
                () -> cafeteria.verificarParametrosCafe(cafe));

        assertEquals("Los gramos deben ser mayor a cero", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void verificarParametrosCafe_debeArrojarUnaExcepcion_cuandoSeAgregaCafeConMlAguaMenoresACero(int mlAgua) {
        Cafe cafe = new Cafe(Tipo.MOKA, 200, mlAgua, Size.GRANDE);

        var exception = assertThrows(IllegalArgumentException.class,
                () -> cafeteria.verificarParametrosCafe(cafe));

        assertEquals("Los ml de agua deben ser mayor a cero", exception.getMessage());
    }

    @Test
    void verificarParametrosCafe_debeArrojarUnaExcepcion_cuandoSeAgregaCafeConSizeNull() {
        Cafe cafe = new Cafe(Tipo.EXPRESS, 200, 250, null);

        var exception = assertThrows(IllegalArgumentException.class,
                () -> cafeteria.verificarParametrosCafe(cafe));

        assertEquals("Debe ser un tamaño que este disponible", exception.getMessage());
    }

    @Test
    void agregarCafeALaVenta_debeAgregarNuevoCafe_cuandoNoEstaALaVenta() {
        Cafe nuevoCafe = new Cafe(Tipo.CAPUCHINO, 200, 250, Size.MEDIANO);
        int sizeOriginal = cafeteria.getCafesALaVenta().size();

        cafeteria.agregarCafeALaVenta(nuevoCafe);

        int sizeNuevo = cafeteria.getCafesALaVenta().size();

        assertEquals(sizeOriginal + 1, sizeNuevo);
        assertEquals(nuevoCafe, cafeteria.getCafesALaVenta().get(sizeOriginal));
    }

    @Test
    void agregarCafeALaVenta_noDebeAgregarNuevoCafe_cuandoYaEstaALaVenta() {
        Cafe nuevoCafe = new Cafe(Tipo.EXPRESS, 200, 250, Size.GRANDE);

        cafeteria.agregarCafeALaVenta(nuevoCafe);

        int sizeNuevo = cafeteria.getCafesALaVenta().size();

        assertEquals(2, sizeNuevo);
    }

    @Test
    void eliminarCafeALaVenta_debeEliminarCafe_cuandoYaEstaALaVenta() {
        Cafe cafeAEliminar = new Cafe(Tipo.EXPRESS, 200, 250, Size.GRANDE);
        int sizeOriginal = cafeteria.getCafesALaVenta().size();

        cafeteria.eliminarCafeALaVenta(cafeAEliminar);

        int sizeNuevo = cafeteria.getCafesALaVenta().size();

        assertEquals(sizeOriginal, sizeNuevo + 1);
    }

    @Test
//    @CaptureSystemOutput
    void eliminarCafeALaVenta_debeMostrarMensaje_cuandoElCafeNoEstaALaVenta() {
        Cafe cafe = new Cafe(Tipo.MOKA, 200, 250, Size.GRANDE);

        // Crear una instancia de ByteArrayOutputStream para redirigir la salida de consola
        var outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Ejecutar el método que imprime por pantalla el mensaje
        cafeteria.eliminarCafeALaVenta(cafe);

        // Obtener el mensaje de salida del ByteArrayOutputStream y compararlo con el mensaje esperado
        String mensajeEsperado = "No se pudo eliminar, el cafe no esta a la venta";
        String mensajeSalida = outputStream.toString().trim();

        assertEquals(mensajeEsperado, mensajeSalida);
    }
}