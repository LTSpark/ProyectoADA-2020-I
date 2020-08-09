/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio07;

/**
 *
 * @author Edward
 */
public class MCD {
    private int contIterativo;
    private int contRecursivo;

    public MCD() {
        this.contIterativo = 0;
        this.contRecursivo = 0;
    }

    public void mostrarContadores() {
        System.out.println("Eficiencia recursiva: " + contRecursivo);
        System.out.println("Eficiencia iterativa: " + contIterativo);
    }
    
    public int MCDRecursivo(int n, int m) {
        int mcd = 0;
        if (m == n) {
            mcd = n;
            contRecursivo++;
        } else if (n > m) {
            mcd = MCDRecursivo(n - m, m);
            contRecursivo++;            
        } else {
            mcd = MCDRecursivo(n, m - n);
            contRecursivo++;
        }
        return mcd;
     }
    
    public int MCDIterativo(int n, int m) {
        int mcd = 0, resto = 0; 
        do {
            resto = m % n;
            m = n;
            n = resto;
            contIterativo++;
        } while (resto != 0);
        mcd = m;
        return mcd;
    }
    
}