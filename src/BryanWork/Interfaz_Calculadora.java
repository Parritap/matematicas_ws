package BryanWork;

import BryanWork.Interfaz;
import BryanWork.Operaciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Interfaz_Calculadora extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interfaz_Calculadora frame = new Interfaz_Calculadora();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Interfaz_Calculadora() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField("\u00BFQUE OPERACION DE CONJUNTOS\r\nDESEA REALIZAR?");
        textField.setBounds(10, 10, 566, 92);
        textField.setEditable(false);
        textField.setBackground(Color.WHITE);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnInterseccion = new JButton("Interseccion\r\n");
        btnInterseccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int con=1;
                int[] a= Interfaz.GUI_crearConjunto(con++);
                int[] b= Interfaz.GUI_crearConjunto(con++);
                int[] interseccion= Operaciones.obtenerInterseccion(a, b);
                Utilidades.imprimir(""+Arrays.toString(a)+"n"+Arrays.toString(b)+"= "+Arrays.toString(interseccion));

            }
        });
        btnInterseccion.setFont(new Font("Arial", Font.PLAIN, 20));
        btnInterseccion.setBounds(10, 170, 260, 92);
        contentPane.add(btnInterseccion);

        JButton btnComplemento = new JButton("Complemento");
        btnComplemento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int con=1;
                int[] universo = Interfaz.GUI_crearConjuntoUniverso();
                int[] a= Interfaz.GUI_crearConjunto(con++);
                int[] complemento= Operaciones.obtenerComplemento(universo, a);
                Utilidades.imprimir("Complemnto de "+Arrays.toString(a) +"= "+Arrays.toString(complemento));

            }
        });
        btnComplemento.setFont(new Font("Arial", Font.PLAIN, 20));
        btnComplemento.setBounds(10, 335, 260, 106);
        contentPane.add(btnComplemento);

        JButton btnUnion = new JButton("Union\r\n");
        btnUnion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int con=1;
                int[] a= Interfaz.GUI_crearConjunto(con++);
                int[] b= Interfaz.GUI_crearConjunto(con++);
                int[] union= Operaciones.obtenerUnion(a, b);
                Utilidades.imprimir(""+Arrays.toString(a)+"u"+Arrays.toString(b)+"= "+Arrays.toString(union));

            }
        });
        btnUnion.setFont(new Font("Arial", Font.PLAIN, 20));
        btnUnion.setBounds(316, 170, 260, 92);
        contentPane.add(btnUnion);

        JButton btnComplementoRelativo = new JButton("Complemento Relativo");
        btnComplementoRelativo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int con=1;
                int[] a= Interfaz.GUI_crearConjunto(con++);
                int[] b= Interfaz.GUI_crearConjunto(con++);
                int[] complementoR= Operaciones.obtenerComplementoRelativo(a, b);
                Utilidades.imprimir(""+Arrays.toString(a)+"-"+Arrays.toString(b)+"= "+Arrays.toString(complementoR));

            }
        });
        btnComplementoRelativo.setFont(new Font("Arial", Font.PLAIN, 20));
        btnComplementoRelativo.setBounds(316, 335, 260, 106);
        contentPane.add(btnComplementoRelativo);

    }
}