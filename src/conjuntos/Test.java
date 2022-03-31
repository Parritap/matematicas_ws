package conjuntos;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {


        int[] arrayU = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arrayA = {1, 2, 3, 4, 5};
        int[] arrayB = {3, 4, 5, 6, 7};
        int[] arrayC = {7, 8, 9};

        /*Operaciones binarias **/

        int[] unirAB = Operaciones.obtenerUnion(arrayA, arrayB);
        System.out.println(Arrays.toString(unirAB));




    }
}
