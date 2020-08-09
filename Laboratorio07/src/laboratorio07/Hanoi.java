/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio07;

/**
 *
 * @author Edward
 */
public class Hanoi {
    private int contadorRecursivo;
    
    public Hanoi(){
        this.contadorRecursivo = 0;
    }
    
     public void torresHanoi(int nDiscos, String origen, String destino, String auxiliar){
        if(nDiscos == 1){
            System.out.println("\nMover disco de " + origen + " a " + destino);
            this.setContadorRecursivo(this.getContadorRecursivo() + 1);
        }
            
        else{
            torresHanoi(nDiscos - 1, origen, auxiliar, destino);
            System.out.println("\nMover disco de " + origen + " a " + destino);
            torresHanoi(nDiscos - 1, auxiliar, destino, origen);
            this.setContadorRecursivo(this.getContadorRecursivo() + 1);
        }
    }

    /**
     * @return the contadorRecursivo
     */
    public int getContadorRecursivo() {
        return contadorRecursivo;
    }

    /**
     * @param contadorRecursivo the contadorRecursivo to set
     */
    public void setContadorRecursivo(int contadorRecursivo) {
        this.contadorRecursivo = contadorRecursivo;
    }
}
