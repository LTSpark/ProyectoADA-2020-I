
package Clases;

import java.util.Scanner;
public class Proyecto {

    public static void main(String[] args) {
        
        Scanner entry = new Scanner(System.in);
        //double tProd = 0;
        double tBarr = 0;
        int cantLote;
        MaquinaCortadora maqCor = new MaquinaCortadora("C5431","tipo","modelo");
        MaquinaOrdenadora maqOrd = new MaquinaOrdenadora("O5431", "tipo", "modelo");
        
        System.out.print("Barras del lote: ");
        cantLote = entry.nextInt();
        
        Lote l = new Lote(cantLote, "");
        Barra b; 
        
        System.out.println("------------------------------");
        
        //Mostrar lote
        cantLote = l.getCantidad();
        for(int i=0 ; i<cantLote ; i++){
            tBarr = l.getBarra(i).getLongitud();
            System.out.printf("Barra %d : Longitud: %f\n", (i+1), tBarr);
        }
        
        System.out.println("------------------------------");
        
        //Ordenar
        maqOrd.Operacion(l, 0, cantLote-1);
        
        //Mostrar lote
        cantLote = l.getCantidad();
        for(int i=0 ; i<cantLote ; i++){
            tBarr = l.getBarra(i).getLongitud();
            System.out.printf("Barra %d : Longitud: %f\n", (i+1), tBarr);
        }
        
        System.out.println("------------------------------");
        
        /* CORTAR UNA BARRA
        System.out.print("Tamaño de producto: ");
        tProd = entry.nextDouble();
        
        if(tProd == 0){
            System.out.println("Tamaño no permitido");
        }
        else{
            System.out.print("Tamaño de barra: ");
            tBarr = entry.nextDouble();

            Producto p = new Producto(tProd, "hierro", "columna");
            
            Barra b = new Barra(tBarr,"hierro");

            maqCor.Operacion(b, p);        
        }*/
    }
    
}
