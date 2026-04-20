# Juego del Ahorcado en Java

Este programa implementa el juego del Ahorcado usando métodos susceptibles de ser probadoas con TDD.

El objetivo es comprobar cómo cada vez que creamos los tests para un método y hacemos el correspondiente _commit_, se ejecuta automáticamente una _action_ en GitHub que hace el testeo automático.

## Ficheros en el paquete:

```
pom.xml
README.md
.gitignore
codigo-app/
    |
    +----src/
          |
          +----main/java/es/vrivas/dagil/
          |          |
          |          + Ahorcado.java
          |          + App.java
          |
          +----test/java/es/vrivas/dagil/
                     |
                     + AhorcadoTest.java
                     + AppTest.java
```

El repositorio está organizado de forma que _App.java_ simplemente muestra los datos en pantalla, mientras los métodos de _Ahorcado.java_ son los que realizan los cálculos.

## Métodos dentro de Ahorcado.java

```java
/**
     * Devuelve la palabra que está en la posición pos del vector palabras.
     * @param palabras Vector de cadenas
     * @param pos Posición de la palabra que quiero recuperar
     * @return Una palabra de las contenidas en el vector.
     * @throws IllegalArgumentException Si pos<0
     * @throws IllegalArgumentException Si pos>=palabras.length
     */
    public static String dameUnaPalabra(final String[] palabras, final int pos) throws IllegalArgumentException
```

```java
/**
     * Comprueba si quedan letras por decir en una palabra.
     * @param palabra Palabra a descubrir
     * @param letrasDichas Letras que ya se han dicho
     * @pre letrasDichas no puede tener caracteres repetidos
     * @return True si quedan letras por descubrir; false en otro caso.
     */
    static public boolean quedanLetrasPorDescubrir(final String palabra,
            final String letrasDichas)
```

```java
/**
     * Comprueba si una letra aparece en una palabra.
     * @param letra La letra a buscar.
     * @param palabra La palabra en la que buscar.
     * @return True si la letra aparece; false en caso contrario.
     */
    public static final boolean letraEnPalabra(final Character letra,
            final String palabra)
```

```java
/**
     * Genera una cadena con guiones en aquellas letras que faltan por descubrir.
     * @param palabra Palabra a adivinar.
     * @param letrasDichas Letras que ya ha dicho el jugador.
     * @return Cadena con guiones en las letras por descubrir y las letras ya descubiertas en su sitio.
     */
    public static final String muestraLetrasPorDescubrir(final String palabra, final String letrasDichas)
```

```java
/**
     * Devuelve el número de errores cometidos por las letras dichas que no están en la palabra.
     * @param palabra Palabra a descubrir.
     * @param letrasDichas Letras que ha dicho el usuario.
     * @return Número de letras dichas que NO están en la palabra.
     */
    public static final int numErroresCometidos(final String palabra, final String letrasDichas)
```
