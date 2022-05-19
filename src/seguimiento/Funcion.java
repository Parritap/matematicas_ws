package seguimiento;

import utilidades.Utils;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class Funcion {

 // public static int[][][] generarFunciones(int[] A, int[] B) {
 //     int m = A.length;
 //     int n = B.length;
 //     int cantFunc = (int) Math.pow(n, m); //cantidad de Funciones de A en B.

 //     int[][][] conjuntoFunciones = new int[cantFunc][m][];

 //     for (int i = 0; i < conjuntoFunciones.length ; i++) {

 //         //conjuntoFunciones.length

 //     }



 //     return conjuntoFunciones;
 // }


    /**
     * Método que retorna si una función es inyectiva.
     * @param funcion Conjunto de pares ordenados a evaluar (matriz de puntos de n filas y dos columnas).
     * @return True si un y aparece una y solo uan vez dentro de la función.
     */
    public static boolean esInyectivaXY(int[][] funcion) {

        //Cada fila es una función. Dentro de la función hay dos valores {x, y}.

        //Los siguiente dos for se usan para extraer un elemento, el cual se va a evaluar.
        for (int i = 0; i < funcion.length; i++) {
            for (int j = 0; j < funcion[i].length; j++) {

                int y = funcion[i][1];

                //Los siguientes dos for se usan para saber si hay más elementos iguales al y extraído en la linea anterior.
                // De haberlos, entonces la función no es inyectiva.
                for (int k = 0; k < funcion.length; k++) {

                    if (k != i) {
                        for (int l = 0; l < funcion[k].length; l++) {
                            if (y == funcion[k][l])
                                return false;
                        }
                    }

                }
            }
        }
        return true;
    }


    /**
     * Método que evalúa si una función es inyectiva.
     * @param funcion Conjunto de pares ordenados a evaluar (matriz de puntos de n filas y dos columnas).
     * @param dom Dominio de la función.
     * @param rang Rango de la función.
     * @return True si la función cumple que el dominio es exactamente igual al rango.
     */
    public static boolean esSobreyectivaXY(int[][] funcion, int[] dom, int[] rang) {

        //Cada fila es una función. Dentro de la función hay dos valores {x, y}.

        ArrayList<Integer> valoresY = new ArrayList<>();


        //Los siguientes dos for se usan para extraer un elemento, el cual se va a evaluar.
        for (int[] parOrdenado : funcion) {

            int y = parOrdenado[1]; //Esto extrae el elemento y del par ordenado.

            if (!valoresY.contains(y)) //Si el valor extraído no se encuentra ya dentro de la lista, entonces lo metemos.
                valoresY.add(y);
        }

        int[] arrValoresY = Utils.toIntArray(valoresY);
        Arrays.sort(arrValoresY); //volvemos un arreglo la lista obtenida de los valores y en (x, y) en la función.

        int[] auxRang = rang;
        Arrays.sort(auxRang); //Creamos un arreglo manipulable con el rango pasado en el argumento.

        if (arrValoresY.length != auxRang.length)
            return false; //Si el cardinal de ambos conjuntos es distinto, entonces retornar false,
        // porque en las funciones sobreyectivas, el rango es igual al codominio.

        //Pasamos a evaluar si los elementos de los dos conjuntos son iguales. Recordar que ya está organizados en orden ascendente.
        for (int i = 0; i < arrValoresY.length; i++) {
            if (arrValoresY[i] != auxRang[i])
                return false; //Esto es, si los elementos de ambos arreglos no coinciden, entonces significa que 3
        }


        return true;
    }


    /**
     * Método que verifica si una función es biyectiva.
     * @param funcion Conjunto de pares ordenados a evaluar (matriz de puntos de n filas y dos columnas).
     * @param dom Dominio de la función.
     * @param rang Rango de la función.
     * @return True si la función cumple que es inyectiva y sobreyectiva. False de lo contrario.
     */
    public static boolean esBiyectiva (int [][] funcion, int[] dom, int[] rang){
        return esSobreyectivaXY(funcion, dom, rang) && esInyectivaXY(funcion);
    }

}
