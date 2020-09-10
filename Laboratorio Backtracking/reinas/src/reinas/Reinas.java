package reinas;
import java.util.Scanner;
public class Reinas {

    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);
        int n;
        System.out.print("Ingrese el tamaño del tablero: ");
        n = entry.nextInt();
        tablero t1 = new tablero(n);
        t1.reinas(0,0);
    }
    
}