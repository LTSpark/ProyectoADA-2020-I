package laboratorio06;

import java.util.Scanner;

public class Laboratorio06 {

    public static void main(String[] args) {
        Instituto miInstituto = new Instituto();
        String codigo[] = {"100820", "100120", "200110", "204530", "100150",
            "100012", "100213", "100250", "100540", "100420"};
        String nombre[] = {"Juan Rosales", "Ana Ramirez", "Rosa Huapaya",
            "Carlos Arana", "Raul Gonzales", "Pedro Mamani",
            "Rosario Paredes", "Martha Huaman", "Saul Espino",
            "Karen Mendiola"};

        float pension[] = {320, 400, 300, 400, 350, 320, 450, 320, 450, 300};
        Scanner entrada = new Scanner(System.in);
        int pos;
        String cod;
        boolean flag, bandera;

        //------------LLenar la matriz-----------------------------
        for (int i = 0; i < codigo.length; i++) {
            flag = miInstituto.insertarArreglo(codigo[i], nombre[i], pension[i]);
            if (flag == false) {
                System.out.println("Tabla llena");
            }
        }

        //------------------------Muestra la matriz en pantalla-----------------------
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Mostrando elementos ingresados ");
        System.out.println("----------------------------------------------------------------------------------");
        for (int i = 0; i < miInstituto.getNumeroDeAlumnos(); i++) {
            for (int j = 0; j < miInstituto.getNumeroDeAlumnos(); j++) {
                System.out.printf("%s\t%20s%10.2f\t\t",
                        miInstituto.getCodigoDelAlu(i, j),
                        miInstituto.getNombreDelAlu(i, j),
                        miInstituto.getPensionDelAlu(i, j));

            }
            System.out.println("");
        }

        //-------------buscarArreglo alumno por código--------------------
        System.out.println("\n\n----------------------------------------------------------------------------------");
        System.out.println("Buscar un alumno ");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.print("Codigo del alumno: ");
        cod = entrada.next();
        //Almaceno el valor del iterador de mi funcion buscar en una variable "pos"
        pos = miInstituto.buscarArreglo(cod);

        //Si el valor de pos es diferente de -1, lo muestra
        if (pos != -1) {
            /*El primero parámetro es el indice de la columna vetical,llamo a la 
            funcion hash para que siempre me retorne columna vertical de indices
            como segundo parámetro utilizo la variable "pos",que contiene al 
            iterador que usé en mi funcion buscar, este controlará las colisiones*/
            miInstituto.mostrarArreglo(miInstituto.hash(miInstituto.convInt(cod)), pos);
        } else {
            System.out.println("\n\nCodigo de alumno no existe");
        }

        //-----------------eliminar un elemento----------------------------
        System.out.println("\n\n----------------------------------------------------------------------------------");
        System.out.println("Eliminar un elemento ");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.print("Codigo del alumno: ");
        String borrar = entrada.next();
        bandera = miInstituto.eliminarArreglo(borrar);
        if (bandera) {
            System.out.println("Elemento eliminado");
            
            //Mostrando matriz despues de haber eliminado
            
            System.out.println("\n\n----------------------------------------------------------------------------------");
            System.out.println("Mostrando elementos despues de la eliminacion");
            System.out.println("----------------------------------------------------------------------------------");
            for (int i = 0; i < miInstituto.getNumeroDeAlumnos(); i++) {
                for (int j = 0; j < miInstituto.getNumeroDeAlumnos(); j++) {
                    System.out.printf("%s\t%20s%10.2f\t\t",
                            miInstituto.getCodigoDelAlu(i, j),
                            miInstituto.getNombreDelAlu(i, j),
                            miInstituto.getPensionDelAlu(i, j));

                }
                System.out.println("");
            }
        } else {
            System.out.println("Elemento no se existe!");
        }

    }
}
