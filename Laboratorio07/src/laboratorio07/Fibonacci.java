/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio07;

public class Fibonacci {

    private int contIterativo;
    private int contRecursivo;

    public Fibonacci() {
        this.contIterativo = 0;
        this.contRecursivo = 0;
    }

    public void mostrarContadores() {
        System.out.println("Eficiencia recursiva: " + contRecursivo);
        System.out.println("Eficiencia iterativa: " + contIterativo);
    }

    public int fibonacciRecursivo(int n) {
        if (n <= 1) {
            contRecursivo++;
            return n;
        } else {
            contRecursivo++;
            return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
        }
    }

    public int fibonacciIterativo(int n) {
        int siguiente = 1, actual = 0, temporal = 0;
        for (int i = 1; i <= n; i++) {
            temporal = actual;
            actual = siguiente;
            siguiente = siguiente + temporal;
            contIterativo++;
        }
        return actual;
    }
}
