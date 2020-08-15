package proyecto;


public class MaquinaCortadora extends Maquina{
    public MaquinaCortadora(String id, String tipo, String modelo){
        super(id,tipo,modelo);
    }
    
    public double redondear(double num, int pot){
        return (double)Math.round(num * Math.pow(10,pot)) / Math.pow(10,pot);
    }
    
    public void Operacion(Barra b, Producto p){           
        
        double tamTotal = b.getLongitud();
        double k = p.getTamaño();
        
        int cortes = 0;
        int Poten10 = 3;
        
        //Remover el exceso que podría haber
        tamTotal = tamTotal * Math.pow(10,Poten10);
        k = k * Math.pow(10,Poten10);
        
            double residuo = tamTotal % k;
            residuo = redondear(residuo, Poten10);
            residuo = residuo/Math.pow(10,Poten10);
            
        tamTotal = tamTotal / Math.pow(10,Poten10);
        k = k / Math.pow(10,Poten10);          
        
        if( residuo!=0 ){
            tamTotal = tamTotal - residuo;
            System.out.println("Se desechará un residuo de " + residuo);
            cortes++; // corte para sacar el residuo
        }

        int partes = (int)(tamTotal/k); // partes en las que se puede dividir la barra
        
        //Si la barra es muy pequeña (menor que k)
        if(partes == 0){
            System.out.println("La barra introducida es de un tamaño menor al "
                    + "requerrido, se ha desechado completamente");
            cortes=0;
        }else{//Si no, aplicar algoritmo
            
            int numBarras = 1;// al inicio es una sola barra
            
            double tamBarras[] = new double[partes];
            tamBarras[0] = redondear(tamTotal,Poten10);            
            for (int i = 1; i < partes; i++) {
                tamBarras[i] = 0;
            }

            int barrasEnFila;//(alineadas para cortar)
            int barrasOK = 0;// llegaron al valor de k
            
            while(barrasOK != partes){ //Mientras no se hayan cortado todas las partes     
                barrasEnFila = 0;
                barrasOK = 0;
                
                for(int i=0;i<numBarras;i++){
                    System.out.println("Barra " + (i+1) + 
                            " de tamaño " + tamBarras[i]);
                    
                    if(tamBarras[i] != k){
                        barrasEnFila++;
                    }else{
                        barrasOK++;
                    }
                }
                
                //Realizar corte
                if(barrasEnFila >0){
                    System.out.println("Cortando " +barrasEnFila+ " barra(s) en fila");

                double aux;
                double value;
                    
                for(int i=0;i<barrasEnFila;i++){
                    aux = tamBarras[i];
                    
                    value = (int)(tamBarras[i]/k) / 2 * k;
                    value = redondear(value,Poten10); 
                    tamBarras[numBarras + i] = value;
                    
                    value = aux-tamBarras[numBarras + i];
                    value = redondear(value,Poten10); 
                    tamBarras[i] = value;
                }               
                    //aumenta el número de barras
                    cortes++;
                    numBarras = barrasEnFila*2 + barrasOK;
                }
            }
        }
        System.out.println("-------------------");
            System.out.println("Número de cortes: " + cortes );
            System.out.println("Número de partes obtenidas: " + partes );
    }   
    
    public void Operacion(Lote l, Producto p){
        //Cortar lote
        int n = l.getCantidad();
        for (int i = 0; i < n; i++) {
            System.out.println("Cortando barra " + (i+1)+"\n");
            //Cortar barra
            Operacion(l.getBarra(i), p);
            
            System.out.println("-----------------------------");
        }
        
    }
    
}
