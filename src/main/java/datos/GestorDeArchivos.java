package datos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import modelo.Producto;
import modelo.Venta;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorDeArchivos {
    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .registerTypeAdapter(Producto.class, new ProductoAdapter())
            .create();

    public static void guardarVentas(List<Venta> ventas, String ruta) {
        try (var writer = Files.newBufferedWriter(Paths.get(ruta), StandardCharsets.UTF_8)) {
            GSON.toJson(ventas, writer);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<Venta> leerVentas(String ruta) {
        Path path = Path.of(ruta);
        if (!Files.exists(path)) {
            return new ArrayList<>();
        }

        try (var reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            return GSON.fromJson(reader, new TypeToken<List<Venta>>() {}.getType());
        } catch (IOException | JsonIOException | JsonSyntaxException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void agregarVenta(Venta venta, String ruta) {
        List<Venta> ventas = leerVentas(ruta);
        ventas.add(venta);
        guardarVentas(ventas, ruta);
    }
}
