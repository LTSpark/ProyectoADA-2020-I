package mochila01retroceso;


public class Objeto {
    private float peso;
    private float beneficio;


    public Objeto (){

    }
    public Objeto(float peso, float beneficio) {
        this.peso = peso;
        this.beneficio = beneficio;

    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(float beneficio) {
        this.beneficio = beneficio;
    }
    

    
}