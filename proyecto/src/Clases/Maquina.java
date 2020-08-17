
package Clases;

public class Maquina {
    private String id;
    private String tipo;
    private String modelo;

    public void Operacion(){
    }
    
    public Maquina(String id, String tipo, String modelo){
        this.id=id;
        this.modelo=modelo;
        this.tipo=tipo;
    }
    
    //Getters y Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}
