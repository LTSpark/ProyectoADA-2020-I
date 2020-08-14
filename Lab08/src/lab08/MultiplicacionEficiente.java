
package lab08;
import java.math.*;

public class MultiplicacionEficiente {

    public int tamaño(int num){
        int cant=0;
        while(num>0){
            num=num/10;
            cant++;
        }
        return cant;
    }
    
    public double multiplicar(int f1, int f2){
        int n;
        if(tamaño(f1)>tamaño(f2)){
            n=tamaño(f1);
        }
        else{
            n=tamaño(f2);
        }
        
        if(n<3){
            return f1*f2;
        }
        else{
            int s  = n/2;
            int xi = f1/(int)Math.pow(10,s);
            int xd = f1%(int)Math.pow(10,s);
            int yi = f2/(int)Math.pow(10,s);
            int yd = f2%(int)Math.pow(10,s);
            
            double p = multiplicar(xi,yi);
            double r = multiplicar(xi+xd,yi+yd);
            double q = multiplicar(xi,yd);
            
            return p*(Math.pow(10, 2*s)) + r*(Math.pow(10, s)) + q;
        }
    }
    
}
