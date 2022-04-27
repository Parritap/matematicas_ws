package BryanWork;


public class Operaciones {
    /**
     * M�todo que retorna la UNION entre dos conjuntos dados.
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] obtenerUnion(int[] a, int[] b) {
        int[] union = new int[calcularTamanioUnion(a, b)];
        int posCont = 0;
        for (int i = 0; i < a.length; i++) {
            union[i] = a[i];
            posCont++;
        }
        for (int i = 0; i < b.length; i++) {
            boolean hayRep = false;
            for (int j = 0; j < union.length && !hayRep; j++) {
                if (b[i] == union[j]) {
                    hayRep = true;
                }
            }
            if (!hayRep)
                union[posCont++] = b[i];
        }
        return union;
    }
    /**
     * M�todo que retorna el conjunto intersecci�n entre dos conjuntos dados.
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] obtenerInterseccion(int[] a, int[] b) {
        int[] interseccion = new int[calcularRepeticiones(a, b)];
        int posCounter = 0;
        for (int i = 0; i < a.length; i++) {
            boolean repeticion = false;
            for (int j = 0; j < b.length && !repeticion; j++) {
                if (a[i] == b[j]) {
                    interseccion[posCounter] = a[i];
                    posCounter++;
                }
            }
        }
        return interseccion;
    }

    /**
     * M�todo que retorna el conjunto diferencia sim�trica entre dos conjuntos dados.
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] obtenerDifSimetrica(int[] a, int[] b) {
        int[] difSimetrica = new int[calcularTamanioDifSimetrica(a, b)];
        int pos = 0;
        int[] union = obtenerUnion(a, b);
        int[] interseccion = obtenerInterseccion(a, b);
        for (int i = 0; i < union.length; i++) {
            boolean repeticion = false;
            for (int j = 0; j < interseccion.length; j++) {
                if (union[i] == interseccion[j]) {
                    repeticion = true;
                }
            }
            if (!repeticion) {
                difSimetrica[pos] = union[i];
                pos++;
            }
        }
        return difSimetrica;
    }
    /**
     * Calcula la cantidad de elementos que hay repetidos entre dos conjuntos @a y @b.
     *
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
     * M�todo que calcula el cardinal del conjunto que resulte de unir un conjunto @a y un conjunto @b.
     *
     * @param a
     * @param b
     * @return
     */
    public static int calcularTamanioUnion(int[] a, int[] b) {
        int rep = calcularRepeticiones(a, b);
        return a.length + b.length - rep;
    }
    /**
     * M�todo que calcula el cardinal del conjunto resultante de la union sim�trica de dos conjuntos @a y @b.
     *
     * @param a
     * @param b
     * @return
     */
    public static int calcularTamanioDifSimetrica(int[] a, int[] b) {
        int rep = calcularRepeticiones(a, b);
        int tamanio = calcularTamanioUnion(a, b) - rep;

        return tamanio;
        }


    public static int calcularTamnioComplementoRelativo(int[] a, int[] b) {

        int rep = calcularRepeticiones(a, b);

        int tamanio = a.length - rep;
        return tamanio;
    }

    public static int[] obtenerComplementoRelativo(int[] a, int[] b) {
        int[] comRelativ = new int[calcularTamnioComplementoRelativo(a, b)];
        int pos = 0;
        for (int i = 0; i < a.length; i++) {

            boolean hayRep = false;

            for (int j = 0; j < b.length && !hayRep; j++) {

                if (a[i] == b[j])
                    hayRep = true;
            }

            if (!hayRep) {
                comRelativ[pos] = a[i];
                pos++;
            }

        }
        return comRelativ;
    }

    /**
     * M�todo que obtiene el complement de un conjunto.
     *
     * @param universo
     * @param a
     * @return
     */
    public static int[] obtenerComplemento(int[] universo, int[] a) {
        return obtenerComplementoRelativo(universo, a);
    }


}