package test;
import utilidades.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import seguimiento.Funcion;

public class Test {

    public static void main(String[] args) {

       int[] dom = {1,2,3};
       int[] rang = {4,5};

       int [][] func = {
               {1,4},
               {2,4},
               {3,5}
       };

       boolean b = Funcion.esSobreyectivaXY(func, dom, rang);
        System.out.println(b);

    }
}
