package utilidades;

import java.util.ArrayList;

public class Utils {

    /**
     * Método que corta un String cuando encuentre una coma, y mete todos los elementos
     * dentro de un arreglo de tipo String.
     *
     * @param str String a cortar.
     * @return Arreglo de Strings sin la coma.
     */
    public static String[] dividirPorComas(String str) {
        return str.split(",");
    }

    /**
     * Convierte un String que debe estar separado por comas
     * en un arreglo de enteros.
     * <p>
     * Es decir, si el String es "1,2,3,4", entonces el método retornará el siguiente arreglo de enteros: {1,2,3,4}
     *
     * @param str String que se divide por las comas y cuyos elementos se convierte en números.
     * @return Arreglo de numeros.
     */
    public static int[] StringToIntArray(String str) {

        String[] strArray = dividirPorComas(str);
        int[] intArray = new int[strArray.length];

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }

        return intArray;
    }

    public static int[] toIntArray(ArrayList<Integer> list) {

        int[] array = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

}
