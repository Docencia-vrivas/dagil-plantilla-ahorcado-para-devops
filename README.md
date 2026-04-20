# Juego del Ahorcado en Java

Este programa implementa el juego del Ahorcado usando métodos susceptibles de ser probadoas con TDD.

El objetivo es comprobar cómo cada vez que creamos los tests para un método y hacemos el correspondiente _commit_, se ejecuta automáticamente una _action_ en GitHub que hace el testeo automático.

**Secciones de de este documento**

- [Juego del Ahorcado en Java](#juego-del-ahorcado-en-java)
  - [Ficheros en el paquete:](#ficheros-en-el-paquete)
  - [Métodos dentro de Ahorcado.java](#métodos-dentro-de-ahorcadojava)
  - [Ejemplo de ejecución del programa:](#ejemplo-de-ejecución-del-programa)
  - [Ejercicios a realizar:](#ejercicios-a-realizar)

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

## Ejemplo de ejecución del programa:

```bash
Indique la posición de la palabra a adivinar (entre 0 y 3):
1

---------------------------------------------
Letras por descubrir: ---------
Errores cometidos: 0 de 5 permitidos.
Letras que ya has dicho:
Escribe una letra: a
¡¡BIEN!! La letra a estaba en la palabra que buscamos.
---------------------------------------------
Letras por descubrir: -----a---
Errores cometidos: 0 de 5 permitidos.
Letras que ya has dicho: a
Escribe una letra: d
¡¡BIEN!! La letra d estaba en la palabra que buscamos.
---------------------------------------------
Letras por descubrir: --d--ad--
Errores cometidos: 0 de 5 permitidos.
Letras que ya has dicho: ad
Escribe una letra: s
¡¡ERROR!! La letra s no está en la palabra que buscamos.
---------------------------------------------
Letras por descubrir: --d--ad--
Errores cometidos: 1 de 5 permitidos.
Letras que ya has dicho: ads
Escribe una letra: u
¡¡ERROR!! La letra u no está en la palabra que buscamos.
---------------------------------------------
Letras por descubrir: --d--ad--
Errores cometidos: 2 de 5 permitidos.
Letras que ya has dicho: adsu
Escribe una letra: e
¡¡BIEN!! La letra e estaba en la palabra que buscamos.
---------------------------------------------
Letras por descubrir: --de-ad--
Errores cometidos: 2 de 5 permitidos.
Letras que ya has dicho: adsue
Escribe una letra: c
¡¡ERROR!! La letra c no está en la palabra que buscamos.
---------------------------------------------
Letras por descubrir: --de-ad--
Errores cometidos: 3 de 5 permitidos.
Letras que ya has dicho: adsuec
Escribe una letra: n
¡¡BIEN!! La letra n estaba en la palabra que buscamos.
---------------------------------------------
Letras por descubrir: --denad--
Errores cometidos: 3 de 5 permitidos.
Letras que ya has dicho: adsuecn
Escribe una letra: o
¡¡BIEN!! La letra o estaba en la palabra que buscamos.
---------------------------------------------
Letras por descubrir: o-denado-
Errores cometidos: 3 de 5 permitidos.
Letras que ya has dicho: adsuecno
Escribe una letra: r
¡¡BIEN!! La letra r estaba en la palabra que buscamos.
:) Acertaste la palabra: ordenador
```

## Ejercicios a realizar:

- Escribe los tests que faltan en el método `public void letraEnPalabra_test()` de _AhorcadoTest.java_
- Escribe los tests que faltan en el método `public void numErroresCometidos_test` de _AhorcadoTest.java_
- Corrige el resultado devuelto por `public static final boolean quedanLetrasPorDescubrir` de _Ahorcado.java_
- Corrige el resultado devuelto por `public static final String muestraLetrasPorDescubrir` de _Ahorcado.java_
