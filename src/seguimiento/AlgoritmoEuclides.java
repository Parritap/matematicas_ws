package seguimiento;

public class AlgoritmoEuclides {


    public int encontrarMCD (int x, int y){

        int min = Math.min(x, y); //Número menor del argumento. Math.min() encuentra el menor de dos números.
        int max = Math.max(x, y); //Número mayor del argumento. Math.max() encuentra el mayor de dos números.

        int resto = max % min; //Encontramos el resto de la division entera.

        if (resto ==0)
            return min; //El algoritmo recursivo se detiene cuando el resto sea 0.

        //Si el resto no es 0, entonces evaluamos la función otra vez pero con el divisor y resto como argumentos.
        return encontrarMCD(min, resto);
    }
}
