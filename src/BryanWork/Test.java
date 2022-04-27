package BryanWork;
import conjuntos.Operaciones;

import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
        int[] arrayU = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] cA = {1, 2, 3, 4, 5};
        int[] cB = {3, 4, 5, 6, 7, 8};
        int[] cC = {7, 8, 9};
        /*Operaciones binarias **/
        //A
        int[] intersecAB = Operaciones.obtenerInterseccion(cA, cB);
        System.out.println("a) " +Arrays.toString(intersecAB));
        //B
        int[] unionAB = Operaciones.obtenerUnion(cA, cB);
        System.out.println("b) " + Arrays.toString(unionAB));
        //C
        int[] intersecBC =  Operaciones.obtenerInterseccion(cB, cC);
        System.out.println("c) "+Arrays.toString(intersecBC));
        //D
        int[] intersecAC =  Operaciones.obtenerInterseccion(cA, cC);
        System.out.println("d) " + Arrays.toString(intersecAC));
        //E
        int [] difSimetricaAB = Operaciones.obtenerDifSimetrica(cA, cB);
        System.out.println("e)" +Arrays.toString(difSimetricaAB));
        //F
        int [] unionAC = Operaciones.obtenerUnion(cA, cC);
        System.out.println("f) " +Arrays.toString(unionAC));
        //G
        int [] difSimetricaAC = Operaciones.obtenerDifSimetrica(cA, cC);
        System.out.println("g) " +Arrays.toString(difSimetricaAC));



        /** COMPLEMENTO RELATIVO**/

        int [] complementoRelativoA = Operaciones.obtenerComplementoRelativo(arrayU, cA);
        System.out.println("El complemento Relativo de U respecto a A es" + Arrays.toString(complementoRelativoA));
    }
}