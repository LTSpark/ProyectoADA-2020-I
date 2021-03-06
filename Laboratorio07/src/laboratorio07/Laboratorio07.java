/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio07;

import java.util.Scanner;

/**
 *
 * @author Edward
 */
public class Laboratorio07 {

    public static void main(String args[]) {
        menu();
    }

    public static void menu() {
        int opc;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("***** MENU PRINCIPAL *****");
            System.out.println("1) FACTORIAL RECURSIVO");
            System.out.println("2) MCD RECURSIVO");
            System.out.println("3) FIBONACCI RECURSIVO");
            System.out.println("4) TORRES DE HANOI");
            System.out.println("5) FINALIZAR EL PROGRAMA");
            System.out.print("Ingrese una opción: ");
            opc = entrada.nextInt();
            switch (opc) {
                case 1:
                    System.out.print("\nIngrese un número: ");
                    int n = entrada.nextInt();
                    Factorial fa = new Factorial();
                    System.out.println("Factorial Iterativo");
                    System.out.println(fa.factorialIterativo(n));
                    System.out.println("Factorial Recursivo");
                    System.out.println(fa.factorialRecursivo(n));
                    fa.mostrarContadores();
                    break;
                case 2:
                    System.out.print("\nIngrese su primer número: ");
                    int n1 = entrada.nextInt();
                    System.out.print("\nIngrese su segundo número: ");
                    int n2 = entrada.nextInt();
                    
                    MCD mcd = new MCD();
                    System.out.println("MCD Iterativo");
                    System.out.println(mcd.MCDIterativo(n1, n2));
                    System.out.println("MCD Recursivo");
                    System.out.println(mcd.MCDRecursivo(n1, n2));
                    mcd.mostrarContadores();

                    break;
                case 3:
                    System.out.print("\nIngrese la posición: ");
                    int numero = entrada.nextInt();
                    Fibonacci fibonacci = new Fibonacci();
                    System.out.println("Fibonacci Iterativo");
                    System.out.println(fibonacci.fibonacciIterativo(numero));
                    System.out.println("Fibonacci Recursivo");
                    System.out.println(fibonacci.fibonacciRecursivo(numero));
                    fibonacci.mostrarContadores();
                    break;
                case 4:
                    System.out.println("\nIngrese el numero de discos: ");
                    n = entrada.nextInt();
                    Hanoi hanoi = new Hanoi();
                    hanoi.torresHanoi(n, "Origen", "Destino", "Auxiliar");
                    System.out.println("\nEficiencia Recursiva: " + hanoi.getContadorRecursivo());
                    break;
                case 5:
                    System.out.println("FIN DEL PROGRAMA");
                    break;
                default:
                    System.out.println("Ingrese una opción correcta");
                    break;
            }
            System.out.println("");
        } while (opc != 5);
    }

}
