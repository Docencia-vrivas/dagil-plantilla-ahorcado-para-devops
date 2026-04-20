package es.vrivas.dagil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;;

class AhorcadoTest {
    @Test
    void dameUnaPalabra_test() {
        String[] ps = { "cero", "uno", "dos" };
        assertEquals("cero", Ahorcado.dameUnaPalabra(ps, 0));
        assertEquals("dos", Ahorcado.dameUnaPalabra(ps, 2));
    }

    @Test
    void dameUnaPalabra_excepciones() {
        String[] ps = { "cero", "uno", "dos" };
        IllegalArgumentException excepcion = assertThrows(
                IllegalArgumentException.class,
                () -> Ahorcado.dameUnaPalabra(ps, -1),
                "dameUnaPalabra debía lanzar una excepción, y no lo hizo.");

        assertTrue(excepcion.getMessage().contains("negativa"));

        excepcion = assertThrows(
                IllegalArgumentException.class,
                () -> Ahorcado.dameUnaPalabra(ps, 20),
                "dameUnaPalabra debía lanzar una excepción, y no lo hizo.");

        assertTrue(excepcion.getMessage().contains("mayor que"));

    }

    @Test
    void quedanLetrasPorDescubrir_test() {
        assertFalse(Ahorcado.quedanLetrasPorDescubrir("elefante", ""));
        assertTrue(Ahorcado.quedanLetrasPorDescubrir("elefante", "el"));
        assertTrue(Ahorcado.quedanLetrasPorDescubrir("elefante", "elfn"));
        assertTrue(Ahorcado.quedanLetrasPorDescubrir("elefante", "lfnt"));
        assertTrue(Ahorcado.quedanLetrasPorDescubrir("elefante", "fn"));
        assertFalse(Ahorcado.quedanLetrasPorDescubrir("elefante", "letnfa"));
        assertFalse(Ahorcado.quedanLetrasPorDescubrir("elefante", "elwfant"));
        assertFalse(Ahorcado.quedanLetrasPorDescubrir("elefante", "hjktnafle"));
    }

    @Test
    public void letraEnPalabra_test() {
        assertFalse(Ahorcado.letraEnPalabra('a', null));
        assertFalse(Ahorcado.letraEnPalabra('a', ""));
        assertFalse(Ahorcado.letraEnPalabra('a', "c"));
        assertFalse(Ahorcado.letraEnPalabra('a', "co"));
        assertTrue(Ahorcado.letraEnPalabra('a', "a"));
        assertTrue(Ahorcado.letraEnPalabra('a', "ahora"));
        assertTrue(Ahorcado.letraEnPalabra('a', "loma"));
    }

    @Test
    public void muestraLetrasPorDescubrir_test() {
        assertEquals("-a-a", Ahorcado.muestraLetrasPorDescubrir("casa", "a"));
        assertEquals("c---", Ahorcado.muestraLetrasPorDescubrir("casa", "c"));
        assertEquals("c-s-", Ahorcado.muestraLetrasPorDescubrir("casa", "cefs"));
        assertEquals("casa", Ahorcado.muestraLetrasPorDescubrir("casa", "cefsdea"));
        assertEquals("-est----ll----", Ahorcado.muestraLetrasPorDescubrir("destornillador", "esltgs"));
    }

    @Test
    public void numErroresCometidos_test() {
        assertEquals(0, Ahorcado.numErroresCometidos("casa", "a"));
        assertEquals(1, Ahorcado.numErroresCometidos("casa", "csd"));
        assertEquals(2, Ahorcado.numErroresCometidos("casa", "dcst"));
        assertEquals(3, Ahorcado.numErroresCometidos("casa", "poi"));
        assertEquals(0, Ahorcado.numErroresCometidos("destornillador", "destornillador"));
    }
}
