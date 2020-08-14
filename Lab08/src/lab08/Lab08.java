
package lab08;

public class Lab08 {

    public static void main(String[] args) {
        MultiplicacionEficiente miMultiplicacion = new MultiplicacionEficiente();
        
        double mult = miMultiplicacion.multiplicar(991396593, 1257126412);
        System.out.printf("%.0f \n",mult);
    }
    
}
