package Clases;

public class Empleado {
    private String id;
    private String nombre;
    private String apellido;

    public Empleado(String id, String nombre, String apellido){
        this.apellido = apellido;
        this.id = id;
        this.nombre = nombre;
    }
    
    public void RealizarAccion(){
        
    }
    
    public String obtenerMaquina(){
        String idMaquina = "";
        /*
            AGREGAR LÓGICA PARA OBTENER MÁQUINA
        */
        return idMaquina;
    }
    
    //Getters y Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
