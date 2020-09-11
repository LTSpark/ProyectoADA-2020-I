
package laboratorio10;

public class Laboratorio10 {


    public static void main(String[] args) {
        Asignacion asignar = new Asignacion();
        asignar.asignacion(1);
        for (int i = 0; i < asignar.tarifas[0].length; i++) {
            System.out.println("A la persona "+(i+1)+" se le asigna la tarea "+ i +"\n tiene un costo de: "+asignar.tarifas[i][asignar.mejor[i]]+" horas");
        }
        System.out.println("Costo total de horas sería: "+asignar.minimo+" horas");
    }
    
    
}
