package conjuntos;

import javax.swing.*;
import java.util.Arrays;

public class Interfaz {

    public static void main(String[] args) {

        int[] universo = GUI_crearConjunto();
        System.out.println("El conjunto Universo es " + Arrays.toString(universo));

        int [][] conjuntos = GUI_crearConjuntos();
        print(conjuntos);


        int [] a = conjuntos[0];
        int [] b = conjuntos[1];
        int [] c = conjuntos[2];
        int [] d = conjuntos[3];

        //Imprimir punto A






        //PUNTO A

        int [] AUB = Operaciones.obtenerUnion(a,b);
        int [] AUB_NC = Operaciones.obtenerInterseccion(AUB, c);
        JOptionPane.showInputDialog("Punto A \n" + Arrays.toString(AUB_NC));


        // PUNTO D
        int [] CNB = Operaciones.obtenerInterseccion(c, d);
        int [] CNB_complemento = Operaciones.obtenerComplemento(universo, CNB);
        JOptionPane.showInputDialog("Punto D \n" + Arrays.toString(CNB_complemento));


        //Punto G
        int [] BdifC = Operaciones.obtenerComplementoRelativo(b,c);
        int [] BdifC_difD = Operaciones.obtenerComplementoRelativo(BdifC, d);
        JOptionPane.showInputDialog("Punto G \n" + Arrays.toString(BdifC_difD));



        //Punto B
        int [] BNC = Operaciones.obtenerInterseccion(b,c);
        int [] AU_BNC = Operaciones.obtenerUnion(a, BNC);
        JOptionPane.showInputDialog("Punto B \n" + Arrays.toString(AU_BNC));


        //Punto E
        int [] AUB_difC = Operaciones.obtenerComplementoRelativo(AUB, c);
        JOptionPane.showInputDialog("Punto E \n" + Arrays.toString(AUB_difC));


        //PUNTO H
        int [] CdifD = Operaciones.obtenerComplementoRelativo(c,d);
        int [] Bdif_CdifD = Operaciones.obtenerComplementoRelativo(b, CdifD);
        JOptionPane.showInputDialog("Punto H \n" + Arrays.toString(Bdif_CdifD));













    }

    public static int[] GUI_crearConjunto() {
        int size = Integer.parseInt(JOptionPane.showInputDialog("INGRESE LA CANTIDAD DE ELEMENTOS: "));

        int[] array = new int[size];


        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número entero"));

        }
        return array;
    }

    public static void printXTimes(int cantidadImprimir, String b) {

        for (int i = 0; i < cantidadImprimir; i++) {
            System.out.print(b + "+ ");

        }

    }

    public static int[][] GUI_crearConjuntos() {
        int size = Integer.parseInt(JOptionPane.showInputDialog("INGRESE LA CANTIDAD DE CONJUNTOS"));

        int[][] conjuntos = new int[size][];

        for (int i = 0; i < conjuntos.length; i++) {

            conjuntos[i] = GUI_crearConjunto();

        }
        return conjuntos;
    }

    public static void print(int[][] matrix) {
        for (int[] element : matrix
        ) {
            System.out.println(Arrays.toString(element));
        }
    }
}
