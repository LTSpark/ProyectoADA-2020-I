package laboratorio10;

public class Asignacion {

    int tarifas[][] = {{1, 3, 9}, 
                       {6, 4, 8}, 
                       {15, 3, 18}};
    
    int x[] = new int[tarifas[0].length];
    int mejor[] = new int[tarifas[0].length];
    int minimo = 9999;

    public void asignacion(int k) {
        int c;
        x[k] = 0;
        do {
            x[k]++;
            if (aceptable(k)) {
                if (k < tarifas[0].length) {
                    if(k != tarifas[0].length-1){
                        asignacion(k + 1);
                    }else{
                        c = coste();
                        if(minimo > c){
                            mejor = x;
                            minimo = c;
                        }
                    }
                }
            }

        } while (x[k] == tarifas[0].length);

    }

    public boolean aceptable(int k) {
        for (int i = 0; i < k - 1; i++) {
            if (x[k] == x[i]) {
                return false;
            }
        }
        return true;
    }

    public int coste() {
        int suma = 0;
        for (int i = 0; i < tarifas[0].length; i++) {
            suma += tarifas[i][x[i]];
        }
        return suma;
    }

}
