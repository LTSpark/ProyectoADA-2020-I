
package mochila01retroceso;

import java.util.Scanner;

public class Mochila01Retroceso {
    
    
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingrese el numero de objetos que existen: ");
        int n = entrada.nextInt();
        System.out.print("Ingrese la capacidad de la mochila: ");
        float capacidad = entrada.nextFloat();
        
        Objeto objetos[] = new Objeto[n];
        int[] s = new int[n];
        int[] solucion;
        
        for (int i = 0; i < s.length; i++) {
            s[i] = -1;
        }
        
        Mochila mochila = new Mochila(objetos, capacidad);
        
        mochila.llenar();
        //mochila.mostrar();
        
        solucion = mochila.mochila(s);
        
        System.out.print("\nLa solución es: ");
        
        for (int i = 0; i < solucion.length; i++) {
            System.out.print(solucion[i] + " ");
        }
        
    }
    
    
    
}
