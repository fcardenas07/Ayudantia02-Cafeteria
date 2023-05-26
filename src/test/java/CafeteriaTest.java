import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CafeteriaTest {
    private Cafeteria cafeteria;

    @BeforeEach
    void setUp() {
        cafeteria = new Cafeteria("Cafeteria", "Av 01", new ArrayList<>());
        cafeteria.agregarCafeALaVenta(new Cafe(CafeTipo.LATTE, Size.MEDIANO, 200, 150));
        cafeteria.agregarCafeALaVenta(new Cafe(CafeTipo.EXPRESSO, Size.GRANDE, 250, 200));

    }

    @Test
    void buscarCafe_noDebeRetornarMenosUno_cuandoElCafeBuscadoEstaAlaVenta() {
        Cafe cafeBuscado1 = new Cafe(CafeTipo.LATTE, Size.MEDIANO, 200, 150);
        Cafe cafeBuscado2 = new Cafe(CafeTipo.EXPRESSO, Size.GRANDE, 250, 200);

        assertNotEquals(-1, cafeteria.buscarCafe(cafeBuscado1));
        assertNotEquals(-1, cafeteria.buscarCafe(cafeBuscado2));
    }

    @Test
    void buscarCafe_debeRetornarMenosUno_cuandoElCafeBuscadoNoEstaAlaVenta() {
        Cafe cafeBuscado = new Cafe(CafeTipo.MOKA, Size.MEDIANO, 200, 150);

        assertEquals(-1, cafeteria.buscarCafe(cafeBuscado));
    }

    @Test
    void agregarCafeALaVenta_debeAgregarNuevoCafe_cuandoNoEstaALaVenta() {
        Cafe nuevoCafe = new Cafe(CafeTipo.CAPUCHINO, Size.MEDIANO, 250, 200);
        int sizeOriginal = cafeteria.getCafesALaVenta().size();

        cafeteria.agregarCafeALaVenta(nuevoCafe);

        int sizeNuevo = cafeteria.getCafesALaVenta().size();

        assertEquals(sizeOriginal + 1, sizeNuevo);
        assertEquals(nuevoCafe, cafeteria.getCafesALaVenta().get(sizeOriginal));
    }

    @Test
    void agregarCafeALaVenta_noDebeAgregarNuevoCafe_cuandoYaEstaALaVenta() {
        Cafe nuevoCafe = new Cafe(CafeTipo.EXPRESSO, Size.GRANDE, 250, 200);

        cafeteria.agregarCafeALaVenta(nuevoCafe);

        int sizeNuevo = cafeteria.getCafesALaVenta().size();

        assertEquals(2, sizeNuevo);
    }

    @Test
    void eliminarCafeALaVenta_debeEliminarCafe_cuandoYaEstaALaVenta() {
        Cafe cafeAEliminar = new Cafe(CafeTipo.EXPRESSO, Size.GRANDE, 250, 200);
        int sizeOriginal = cafeteria.getCafesALaVenta().size();

        cafeteria.eliminarCafeALaVenta(cafeAEliminar);

        int sizeNuevo = cafeteria.getCafesALaVenta().size();

        assertEquals(sizeOriginal, sizeNuevo + 1);
    }

    @Test
    void eliminarCafeALaVenta_debeMostrarMensaje_cuandoElCafeNoEstaALaVenta() {
        Cafe cafe = new Cafe(CafeTipo.MOKA, Size.GRANDE, 250, 200);

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

    @Test
    void agregarTrabajador() {
        Trabajador trabajador = new Trabajador("Trabajador", Trabajador.Rol.BARISTA);
        int sizeInicial = cafeteria.getTrabajadores().size();

        cafeteria.agregarTrabajador(trabajador);

        int size = cafeteria.getTrabajadores().size();
        Trabajador actual = cafeteria.getTrabajadores().get(size - 1);

        assertEquals(sizeInicial + 1, size);
        assertEquals(trabajador, actual);
    }

    @Test
    void asociarCliente() {
        Cliente cliente = new Cliente("Cliente");
        int sizeInicial = cafeteria.getClientes().size();

        cafeteria.asociarCliente(cliente);

        int size = cafeteria.getClientes().size();
        Cliente actual = cafeteria.getClientes().get(size - 1);

        assertEquals(sizeInicial + 1, size);
        assertEquals(cliente, actual);
    }
}