package laboratorio08;

public class MergeSort {

    void fusionar(int arreglo[], int inicio, int mitad, int fin) {

        int n1 = mitad - inicio + 1;
        int n2 = fin - mitad;

        int I[] = new int[n1];
        int D[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            I[i] = arreglo[inicio + i];
        }
        for (int j = 0; j < n2; ++j) {
            D[j] = arreglo[mitad + 1 + j];
        }

        int i = 0, j = 0;

        int k = inicio;
        while (i < n1 && j < n2) {
            if (I[i] <= D[j]) {
                arreglo[k] = I[i];
                i++;
            } else {
                arreglo[k] = D[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arreglo[k] = I[i];
            i++;
            k++;
        }
        while (j < n2) {
            arreglo[k] = D[j];
            j++;
            k++;
        }
    }

    void mergeSort(int arreglo[], int inicio, int fin) {
        if (inicio < fin) {
            int mitad = (inicio + fin) / 2;
            mergeSort(arreglo, inicio, mitad);
            mergeSort(arreglo, mitad + 1, fin);
            fusionar(arreglo, inicio, mitad, fin);
        }
    }
}
