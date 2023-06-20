package modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CafeTest {
    
    @Test
    void debeArrojarUnaExcepcion_cuandoSeCreaCafeConTipoNull() {
        var exception = assertThrows(IllegalArgumentException.class,
                () -> new Cafe(null, Size.GRANDE));

        assertEquals("Tipo no valido", exception.getMessage());
    }

    @Test
    void debeArrojarUnaExcepcion_cuandoSeCreaCafeConSizeNull() {
        var exception = assertThrows(IllegalArgumentException.class,
                () -> new Cafe(CafeTipo.EXPRESSO, null));

        assertEquals("Size no valido", exception.getMessage());
    }
}