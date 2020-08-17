
package Clases;

public class MaquinaOrdenadora extends Maquina{
    public MaquinaOrdenadora(String id, String tipo, String modelo){
        super(id,tipo,modelo);
    }
    
    public void intercambio(Lote l, int ind1, int ind2){
        Barra aux = l.getBarra(ind1);
        l.setBarra(l.getBarra(ind2), ind1);
        l.setBarra(aux, ind2);
    }
    
    public void Operacion(Lote l, int ini, int fin){
        int izq = ini;
        int der = fin;
        int pos = ini;
        boolean flag = true;
        
        while(flag){
            flag = false;
            while(l.getBarra(pos).getLongitud() <= l.getBarra(der).getLongitud() && pos != der){
                der = der - 1 ;
            }
            if(pos != der ){
                intercambio(l,pos,der);
                pos = der;
                while(l.getBarra(pos).getLongitud() >= l.getBarra(izq).getLongitud() && pos != izq){
                    izq = izq + 1 ;
                }
                
                if(pos!=izq){
                    intercambio(l,pos,izq);
                    pos = izq;
                    flag = true;
                }
            }
        }
        
        if(pos - 1 > ini){
            Operacion(l,ini,pos-1);
        }
        if(fin > pos + 1){
            Operacion(l, pos + 1, fin);
        }
    }
    
}
