package seguimiento;

public class sumatorias {

    public static void main(String[] args) {

        System.out.println(obtenerStringSumaImpares(7));

    }

    public static int sumarPrimeros_N_Impares(int n) {
        int suma = 0;
        for (int i = 1, k = 0; k < n; i++) {

            if (i % 2 == 1) {
                suma += i;
                k++;
            }
        }
        return suma;
    }

    /**
     * Método que obtiene el string que muestra la suma de los impares hasta el número dado.
     *
     * @param n Limite de las suma.
     * @return String que representa la suma de los impares.
     */
    public static String obtenerStringSumaImpares(int n) {
        StringBuilder str = new StringBuilder();

        for (int i = 1, k = 0; k < n; i++) {

            if (i % 2 == 1) {
                str.append(i).append("+");
                k++;
            }
        }

        return str.append("=").append(sumarPrimeros_N_Impares(n)).toString();
    }
}
