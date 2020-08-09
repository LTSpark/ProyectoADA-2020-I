import java.util.Scanner;

public class Laboratorio07 {
    public static void main (String args []){
        menu();
    }
    public static void menu (){

        int opc = 0;
        Scanner entrada = new Scanner(System.in);
        do{
            System.out.println("***** MENU PRINCIPAL *****");
            System.out.println("1) FACTORIAL RECURSIVO");
            System.out.println("2) MCD RECURSIVO");
            System.out.println("3) FIBONACCI RECURSIVO");
            System.out.println("4) TORRES DE HANOI");
            System.out.println("5) FINALIZAR EL PROGRAMA");
            System.out.println("Ingrese una opción: ");
            opc=entrada.nextInt();
            switch(opc){
                case 1:
                    System.out.println("Ingrese un número");
                    double n=entrada.nextInt();
                    Factorial fa= new Factorial(n);
                    System.out.println(fa.factorialIterativo());
                    System.out.println(fa.factorialRecursivo(n));
                    fa.mostrarContadores();
                    break;
                case 2:
                    //insertar metodos MCD
                    break;
                case 3:
                    //insertar metodos FIBONACCI
                    break;
                case 4:
                    //insertar metodos torres de hanoi
                    break;
                case 5:
                    System.out.println("FIN DEL PROGRAMA");
                    break;
                default:
                    System.out.println("Ingrese una opción correcta");
                    break;
            }
        }while(opc!=5);
    }
}
