
package main;

import java.util.Scanner;

public class AlgoritmoDeFloyd{

    public static void main (String []args){
        char opc;
        Scanner input = new Scanner(System.in);
        Floyd fl = new Floyd();
        int [][] respuestas;
        int[][] m = new int[4][4];
        m[0][0] = 0;
        m[0][1] = 5;
        m[0][2] = 10000;
        m[0][3] = 10000;
        m[1][0] = 50;
        m[1][1] = 0;
        m[1][2] = 15;
        m[1][3] = 5;
        m[2][0] = 30;
        m[2][1] = 10000;
        m[2][2] = 0;
        m[2][3] = 15;
        m[3][0] = 15;
        m[3][1] = 10000;
        m[3][2] = 5;
        m[3][3] = 0;
        respuestas=fl.Floyd(m);
        fl.mostrarMatriz(respuestas);

        do {
            System.out.println("\nRuta más corta de un vértice a otro (0 a 3)");
            System.out.print("Vértice inicial: ");
            int inicio = input.nextInt();

            System.out.print("Vértice final: ");
            int fin = input.nextInt();

            String respuesta = fl.caminoMasCorto(inicio, fin, respuestas);
            System.out.println(respuesta);
            int distancia = fl.distancia(inicio, fin, m);
            System.out.println("La distancia entre el nodo " + inicio + " y " + " el nodo " + fin + " es: " + distancia);

            System.out.println("\n¿Desea continuar? (Y/N)");
            opc=input.next().charAt(0);

        }while(opc!='N'&&opc!='n');

    }
}