package seguimiento;

import utilidades.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;

public class Funcion {

    public static String informarTipoFuncion (int[][] func, int[] dom, int[] cod){

        int option = verificarTipoFuncion(func, dom, cod);

        if(option ==0)
            System.out.println("NO ES FUNCION");

        if(option ==1)
            System.out.println("Inyectiva");

        if(option ==2)
            System.out.println("Sobreyectiva");

        if(option ==3)
            System.out.println("Biyectiva");


        return "..........";
    }

    public static int verificarTipoFuncion(int[][] func, int[] dom, int[] cod) {
        //Si no es función, retorna 0.
        //Si es inyectiva, retorna 1.
        //Si es sobreyectiva, retorna 2.
        //Si es biyectiva, retorna 3.
        //Si hay algún error, retorna -1;

        if (!esFuncion(func, dom))
            return 0;

        if (esBiyectiva(func, dom, cod)) {
            return 3;

        } else {
            if (esSobreyectivaXY(func, dom, cod))
                return 2;

            if (esInyectivaXY(func))
                return 1;
        }


        return -1;
    }

    public static boolean esFuncion(int[][] func, int[] dom) {

        int[] d = removerDuplicados(dom); //dominio "dom" pasado en el argumento.
        Arrays.sort(d); //Ordenamos el dominio.

        ArrayList<Integer> domFunc = new ArrayList<>(); //Extraemos el dominio de la función "func".

        for (int[] funcion : func) {
            domFunc.add(funcion[0]);
        }

        //Si la cantidad de elementos que tiene la función no es igual la del dominion indicado en el argumento, entocnes no es funcion.
        if (domFunc.size() != d.length)
            return false;

        Collections.sort(domFunc);

        //Revisamos que los elementos contenidos en ambos dominios sean iguales. Si no lo son, no es arreglo.
        for (int i = 0; i < d.length; i++) {
            if (d[i] != domFunc.get(i))
                return false;
        }

        return true;
    }


    /**
     * Método que retorna si una función es inyectiva.
     *
     * @param funcion Conjunto de pares ordenados a evaluar (matriz de puntos de n filas y dos columnas).
     * @return True si un las componentes en "y" aparecen una y solo una vez dentro de la función.
     */
    public static boolean esInyectivaXY(int[][] funcion) {

        //Cada fila es una función. Dentro de la función hay dos valores {x, y}.

        //Los siguientes dos for se usan para extraer un elemento, el cual se va a evaluar.
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
     *
     * @param funcion Conjunto de pares ordenados a evaluar (matriz de puntos de n filas y dos columnas).
     * @param dom     Dominio de la función.
     * @param cod     codominio de la función.
     * @return True si la función cumple que el dominio es exactamente igual al rango.
     */
    public static boolean esSobreyectivaXY(int[][] funcion, int[] dom, int[] cod) {

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

        int[] auxRang = cod;
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
     *
     * @param funcion Conjunto de pares ordenados a evaluar (matriz de puntos de n filas y dos columnas).
     * @param dom     Dominio de la función.
     * @param rang    Rango de la función.
     * @return True si la función cumple que es inyectiva y sobreyectiva. False de lo contrario.
     */
    public static boolean esBiyectiva(int[][] funcion, int[] dom, int[] rang) {
        return esSobreyectivaXY(funcion, dom, rang) && esInyectivaXY(funcion);
    }


    public static boolean hayDuplicados(int[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if ((i != j) && input[i] == (input[j])) {
                    return true;
                }
            }
        }
        return false;
    }


    public static int[] removerDuplicados(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int element : array) {
            if (!list.contains(element))
                list.add(element);
        }
        return toIntArray(list);
    }

    public static int[] toIntArray(ArrayList<Integer> list) {

        int[] array = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
