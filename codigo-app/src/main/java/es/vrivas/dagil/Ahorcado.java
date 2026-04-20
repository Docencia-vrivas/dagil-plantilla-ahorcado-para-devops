package es.vrivas.dagil;

public final class Ahorcado {

    private Ahorcado() {
    }

    /**
     * Devuelve la palabra que está en la posición pos del vector palabras.
     * @param palabras Vector de cadenas
     * @param pos Posición de la palabra que quiero recuperar
     * @return Una palabra de las contenidas en el vector.
     * @throws IllegalArgumentException Si pos<0
     * @throws IllegalArgumentException Si pos>=palabras.length
     */
    public static String dameUnaPalabra(final String[] palabras, final int pos) throws IllegalArgumentException {
        if (pos < 0)
            throw new IllegalArgumentException("App:dameUnaPalabra: la posición solicitada no puede ser negativa.");
        if (pos >= palabras.length)
            throw new IllegalArgumentException(
                    "App:dameUnaPalabra: la posición solicitada no puede ser mayor que el número de palabras en el vector.");
        return palabras[pos];
    }

    /**
     * Comprueba si quedan letras por decir en una palabra.
     * @param palabra Palabra a descubrir
     * @param letrasDichas Letras que ya se han dicho
     * @pre letrasDichas no puede tener caracteres repetidos
     * @return True si quedan letras por descubrir; false en otro caso.
     */
    static public boolean quedanLetrasPorDescubrir(final String palabra,
            final String letrasDichas) {
        int encontradas = 0;
        for (int i = 0; i < letrasDichas.length(); ++i) {
            for (int j = 0; j < palabra.length(); ++j) {
                if (palabra.charAt(j) == letrasDichas.charAt(i))
                    ++encontradas;
            }
        }
        return !(encontradas == palabra.length());
    }

    /**
     * Comprueba si una letra aparece en una palabra.
     * @param letra La letra a buscar.
     * @param palabra La palabra en la que buscar.
     * @return True si la letra aparece; false en caso contrario.
     */
    public static final boolean letraEnPalabra(final Character letra,
            final String palabra) {
        if (palabra == null)
            return false;
        return palabra.indexOf(letra, 0) != -1;
    }

    /**
     * Genera una cadena con guiones en aquellas letras que faltan por descubrir.
     * @param palabra Palabra a adivinar.
     * @param letrasDichas Letras que ya ha dicho el jugador.
     * @return Cadena con guiones en las letras por descubrir y las letras ya descubiertas en su sitio.
     */
    public static final String muestraLetrasPorDescubrir(final String palabra, final String letrasDichas) {
        String resultado = "";
        for (int i = 0; i < palabra.length(); ++i) {
            resultado += "-";
        }
        for (int i = 0; i < letrasDichas.length(); ++i) {
            int pos = 0;
            while (pos != -1) {
                pos = palabra.indexOf(letrasDichas.charAt(i), pos);
                if (pos != -1) {
                    resultado = resultado.substring(0, pos) + letrasDichas.charAt(i) +
                            resultado.substring(pos + 1);
                    ++pos;
                }
            }
        }
        return resultado;
    }

    /**
     * Devuelve el número de errores cometidos por las letras dichas que no están en la palabra.
     * @param palabra Palabra a descubrir.
     * @param letrasDichas Letras que ha dicho el usuario.
     * @return Número de letras dichas que NO están en la palabra.
     */
    public static final int numErroresCometidos(final String palabra, final String letrasDichas) {
        int numErrores = 0;
        for (int i = 0; i < letrasDichas.length(); ++i) {
            numErrores += (palabra.indexOf(letrasDichas.charAt(i), 0) == -1) ? 1 : 0;
        }
        return numErrores;
    }
}
