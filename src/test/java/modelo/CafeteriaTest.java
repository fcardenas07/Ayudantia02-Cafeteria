package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CafeteriaTest {
    private Cafeteria cafeteria;

    @BeforeEach
    void setUp() {
        cafeteria = new Cafeteria("Cafeteria", "Av 01", new ArrayList<>());
        cafeteria.agregarProducto(new Cafe(CafeTipo.LATTE, Size.MEDIANO));
        cafeteria.agregarProducto(new Cafe(CafeTipo.EXPRESSO, Size.GRANDE));
    }

    @Test
    void buscarCafe_noDebeRetornarMenosUno_cuandoElCafeBuscadoEstaAlaVenta() {
        Cafe cafeBuscado1 = new Cafe(CafeTipo.LATTE, Size.MEDIANO);
        Cafe cafeBuscado2 = new Cafe(CafeTipo.EXPRESSO, Size.GRANDE);

        assertNotEquals(-1, cafeteria.buscarProducto(cafeBuscado1));
        assertNotEquals(-1, cafeteria.buscarProducto(cafeBuscado2));
    }

    @Test
    void buscarCafe_debeRetornarMenosUno_cuandoElCafeBuscadoNoEstaAlaVenta() {
        Cafe cafeBuscado = new Cafe(CafeTipo.MOKA, Size.MEDIANO);

        assertEquals(-1, cafeteria.buscarProducto(cafeBuscado));
    }

    @Test
    void agregarCafeALaVenta_debeAgregarNuevoCafe_cuandoNoEstaALaVenta() {
        Cafe nuevoCafe = new Cafe(CafeTipo.CAPUCHINO, Size.MEDIANO);
        int sizeOriginal = cafeteria.getProductos().size();

        cafeteria.agregarProducto(nuevoCafe);

        int sizeNuevo = cafeteria.getProductos().size();

        assertEquals(sizeOriginal + 1, sizeNuevo);
        assertEquals(nuevoCafe, cafeteria.getProductos().get(sizeOriginal));
    }

    @Test
    void agregarCafeALaVenta_noDebeAgregarNuevoCafe_cuandoYaEstaALaVenta() {
        Cafe nuevoCafe = new Cafe(CafeTipo.EXPRESSO, Size.GRANDE);

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> cafeteria.agregarProducto(nuevoCafe));


        int sizeNuevo = cafeteria.getProductos().size();

        assertEquals("Producto ya esta en venta", exception.getMessage());
        assertEquals(2, sizeNuevo);
    }

    @Test
    void eliminarCafeALaVenta_debeEliminarCafe_cuandoYaEstaALaVenta() {
        Cafe cafeAEliminar = new Cafe(CafeTipo.EXPRESSO, Size.GRANDE);
        int sizeOriginal = cafeteria.getProductos().size();

        cafeteria.eliminarProducto(cafeAEliminar);

        int sizeNuevo = cafeteria.getProductos().size();

        assertEquals(sizeOriginal, sizeNuevo + 1);
    }

    @Test
    void eliminarCafeALaVenta_debeMostrarMensaje_cuandoElCafeNoEstaALaVenta() {
        Cafe cafe = new Cafe(CafeTipo.MOKA, Size.GRANDE);

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> cafeteria.eliminarProducto(cafe));

        assertEquals("Producto no encontrado", exception.getMessage());
    }

    @Test
    void agregarTrabajador() {
        Trabajador trabajador = new Trabajador("Trabajador", Rol.BARISTA);
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

    @Test
    void filtrarLibroDiario_sinResultados() {
        LocalDate fechaSinVentas = LocalDate.of(2000, 1, 2);
        List<Venta> ventas = cafeteria.filtrarLibroDiario(fechaSinVentas);

        assertTrue(ventas.isEmpty());
    }

    @Test
    void filtrarLibroDiario() {
        Cafeteria cafeteria1 = new Cafeteria("src/main/resources/TestVentas.json");

        LocalDate fecha = LocalDate.of(2023, 6, 18);
        List<Venta> ventas = cafeteria1.filtrarLibroDiario(fecha);

        int size = ventas.size();
        int total = ventas.stream().mapToInt(Venta::getTotal).sum();

        assertEquals(2, size);
        assertEquals(5000, total);
    }
}