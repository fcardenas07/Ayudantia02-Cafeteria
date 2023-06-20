package datos;

import modelo.Cafe;
import modelo.Producto;
import modelo.Te;
import modelo.Venta;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static modelo.CafeTipo.EXPRESSO;
import static modelo.Size.MEDIANO;
import static modelo.Size.PEQUEÑO;
import static modelo.TeTipo.VERDE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GestorDeArchivosTest {
    private final String ARCHIVO_TEST = "src/main/resources/TestVentas.json";

    @Test
    void leerVentas() {
        List<Venta> ventasLeidas = GestorDeArchivos.leerVentas(ARCHIVO_TEST);

        int total = ventasLeidas.stream().mapToInt(Venta::getTotal).sum();

        assertEquals(3, ventasLeidas.size());
        assertEquals(7500, total);
    }

    @Test
    void testAgregarVenta() throws IOException {
        String archivoTemp = "Test.json";

        List<Venta> ventas = GestorDeArchivos.leerVentas(ARCHIVO_TEST);
        GestorDeArchivos.guardarVentas(ventas, archivoTemp);

        List<Producto> productos = List.of(
                new Te(VERDE, MEDIANO), //1400
                new Cafe(EXPRESSO, PEQUEÑO) //1100
        );

        Venta venta = new Venta(LocalDate.now(), productos);
        GestorDeArchivos.agregarVenta(venta, archivoTemp);

        List<Venta> ventasLeidas = GestorDeArchivos.leerVentas(archivoTemp);
        int total = ventasLeidas.stream().mapToInt(Venta::getTotal).sum();

        assertEquals(4, ventasLeidas.size());
        assertEquals(10000, total);

        Files.deleteIfExists(Path.of(archivoTemp));
    }
}
