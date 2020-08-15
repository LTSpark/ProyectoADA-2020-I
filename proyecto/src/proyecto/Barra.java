
package proyecto;

public class Barra {
    private String material;
    private double longitud;

    public Barra(double longitud, String material){
        this.longitud = longitud;
        this.material = material;
    }
    
    //Getters y Setters
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public double getLongitud() {
        return longitud;
    }
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    
    
}
