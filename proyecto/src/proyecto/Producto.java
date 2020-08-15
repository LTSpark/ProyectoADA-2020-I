
package proyecto;


public class Producto {
    private double tamaño;
    private String material;
    private String nombre;
    
    public Producto(double tamaño, String material, String nombre){
        this.material = material;
        this.nombre = nombre;
        this.tamaño = tamaño;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
