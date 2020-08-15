package proyecto;

import java.util.Scanner;

public class Lote {
    private String material;
    private int cantidad;
    private Barra barras[] = new Barra[150];

    public Lote(int cantidad, String material){
        this.cantidad = cantidad;
        this.material = material;
        
        Scanner scan = new Scanner(System.in);
        double tam;
        for(int i=0; i<cantidad ; i++){
            System.out.print("longitud de barra "+(i+1)+": ");
            tam = scan.nextDouble();
            this.barras[i] = new Barra(tam, material);
        }
    }
    
    public Barra getBarra(int indice){
        return this.barras[indice];
    }
    
    public void setBarra(Barra barra, int indice){
        this.barras[indice] = barra;
    }
    
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
