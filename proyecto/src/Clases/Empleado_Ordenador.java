
package Clases;

public class Empleado_Ordenador extends Empleado{
    public Empleado_Ordenador(String id, String nombre, String apellido){
        super(id,nombre,apellido);
    }
    
    public void RealizaAccion(){
        String idMaq = this.obtenerMaquina();
        MaquinaOrdenadora maqAux = new MaquinaOrdenadora(idMaq, "","");
        maqAux.Operacion();
    }
}
