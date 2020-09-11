
package mochila01retroceso;

import java.util.Scanner;

public class Mochila {
    
    private float cap;
    private float voa;
    private float pAct;
    private float bAct;
    private int nivel;
    private Objeto objeto[];
    private int[] soa;

    
    public Mochila (Objeto[] obj, float cap) {
        objeto = obj;
        this.cap = cap;
        
    }
    
    public void llenar() {
        Scanner entrada = new Scanner (System.in);
        for (int i = 0; i < objeto.length; i++) {
            System.out.print("\nPeso del objeto  " + (i + 1)+": ");
            float p = entrada.nextFloat();
            System.out.print("Beneficio del objeto " + (i + 1)+ ": ");
            float b = entrada.nextFloat();
            objeto[i] = new Objeto(p, b);
        }
    }
    
    public void mostrar() {
        String beneficio = "\nbeneficio:  ", peso = "peso: ";
        for (int i = 0; i < objeto.length; i++) {
            beneficio += objeto[i].getBeneficio() + "  ,  ";
            peso += objeto[i].getPeso() + " , ";
        }
        System.out.println(beneficio + "\n"+ peso + "\n");
    }
    
    
    
    public boolean solucion () { 
        if (objeto.length - 1 == nivel && pAct <= cap)
            return true;
        else
            return false;
    }
    
    public boolean criterio () {
        if (nivel < objeto.length-1 && pAct <= cap)
            return true;
        else 
            return false;
    }
    
    public boolean masHermanos (int s[]) {
        if (nivel >=0) {
            if (s[nivel] == 0)
                return true;
            else
                return false;
        }
        return true;
    }
    
    public void retroceder (int[] s) {
    
        pAct -= objeto[nivel].getPeso();
        bAct -= objeto[nivel].getBeneficio();
       
        s[nivel] = -1;
        nivel--;
    }
    
    public void generar (int[] s) {
        if (s[nivel] == -1)
            s[nivel] = 0;
        
        if(s[nivel] == 1) {
            pAct += objeto[nivel].getPeso();
            bAct += objeto[nivel].getBeneficio();
        }
    }
    
    public int[] mochila (int[] s) {
        pAct = 0;
        bAct = 0;
        nivel = 0;
        voa = -1;
        soa = new int[objeto.length];
        float peso = 0;
           
        while (nivel >= 0) {
            generar(s);
            
            if (solucion() && bAct > voa) {
                voa = bAct;
                
                peso = pAct;
                
                for (int i = 0; i < s.length; i++) {
                    soa[i] = s[i];
                }
            }
            
            if (criterio()) {
                nivel++;
            } else {
                while (nivel >= 0 && !masHermanos(s)) {
                    retroceder(s);
                }
                if (nivel >= 0) {
                    s[nivel]=1;
                }
            }    
        }
        System.out.println("\nBeneficio total: " + voa);
        System.out.println("Peso total: " + peso);
        return soa;
    }
}
