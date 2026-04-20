package es.vrivas.dagil;

/**
 * Hello world!
 */
public final class App {

    private App() {
    }

    /**
     * Filtro para solicitar una posición válida al usuario, en el intervalo [0,maxPos-1].
     * @param maxPos Límite superior para los valores permitidos.
     * @return Número introducido por el usuario.
     */
    private static int dameUnaPosicionValida(final int maxPos) {
        int pos;
        do {
            System.out.println("Indique la posición de la palabra a adivinar " +
                    "(entre 0 y " + (maxPos - 1) + "): ");
            String entrada = System.console().readLine();
            System.out.println();
            pos = Integer.parseInt(entrada);
        } while (pos < 0 || pos >= maxPos);
        return pos;
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        // Pido posición de la palabra
        String[] palabras = { "casa", "ordenador", "procrastinacion", "desacuerdo" };
        int maxErrores = 5;
        int pos = dameUnaPosicionValida(palabras.length);
        String laPalabra = Ahorcado.dameUnaPalabra(palabras, pos);
        String letrasDichas = "";

        // Pide letras mientras no acierte la palabra y no pase del número máximo de errores.
        while (Ahorcado.quedanLetrasPorDescubrir(laPalabra, letrasDichas) &&
                Ahorcado.numErroresCometidos(laPalabra, letrasDichas) < maxErrores) {
            // Primero muestra el estado del juego en este momento.
            System.out.println("---------------------------------------------");
            System.out.println("Letras por descubrir: " +
                    Ahorcado.muestraLetrasPorDescubrir(laPalabra, letrasDichas));
            System.out.println("Errores cometidos: " +
                    Ahorcado.numErroresCometidos(laPalabra, letrasDichas) +
                    " de " + maxErrores + " permitidos.");
            System.out.println("Letras que ya has dicho: " + letrasDichas);

            // A continuación, pide una nueva letra
            System.out.print("Escribe una letra: ");
            String entrada = System.console().readLine();
            Character letra = entrada.charAt(0);

            // Luego, comprueba si ya había dicho es letra
            if (Ahorcado.letraEnPalabra(letra, letrasDichas)) {
                System.out.println("La letra " + letra + " ya la habías dicho.");
            } else {
                // Si no la había dicho, la añade a la ya dichas,
                // y comprueba si estaba o no en la palabra buscada.
                letrasDichas += letra;
                if (Ahorcado.letraEnPalabra(letra, laPalabra)) {
                    System.out.println("¡¡BIEN!! La letra " + letra + " estaba en la palabra que buscamos.");
                } else {
                    System.out.println("¡¡ERROR!! La letra " + letra + " no está en la palabra que buscamos.");

                }
            }
        }

        // Finalmente, comprueba si se ha acertado la palabra o no.
        if (Ahorcado.numErroresCometidos(laPalabra, letrasDichas) < maxErrores) {
            System.out.println(":) Acertaste la palabra: " + laPalabra);
        } else {
            System.out.println(":( No acertaste la palabra.");
        }
    }
}
