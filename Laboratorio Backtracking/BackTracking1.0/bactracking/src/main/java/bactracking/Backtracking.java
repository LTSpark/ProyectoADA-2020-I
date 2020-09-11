
package bactracking;

import javax.swing.JOptionPane;

public class Backtracking {
    private int s[][];
    private int v[];
    private int tact;
    private int p;
    private int Solucion;
    private int numSubSets;

    public Backtracking(int valores[], int suma) {
        v = new int[valores.length];
        numSubSets = (new Double(Math.pow(2, valores.length))).intValue();
        s = new int[numSubSets][valores.length];
        v = valores;
        tact = 0;
        p = suma;
        Solucion= 0;
    }

    public void hallarSubconjunto() {

        int nivel = 0;

        // Inicializa arreglo solucion s
        for (int i = 0; i < numSubSets; i++) {
            for (int j = 0; j < s[i].length; j++)
                s[i][j] = -1;
        }

        printS();
        do {
            generar(nivel);
            printS();
            if (solucion(nivel, p)) {
                Solucion++;
                System.arraycopy(s[Solucion-1], 0, s[Solucion], 0, s[0].length);
            } 
            if (criterio(nivel, p))
                nivel++;
            else
                while (!masHermanos(nivel)) {
                    nivel = retroceder(nivel);
                    if (nivel < 0) {
                        return;
                    }
                }
        } while (true);
    }

    public void printS() {
        for (int i : s[Solucion]) {
            if (i == -1)
                return;
        }

        System.out.print("{ ");
        for (int i : s[Solucion]) {
            System.out.printf("%3d", i);
        }
        System.out.println(" }");

    }

    public void generar(int nivel) {
        s[Solucion ][nivel] = s[Solucion][nivel] + 1;
        if (s[Solucion][nivel] == 1)
            tact = tact + v[nivel];
    }

    public boolean solucion(int nivel, int p) {
        int n = s[0].length;
        return (nivel == n - 1 && tact == p);
    }

    public boolean criterio(int nivel, int p) {
        int n = s[0].length;
        return (nivel < n - 1 && tact <= p);
    }

    public boolean masHermanos(int nivel) {
        return (s[Solucion][nivel] < 1);
    }

    public int retroceder(int nivel) {
        tact -= v[nivel] * s[Solucion][nivel];
        s[Solucion][nivel] = -1;
        nivel--;
        return nivel;
    }

    public void mostrarSolucion() {
        String mensaje = "";
        mensaje = "Valores:\n {";
        for (int i = 0; i < v.length; i++) {
            mensaje += v[i];
            if (i < v.length - 1)
                mensaje += ", ";
            else
                mensaje += "}";
        }
        mensaje += "\n\nSoluciones Backtracking:\n";
        mensaje += "\n\nSuma buscada: " + p + "\n";
        mensaje += "Soluciones encontradas: " + Solucion + "\n";

        if (Solucion > 0) {
            for (int i = 0; i < Solucion; i++) {
                mensaje += "{ ";
                for (int j=0; j<s[0].length; j++){
                    mensaje += s[i][j];
                    if (j < s[0].length - 1)
                        mensaje += ", ";
                    else
                        mensaje += " }";
                }
                mensaje += "\n";
            }
            mensaje += "\n\nSubconjunto cuya suma es " + p + ":\n";
            for (int j = 0; j < Solucion; j++) {
                mensaje += "{ ";
                boolean primeroAgnadido = false; // para controlar si se añade o no la coma
                for (int i = 0; i < s[0].length; i++) {
                    if (s[j][i] == 1) {
                        if (primeroAgnadido)
                            mensaje += ", ";
                        mensaje += v[i];
                        primeroAgnadido = true;
                    }
                }
                mensaje += " }\n";
            }

        } else {
            mensaje += "\t\t No existe solucion";
        }

        JOptionPane.showMessageDialog(null, mensaje, "Algoritmos de retroceso (Backtracking)",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
}
