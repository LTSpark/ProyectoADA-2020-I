
package Clases;

public class Empleado_Cortador extends Empleado{
    public Empleado_Cortador(String id, String nombre, String apellido){
        super(id,nombre,apellido);
    }
    
    
    public void RealizaAccion(){
        String idMaq = this.obtenerMaquina();
        MaquinaCortadora maqAux = new MaquinaCortadora(idMaq, "","");
        maqAux.Operacion();
    }
}
