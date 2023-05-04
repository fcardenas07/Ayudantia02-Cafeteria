import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> redesSociales = new ArrayList<>(List.of("fb", "wsp", "twitter"));

        Cafeteria cafeteria = new Cafeteria("Cafeteria", "AV 1", redesSociales);

        System.out.println(cafeteria);

        System.out.println(cafeteria.getCafesALaVenta());

        cafeteria.agregarCafeVenta("Late", 100, 500, "Grande");
        cafeteria.agregarCafeVenta("Normal", 100, 500, "Grande");
        cafeteria.agregarCafeVenta("Normal", 100, 0, "Grande");
        cafeteria.agregarCafeVenta("Late", 0, 1, "Grande");
        cafeteria.agregarCafeVenta("Late", 100, 100, "asd");

        System.out.println(cafeteria.getCafesALaVenta());

    }
}
