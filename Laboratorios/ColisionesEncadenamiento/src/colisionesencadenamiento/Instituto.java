package colisionesencadenamiento;

import java.util.LinkedList;

public class Instituto {
    private Alumno alumnos[];
    private final int TAM_TABLA = 20;
    private LinkedList<Alumno>[] listaColisiones;
    public Instituto()
    {

        alumnos = new Alumno[TAM_TABLA];
        
        listaColisiones = new LinkedList[TAM_TABLA];
        
        for (int i=0; i<TAM_TABLA; i++)
        {
            alumnos[i] = new Alumno("","",0);
        }
    }
    public void setCodigoDelAlumno (String codigo, int i)
    {
        alumnos[i].setCodigoDelAlumno(codigo);
    }
    public String getCodigoDelAlumno (int i)
    {
        return alumnos[i].getCodigoDelAlumno();
    }
    public void setNombreDelAlumno (String nombre, int i)
    {
        alumnos[i].setNombreDelAlumno(nombre);
    }
    public String getNombreDelAlumno (int i)
    {
        return alumnos[i].getNombreDelAlumno();
    }
    public void setPensionDelAlumno (float pension, int i)
    {
        alumnos[i].setPensionDelAlumno(pension);
    }
    public float getPensionDelAlumno (int i)
    {
        return alumnos[i].getPensionDelAlumno();
    }
    public int getNumeroDeAlumnos()
    {
        return TAM_TABLA;
    }

    public int convInt(String clave){
        String nuevaclave="";
        
        for(int i=0;i<clave.length();i++){
            int aux = Character.getNumericValue(clave.charAt(i));
            nuevaclave+=aux;
        }
        System.out.println("AScii:" + nuevaclave);
        
        return Integer.parseInt(nuevaclave);
    }
    
    public int  hash(int nclave) {
        return nclave%19;
    }
    
    
    //------------------------
    //  POR ENCADENAMIENTO
    //------------------------
    
    //INSERCIÓN POR ENCADENAMIENTO
    
    public boolean InsertarEncadenamiento(String codigo, String nombre, float pension) {
        int pos = hash(convInt(codigo));
        
        if(getCodigoDelAlumno(pos).equals("")) {
            setCodigoDelAlumno(codigo, pos);
            setNombreDelAlumno(nombre, pos);
            setPensionDelAlumno(pension, pos);
        } else {
            if (listaColisiones[pos] == null)
                listaColisiones[pos] = new LinkedList<Alumno>();
            
            listaColisiones[pos].add(new Alumno(codigo, nombre, pension));
        }
        return true;
    }
    
    //BÚSQUEDA POR ENCADENAMIENTO
    
    public int BuscarEncadenamiento(String codigo) {
        int pos = hash(convInt(codigo)), i = 0;
        
        
        if (getCodigoDelAlumno(pos).equals(codigo)) {
            return pos;
        } else {
            try {
                int ultimo = listaColisiones[pos].size();
                while(i<ultimo && !listaColisiones[pos].get(i).getCodigoDelAlumno().equals(codigo)) {
                    i++;
                }

                if(i == ultimo){
                    return -1;
                } else {
                    System.out.println("Elemento encontrado en la lista encadenada de posicion: " + i);
                    return pos;
                }
            } catch (IndexOutOfBoundsException ex) {
                return -2;
            }
            
        }
    }
    
    //ELIMINACIÓN POR ENCADENAMIENTO
    
    public boolean EliminarEncadenamiento(String codigo)
    {
        int pos = hash(convInt(codigo)), i = 0;
        
        
        if (getCodigoDelAlumno(pos).equals(codigo)) {
            
            setCodigoDelAlumno("",pos);
            setNombreDelAlumno("",pos);
            setPensionDelAlumno(0,pos);
            return true;
            
        } else {
            try {
                int ultimo = listaColisiones[pos].size();
                while(i < ultimo && listaColisiones[pos].get(i).getCodigoDelAlumno().equals(codigo)) {
                    i++;
                }

                if(listaColisiones[pos].get(i).getCodigoDelAlumno().equals(codigo)){

                    listaColisiones[pos].get(i).setCodigoDelAlumno("");
                    listaColisiones[pos].get(i).setNombreDelAlumno("");
                    listaColisiones[pos].get(i).setPensionDelAlumno(0);
                    System.out.println("Elemento eliminado en la lista encadenada de posicion: " + i);
                    return true;
                }
                else {
                    return false;
                }
            }
            catch(IndexOutOfBoundsException ex) {
                return false;
            }
        }
        
    }
    
    public void mostrarEncadenadas(int pos) {
        int i=0;
        
        if(listaColisiones[pos]!=null) {
            int ultimo = listaColisiones[pos].size();
            try{
                while(i < ultimo && !listaColisiones[pos].get(i).getCodigoDelAlumno().equals("")) {
                System.out.printf("  %s\t%20s%10.2f\n",
                        listaColisiones[pos].get(i).getCodigoDelAlumno(),
                        listaColisiones[pos].get(i).getNombreDelAlumno(),
                        listaColisiones[pos].get(i).getPensionDelAlumno()
                );
                i++;
            }
            } catch(IndexOutOfBoundsException ex) {
                
           }
            
        }
    }
}