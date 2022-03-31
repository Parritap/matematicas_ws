package conjuntos;

public class Operaciones {


    /**
     * Método que realiza la operation UNION entre dos conjuntos dados.
     * @param a
     * @param b
     * @return
     */
    public static int[] obtenerUnion(int[] a, int[] b) {

        int[] union =  new int [calcularTamanioUnion(a, b)];
        int posCont =0;

        for (int i = 0; i < a.length; i++) {
            union[i] = a[i];
            posCont++;
        }

        for (int i = 0; i < b.length; i++) {

            boolean hayRep = false;

            for (int j = 0; j <union.length && !hayRep ; j++) {

                if (b[i]==union[j]){
                    hayRep = true;
                }
            }

            if (!hayRep)
                union[posCont++] = b[i];
        }


        return union;
    }


    public static int[] obtenerInterseccion (int[] a, int[] b){

        int[] interseccion = new int[calcularRepeticiones(a,b)];

        for (int i = 0; i < a.length; i++) {

            boolean repeticion = false;

            for (int j = 0; j < b.length; j++) {

            }

        }


        return interseccion;
    }



    /**
     * Calcula la cantidad de elementos que hay repetidos entre dos conjuntos @a y @b.
     * @param a
     * @param b
     * @return
     */
    public static int calcularRepeticiones(int[] a, int[] b) {

        int counter = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j])
                    counter++;
            }
        }
        return counter;
    }


    /**
     * Método que calcula el cardinal del conjunto que resulte de unir un conjunto @a y un conjunto @b.
     * @param a
     * @param b
     * @return
     */
    public static int calcularTamanioUnion(int[] a, int[] b) {
        int rep = calcularRepeticiones(a, b);
        return a.length + b.length - rep;
    }


    /**
     * Método que calcula el cardinal del conjunto resultante de la union simétrica de dos conjuntos @a y @b.
     * @param a
     * @param b
     * @return
     */
    public static int calcularTamanioDifSimetrica(int[] a, int[] b) {
        int rep = calcularRepeticiones(a, b);
        int tamanio = calcularTamanioUnion(a, b) - rep;

        return tamanio;
    }
}
