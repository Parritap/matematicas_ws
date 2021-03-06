package BryanWork;

import javax.swing.*;

public class Utilidades {
    /**
     * Permite leer un numero double mediante una caja de dialogo
     * @param mensaje El mensaje que verá el usuario
     * @return el numero ingresado por el usuario
     */

    public static double leerDouble (String mensaje)
    {
        double dato= Double.parseDouble(JOptionPane.showInputDialog(mensaje));
        return dato;
    }

    /**
     * Permite leer un numero entero mediante una caja de dialogo
     * @param mensaje El mensaje que verá el usuario
     * @return el numero ingresado por el usuario
     */
    public static int leerEntero (String mensaje)
    {
        int dato= Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        return dato;
    }


    /**
     * Permite leer un caracter mediante una caja de dialogo
     * @param mensaje El mensaje que verá el usuario
     * @return el caracter ingresado por el usuario
     */
    public static char leerChar(String mensaje)
    {
        char dato= (JOptionPane.showInputDialog(mensaje)).charAt(0);
        return dato;
    }

    /**
     * Permite leer una cadena de caracteres mediante una caja de dialogo
     * @param mensaje El mensaje que verá el usuario
     * @return el string ingresado por el usuario
     */
    public static String leerString (String mensaje)
    {
        String dato= JOptionPane.showInputDialog(mensaje);
        return dato;
    }


    /**
     * Permite leer un boolean
     * @param mensaje El mensaje mostrado al usuario
     * @return un boolean, true si presiona el boton si, false en caso contrario
     */
    public static boolean leerBoolean (String mensaje)
    {
        boolean centinela=false;
        int result = JOptionPane.showConfirmDialog(null,
                mensaje,null, JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.YES_OPTION) {
            centinela=true;
        }
        return centinela;
    }

    /**
     * Permite imprimir un mensaje
     * @param mensaje El mensaje a imprimir
     */
    public static void imprimir (String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
}