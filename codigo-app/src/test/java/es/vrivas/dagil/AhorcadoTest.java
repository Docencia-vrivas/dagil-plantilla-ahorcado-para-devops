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
        assertTrue(Ahorcado.quedanLetrasPorDescubrir("elefante", ""));
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
        // Ejemplo de uso del método: Ahorcado.letraEnPalabra('a', "sarten") debe devolver true;

        // @TODO Comprueba que para el valor NULL en la cadena devuelve false con cualquier letra que le des.

        // @TODO Comprueba que para la cadena vacía devuelve false

        // @TODO Comprueba que la letra no aparece en una cadena de tamaño 1 que no la contiene

        // @TODO Comprueba que la letra no aparece en una cadena de tamaño 2 que no la contiene

        // @TODO Comprueba que la letra SI aparece en una cadena de tamaño 1 que la contiene

        // @TODO Comprueba que la letra SI aparece en una cadena de tamaño mayor que 1 que sí la contiene

        // @TODO Comprueba que la letra SI aparece en una cadena de tamaño mayor que 1 que sí la contiene en la últia posición.
    }

    @Test
    public void numErroresCometidos_test() {
        // Ejemplo de uso del método: Ahorcado.numErroresCometidos("casa", "cdfga") debe devolver 3;
        // Para las pruebas, usa palabras en las que se repitan las letras, como: destornillador

        // @TODO Comprueba que devuelve 0 errores

        // @TODO Comprueba que devuelve 1 error

        // @TODO Comprueba que devuelve 2 errores

        // @TODO Comprueba que devuelve 10 errores 

    }

    @Test
    public void muestraLetrasPorDescubrir_test() {
        assertEquals("-a-a", Ahorcado.muestraLetrasPorDescubrir("casa", "a"));
        assertEquals("c---", Ahorcado.muestraLetrasPorDescubrir("casa", "c"));
        assertEquals("c-s-", Ahorcado.muestraLetrasPorDescubrir("casa", "cefs"));
        assertEquals("casa", Ahorcado.muestraLetrasPorDescubrir("casa", "cefsdea"));
        assertEquals("-est----ll----", Ahorcado.muestraLetrasPorDescubrir("destornillador", "esltgs"));
    }

}
