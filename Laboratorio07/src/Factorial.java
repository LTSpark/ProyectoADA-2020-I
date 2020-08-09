
public class Factorial {

    double n;
    private int contadorIterativo=0;
    private int contadorRecursivo=0;

    Factorial(double n) {
        this.n=n;
    }

    public void mostrarContadores(){
        System.out.println("Eficiencia recursiva: "+contadorRecursivo);
        System.out.println("Eficiencia iterativa: "+contadorIterativo);
    }

    public double factorialRecursivo(double n){
        if(n==0){
            contadorRecursivo++;
            return 1;

        }
        else{
            contadorRecursivo++;
            return n*factorialRecursivo(n-1);
        }
    }

    public double factorialIterativo(){
        double resultado=1;

        while(n>1){
            resultado=resultado*n;
            n--;
            contadorIterativo++;
        }
        return resultado;

    }
}
