/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coeficientebinomial;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class CoeficienteBinomial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        System.out.println("Coeficiente Binomial");
        System.out.println("Ingrese n: ");
        n = sc.nextInt();
        System.out.println("\nIngrese k: ");
        k = sc.nextInt();
        
        if(k > n)
            System.out.println("\nError: k mayor que n");
        else
            System.out.println("\nCoeficiente Binomial(n, k): " + coefBinomial(n,k));
    }
    
    public static int coefBinomial(int n, int k){
        int c[][] = new int[n+1][k+1];
        
        for(int i=0; i<=n; i++)
            c[i][0] = 1;
        
        for(int i=1; i<=n; i++)
            c[i][1] = i;
        
        for(int i=2; i<=k; i++)
            c[i][i] = 1;
        
        for(int i=3; i<=n; i++){
            for(int j=2; j<i; j++){
                if(j<=k)
                    c[i][j] = c[i-1][j-1] + c[i-1][j];
            }
        }
        
        return c[n][k];
    }
    
}
