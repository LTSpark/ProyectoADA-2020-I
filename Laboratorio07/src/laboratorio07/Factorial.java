/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio07;


public class Factorial {

    private int contadorIterativo;
    private int contadorRecursivo;

    Factorial() {
        this.contadorIterativo = 0;
        this.contadorRecursivo = 0;
    }

    public void mostrarContadores(){
        System.out.println("Eficiencia recursiva: "+contadorRecursivo);
        System.out.println("Eficiencia iterativa: "+contadorIterativo);
    }

    public int factorialRecursivo(int n){
        if(n==0){
            contadorRecursivo++;
            return 1;

        }
        else{
            contadorRecursivo++;
            return n*factorialRecursivo(n-1);
        }
    }

    public int factorialIterativo(int n){
        int resultado=1;
        while(n>1){
            resultado=resultado*n;
            n--;
            contadorIterativo++;
        }
        return resultado;

    }
}

