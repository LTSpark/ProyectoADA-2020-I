/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mochila;

import java.util.Scanner;

/**
 *
 * @author Edward
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Numero total de objetos: ");
        int obj = entrada.nextInt();
        int peso[] = new int[obj];
        int valor[] = new int[obj];
        for (int i = 0; i < obj; i++) {
           System.out.println("----------------------------------------");
           System.out.println("Objeto "+(i+1));
           System.out.println("--------");
           System.out.print("Ingrese el peso del objeto "+(i+1)+": ");
           peso[i] = entrada.nextInt();
           System.out.print("Ingrese el valor del objeto "+(i+1)+": ");
           valor[i] = entrada.nextInt();
        }
        System.out.println("----------------------------------------");
        System.out.print("Ingrese la capacidad de la mochila: ");
        int capacidad = entrada.nextInt();
        
        int valorMaximo; 
        

        Mochila miMochila = new Mochila(peso, valor, capacidad);

        valorMaximo = miMochila.elegirObjetos();
        System.out.printf("Valor máximo total = %d\n\n", valorMaximo);
        System.out.printf("Tabla de valores máximos\n");
        System.out.printf("------------------------\n");
        System.out.printf("\t |");
        for (int j = 1; j <= capacidad; j++) {
            System.out.printf("\t%d", j);
        }
        System.out.println();
        for (int j = 1; j <= capacidad; j++) {
            System.out.print("-----");
        }
        System.out.println();
        for (int i = 1; i <= obj; i++) {
            System.out.printf("\t%d|", i);
            for (int j = 1; j <= capacidad; j++) {
                System.out.printf("\t%d", miMochila.getV(i, j));
            }
            System.out.println();
        }

        miMochila.Componer();
        System.out.printf("\nObjetos elegidos\n");
        System.out.printf("----------------\n\n");
        for (int i = 1; i <= obj; i++) {
            if (miMochila.getElegido(i) == 1) {
                System.out.printf("Objeto %d: \tPeso = %d,"+ "Valor =  % d\n\n", i, miMochila.getPeso(i), miMochila.getValor(i));
            }

        }

    }

}
