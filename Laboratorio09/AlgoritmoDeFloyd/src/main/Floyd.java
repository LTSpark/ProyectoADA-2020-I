package main;
public class Floyd {

    public int [][]Floyd(int [][] longitudes ){
        int n = longitudes.length;
        int camino[][] = new int [n][n];
        int distancias[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                distancias[i][j]=longitudes[i][j];
                camino[i][j]=0;
            }
        }
        for(int k=0;k<n;k++){
            for(int j=0;j<n;j++){
                for(int i=0;i<n;i++){
                    if((distancias[i][k] + distancias[k][j])<distancias[i][j]){
                        distancias[i][j]=distancias[i][k]+distancias[k][j];
                        camino[i][j]=k;
                    }
                }
            }
        }
        return camino;
    }

    public int [][]Floyd2(int [][] longitudes ){
        int n = longitudes.length;
        int distancias[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                distancias[i][j]=longitudes[i][j];
            }
        }
        for(int k=0;k<n;k++){
            for(int j=0;j<n;j++){
                for(int i=0;i<n;i++){
                    if((distancias[i][k] + distancias[k][j])<distancias[i][j]){
                        distancias[i][j]=distancias[i][k]+distancias[k][j];
                    }
                }
            }
        }
        return distancias;
    }

    
    public void mostrarMatriz(int matriz [][]){
        int n=matriz.length;
        System.out.println("    0 1 2 3");
        System.out.println("    -------");
        for(int i=0;i<n;i++){
            System.out.print(i + " | ");
            for(int j=0;j<n;j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }

    public String caminoMasCorto(int a, int b, int camino [][]){
        String respuesta = (b)+ "";

        while(camino[a][b]!=a ){
            if(camino[a][b]==0){
                break;
            }
            respuesta=(camino[a][b])+" -> "+respuesta;
            b=camino[a][b];
        }
        respuesta="La ruta más corta es: "+(a)+" -> "+respuesta;
        return respuesta;
    }
    public int distancia (int a, int b, int [][] longitudes){
        int n =  longitudes.length;
        int distancias[][];
        distancias=Floyd2(longitudes);
        int distancia=0;
        distancia=distancias[a][b];

        return distancia;
    }


}
