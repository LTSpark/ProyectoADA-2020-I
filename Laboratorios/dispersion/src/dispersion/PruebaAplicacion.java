
package dispersion1;

import java.util.Scanner;


public class PruebaAplicacion {
    public static void main(String[] args) {
        Instituto miInstituto = new Instituto();
    String codigo[] = {"100820", "100120", "200110", "204530", "100150",
        "100012", "100213", "100250", "100540", "100420"};
    String nombre[] = {"Juan Rosales", "Ana Ramirez", "Rosa Huapaya",
        "Carlos Arana", "Raul Gonzales", "Pedro Mamani",
        "Rosario Paredes", "Martha Huaman", "Saul Espino",
        "Karen Mendiola"};
    float pension[] = {320, 400, 300, 400, 350, 320, 450, 320, 450, 300};
    Scanner entrada = new Scanner (System.in);
    int pos;
    
    String cod;
    int pen;
    String name;
    boolean exito;
    
    int opc;
    boolean flag;
    
    for (int i = 0; i < codigo.length; i++)
    {
        flag = miInstituto.Insertar(codigo[i],nombre[i],pension[i]);
        if (flag==false) System.out.println("Tabla llena");
    }
    
    do{
        System.out.println("-------------------------------------");
        for (int i = 0; i < miInstituto.getNumeroDeAlumnos(); i++)
        {
            System.out.printf("%s\t%20s%10.2f\n",
            miInstituto.getCodigoDelAlumno(i),
            miInstituto.getNombreDelAlumno(i),
            miInstituto.getPensionDelAlumno(i));
            //miInstituto.mostrarEncadenadas(i);
        }
        System.out.println("-------------------------------------");

        System.out.println("\n\nIngrese opción: ");
        System.out.println(" 1) Insertar ");
        System.out.println(" 2) Buscar ");
        System.out.println(" 3) Eliminar ");
        System.out.println(" 4) Eliminar por asignación lineal");
        System.out.println("Ingrese 0 para cerrar el programa");
        opc = entrada.nextInt();
        
        switch(opc){
        
            case 1:
                System.out.print("\n\nIngrese codigo: ");
                cod=entrada.nextLine();
                System.out.print("Ingrese nombre: ");
                entrada.nextLine();
                name=entrada.nextLine();
                System.out.print("Ingrese pension: ");
                pen=entrada.nextInt();
                System.out.println();
                
                exito = miInstituto.InsertarDDireccion(cod, name, pen);
                //exito = miInstituto.InsertarEncadenamiento(cod, name, pen);
                
                if(exito){
                    System.out.println("Insertado con éxito");
                }
                else{
                    System.out.println("No se pudo insertar");
                }
                System.out.println();
                break;
            case 2:
                System.out.print("\n\nIngrese codigo: ");
                cod=entrada.nextLine();
                
                //pos = miInstituto.BuscarDDireccion(cod);
                pos = miInstituto.BuscarEncadenamiento(cod);

                if (pos != -1 )
                {
                    System.out.println("¡Encontrado!");
                    System.out.printf("\n%s\t%20s%10.2f\n\n",
                    miInstituto.getCodigoDelAlumno(pos),
                    miInstituto.getNombreDelAlumno(pos),
                    miInstituto.getPensionDelAlumno(pos));

                }
                else
                    System.out.println("\n\nCodigo de alumno no existe"); 
                break;
            case 3:
                System.out.print("\n\nIngrese codigo: ");
                cod=entrada.nextLine();
                
                exito = miInstituto.EliminarDDireccion(cod);
                //exito = miInstituto.EliminarEncadenamiento(cod);
                
                if (exito)
                {
                    System.out.println("\n\nEliminado correctamente"); 
                }
                else
                    System.out.println("\n\nCodigo de alumno no existe");                 
                break;
            case 4:
                System.out.print("\n\nIngrese codigo: ");
                cod=entrada.nextLine();

                exito = miInstituto.EliminarLineal(cod);
                if (exito)
                {
                    System.out.println("\n\nEliminado correctamente");
                }
                else
                    System.out.println("\n\nCodigo de alumno no existe");
                break;
            default:
                opc = 0;
        }
    }
    while(opc != 0);
    }
        
    }
    
}
