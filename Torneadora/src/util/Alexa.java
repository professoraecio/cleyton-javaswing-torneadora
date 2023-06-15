/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author mastermac
 */
public class Alexa {
    /**
     * Escrever uma String no terminal
     *
     * @param texto String
     */
    public static void escreva(String texto) {
        System.out.print(texto);
    }

    /**
     * Escrever uma String no terminal
     *
     * @param texto String
     */
    public static void escreva(String texto, Double numero) {
        System.out.printf(texto + "%.2f", numero);
    }

    /**
     * Ler uma String no terminal
     *
     * @return String
     */
    public static String leiaString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
    
            /**
     * Ler uma String no terminal
     *
     * @return String
     */
    public static String leiaString(String texto) {
        System.out.printf(texto);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    /**
     * Ler um Integer no terminal
     *
     * @return Integer
     */
    public static int leiaInteger() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    /**
     * Ler um Integer no terminal
     *
     * @param texto String
     * @return Integer
     */
    public static int leiaInteger(String texto) {
        Scanner input = new Scanner(System.in);
        boolean executouComSucesso = false;
        int i = 0;
        do {
            try {
                Alexa.escreva(texto);
                input = new Scanner(System.in);
                i = input.nextInt();
                executouComSucesso = true;
            } catch (Exception e) {
                Alexa.escreva("\nDado invalido, favor informar novamente\n");
            }
        } while (executouComSucesso == false);
        return i;
    }

    /**
     * Ler um Double no terminal
     *
     * @return Double
     */
    public static double leiaDouble() {
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }

    /**
     * Ler um Integer no terminal
     *
     * @param texto String
     * @return Integer
     */
    public static double leiaDouble(String texto) {
        Scanner input = new Scanner(System.in);
        boolean executouComSucesso = false;
        double d = 0;
        do {
            try {
                Alexa.escreva(texto);
                input = new Scanner(System.in);
                d = input.nextInt();
                executouComSucesso = true;
            } catch (Exception e) {
                Alexa.escreva("\nDado invalido, favor informar novamente\n");
            }
        } while (executouComSucesso == false);
        return d;
    }

    /**
     * Ler um texto na janela
     *
     * @param texto String
     * @return String
     */
    public static String escrevaLeiaJanela(String texto) {
        return JOptionPane.showInputDialog(texto);
    }

    /**
     * Ler um texto na janela
     *
     * @param texto String
     * @return Integer
     */
    public static int escrevaLeiaIntegerJanela(String texto) {
        boolean executouComSucesso = false;
        int i = 0;
        String s;
        do {
            try {
                s = JOptionPane.showInputDialog(texto);
                i = Integer.parseInt(s);
                executouComSucesso = true;
            } catch (Exception e) {
                Alexa.escrevaJanela("\nDado invalido, favor informar novamente\n");
            }
        } while (executouComSucesso == false);
        return i;
    }
    
    /**
     * Ler um texto na janela
     *
     * @param texto String
     * @return Double
     */
    public static double escrevaLeiaDoubleJanela(String texto) {
        boolean executouComSucesso = false;
        double d = 0;
        String s;
        do {
            try {
                s = JOptionPane.showInputDialog(texto);
                d = Double.parseDouble(s);
                executouComSucesso = true;
            } catch (Exception e) {
                Alexa.escrevaJanela("\nDado invalido, favor informar novamente\n");
            }
        } while (executouComSucesso == false);
        return d;
    }

    /**
     * Escrever um texto na janela
     *
     * @param texto String
     */
    public static void escrevaJanela(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }
}
