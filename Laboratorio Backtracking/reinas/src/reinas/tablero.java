package reinas;

public class tablero {
    int n;
    int cont;
    int arreglo[];
    int matriz[][];
    int k;//número de filas llena (nivel)
    
    public tablero(int n){
        this.n=n;
        this.k = 0;
        this.cont=1;
        arreglo = new int[n];
        for (int i = 0; i < n; i++) {
            arreglo[i] = -1;
        }
    }
    
    public boolean verificar(int fila, int columna){
        boolean check = true;
        
        //misma columna
        for (int i = 0; i < n; i++) {
            if(arreglo[i] != -1){
                if(arreglo[i]==columna){
                    check = false;
                }
            }
        }
        
        //misma diagonal
        for (int i = 0; i < n; i++) {
            if(arreglo[i] != -1){
                if(Math.abs(i-fila) == Math.abs(arreglo[i] - columna)){
                    check = false;
                }
            }
        }
        
        return check;
    }
    
    public void reinas(int k, int indice){
        //k=0 columna
        //indice=0
        
        boolean valido;
        
        //System.out.println("("+k+", "+indice+")");
        
        while(indice < n && k<= n && indice >= 0 && k >= 0){
            valido = verificar(indice,k) && k!=n;
            if(valido){
                //System.out.println("valido! indice:" + indice + "  k: " +k);
                arreglo[indice] = k;
                indice++;
                k=0;
            }else{
                k++;
                if(k>=n){
                    //System.out.println("retroceso! indice:" + indice + "  k: " +k);
                    arreglo[indice]=-1;
                    indice--;
                    if(indice >= 0){
                        k=arreglo[indice]+1;
                        arreglo[indice]=-1;
                    }
                }
            }
        }
        
        if(indice==n){
            //System.out.println("Exito!");
            System.out.print(cont+") ");
            cont++;
            for (int i = 0; i < n; i++) {
                System.out.print(arreglo[i]+", ");
            }      
            System.out.println();
            k = arreglo[indice-1];
            //System.out.println("k: "+k);
            //System.out.println();            
        }

        if(k<n){
            reinas(k+1,indice-1);
        }
    }
    
}
