import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CafeTest {
    
    @Test
    void debeArrojarUnaExcepcion_cuandoSeCreaCafeConTipoNull() {
        var exception = assertThrows(IllegalArgumentException.class,
                () -> new Cafe(null, Size.GRANDE, 250, 200));

        assertEquals("Debe indicar un tipo de cafe", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void debeArrojarUnaExcepcion_cuandoSeCreaCafeConGramosMenoresACero(int gramos) {
        var exception = assertThrows(IllegalArgumentException.class,
                () -> new Cafe(CafeTipo.MOKA, Size.GRANDE, 250, gramos));

        assertEquals("Los gramos deben ser mayores a cero", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void debeArrojarUnaExcepcion_cuandoSeCreaCafeConMlAguaMenoresACero(int mlAgua) {
        var exception = assertThrows(IllegalArgumentException.class,
                () -> new Cafe(CafeTipo.MOKA, Size.GRANDE, mlAgua, 200));

        assertEquals("Los ml de agua deben ser mayores a cero", exception.getMessage());
    }

    @Test
    void debeArrojarUnaExcepcion_cuandoSeCreaCafeConSizeNull() {
        var exception = assertThrows(IllegalArgumentException.class,
                () -> new Cafe(CafeTipo.EXPRESSO, null, 250, 200));

        assertEquals("Debe ser un tamaño que este disponible", exception.getMessage());
    }

}