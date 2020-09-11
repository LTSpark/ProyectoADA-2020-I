
package bactracking;

public class PruebaBacktracking {
    public static void main(String[] args) {
        int valores[] = { 3, 4, 7, 2, 5};
        int suma = 185;
        Backtracking sumaDada = new Backtracking(valores, suma);
        sumaDada.hallarSubconjunto();
        sumaDada.mostrarSolucion();
        
    }
    
}
