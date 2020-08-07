package dispersion;

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
            listaColisiones[i] = new LinkedList<Alumno>();
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
        int nuevaclave=0;
        for(int i=0;i<clave.length();i++){
            nuevaclave+=(int)clave.charAt(i);
        }
        return nuevaclave;
    }
    
    public int  hash(int nclave) {
        return nclave%19;
    }

    public boolean Insertar(String codigo, String nombre, float pension)
    {
        int pos, pos_sigte;
        pos = hash (convInt(codigo));
        if (getCodigoDelAlumno(pos).equals(""))
        {
            setCodigoDelAlumno(codigo, pos);
            setNombreDelAlumno(nombre, pos);
            setPensionDelAlumno(pension, pos);
            return true;
        }
         //Se produce colisión: Solución por reasignación por prueba lineal
        else{
            pos_sigte = pos + 1;
            while(pos_sigte < getNumeroDeAlumnos() &&
            !getCodigoDelAlumno(pos_sigte).equals("") &&
            pos_sigte!=pos)
            {
            pos_sigte++;
            if ( pos_sigte == getNumeroDeAlumnos())
            pos_sigte=0;

            }
            if (getCodigoDelAlumno(pos_sigte).equals(""))
            {
            setCodigoDelAlumno(codigo, pos_sigte);
            setNombreDelAlumno(nombre, pos_sigte);
            setPensionDelAlumno(pension, pos_sigte);
            return true;
            }
            else
            return false;

        }
    }
    public int Buscar(String codigo)
    {
        int pos, pos_sigte;
        pos = hash (convInt(codigo));
        if (getCodigoDelAlumno(pos).equals(codigo))
        return pos;
        else //Se produce colisión: Solución por reasignación por prueba lineal
        {
            pos_sigte = pos + 1;
            while(pos_sigte < getNumeroDeAlumnos() &&
            !getCodigoDelAlumno(pos_sigte).equals("") &&
            pos_sigte!=pos &&
            getCodigoDelAlumno(pos).equals(codigo))
            {
                pos_sigte++;
                if ( pos_sigte == getNumeroDeAlumnos())
                pos_sigte=0;

            }
            if (getCodigoDelAlumno(pos_sigte).equals("") || pos_sigte==pos)
            {
                return -1; //código no existe
            }
            else
            return pos_sigte;
        }
    }
    //-----------------------
    //  POR ELIMINACIÓN LINEAL
    //-----------------------

    public int BuscarLineal(String codigo){
        int pos=hash(convInt(codigo));
        int contador=0;
        while(!getCodigoDelAlumno(pos).equals(codigo)&&contador<TAM_TABLA){
            pos++;
            contador++;
        }
        if(contador<TAM_TABLA){
            return pos;
        }
        else {
            return -1;
        }
    }

    public boolean EliminarLineal (String codigo){
        int alumnoAEliminar = BuscarLineal(codigo);
        if(alumnoAEliminar == -1){
            return false;
        }
        else{
            setCodigoDelAlumno("",alumnoAEliminar);
            setNombreDelAlumno("",alumnoAEliminar);
            setPensionDelAlumno(0,alumnoAEliminar);
            return true;
        }
    }


    //------------------------
    //  POR DOBLE DIRECCIÓN
    //------------------------
    private int hashDDireccion(int entrada)
    {
        int salida=0;
        entrada = entrada + TAM_TABLA + 1;
        salida = hash(entrada);
        return salida;
    }
    //INSERCIÓN POR DOBLE DIRECCIÓN
    public boolean InsertarDDireccion(String codigo, String nombre, float pension)
    {
        int pos = hash(convInt(codigo));
        int contador=0;
        boolean flag = false;
        
        while(flag == false && contador <TAM_TABLA){
            if(getCodigoDelAlumno(pos).equals("")){
                flag = true;
            }
            else{
                pos = hashDDireccion(pos);
                contador++;
            }
        }
        
        if(flag){
            setCodigoDelAlumno(codigo, pos);
            setNombreDelAlumno(nombre, pos);
            setPensionDelAlumno(pension, pos);
            return true;
        }
        else{
            return false;
        }
    }
    //BÚSQUEDA POR DOBLE DIRECCIÓN
    public int BuscarDDireccion(String codigo)
    {
        int pos = hash(convInt(codigo));
        int contador=0;
        //boolean flag = true;
        
        while(!getCodigoDelAlumno(pos).equals(codigo) && contador <TAM_TABLA){
            pos = hashDDireccion(pos);
            contador++;
        }
        
        if(contador < TAM_TABLA){
            return pos;
        }
        else{
            return -1;
        }
    }
    //ELIMINACIÓN POR DOBLE DIRECCIÓN
    public boolean EliminarDDireccion(String codigo)
    {
        int alumnoAEliminar = BuscarDDireccion(codigo);
        if(alumnoAEliminar == -1){
            return false;
        }
        else{
            setCodigoDelAlumno("",alumnoAEliminar);
            setNombreDelAlumno("",alumnoAEliminar);
            setPensionDelAlumno(0,alumnoAEliminar);
            return true;
        }
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
            listaColisiones[pos].add(new Alumno(codigo, nombre, pension));
        }
        return true;
    }
    
    //BÚSQUEDA POR ENCADENAMIENTO
    
    public int BuscarEncadenamiento(String codigo) {
        int pos = hash(convInt(codigo)), i = 0;
        int ultimo = listaColisiones[pos].size();
        
        if (getCodigoDelAlumno(pos).equals(codigo)) {
            return pos;
        } else {
            try {
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
                while(listaColisiones[pos].get(i) != null && listaColisiones[pos].get(i).getCodigoDelAlumno().equals(codigo)) {
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
            try{
                while(listaColisiones[pos].get(i) != null && !listaColisiones[pos].get(i).getCodigoDelAlumno().equals("")) {
                System.out.printf("\t%d\t%20s%10.2f\n",
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
    
    
    public int BusquedaPruebaCuadratica(String codigo){
        int pos = hash(convInt(codigo)), posSgte, i = 1;
        
        if(getCodigoDelAlumno(pos).equals(codigo))
            return pos;
        
        else{
            posSgte = pos + i*i;
            
            while(!"".equals(getCodigoDelAlumno(posSgte))
                  && !getCodigoDelAlumno(posSgte).equals(codigo)
                  && pos != posSgte){
                
                i++;
                posSgte  = pos + i*i;
                
                if(posSgte >= TAM_TABLA){
                    while(posSgte >= TAM_TABLA){
                        posSgte -= TAM_TABLA;
                    }                 
                }
                
            }
            
            if("".equals(getCodigoDelAlumno(posSgte)) || pos == posSgte)
                return -1;
            
            else
                return posSgte;
        }
    }
    
        public boolean InsercionPruebaCuadratica(String codigo, String nombre, float pension){
        int pos = hash(convInt(codigo)), posSgte, i = 1;
        
        if ("".equals(getCodigoDelAlumno(pos))){
            setCodigoDelAlumno(codigo, pos);
            setNombreDelAlumno(nombre, pos);
            setPensionDelAlumno(pension, pos);
            
            return true; 
        }
        
        else{
            posSgte = pos + i*i;
            
            while(pos != posSgte && !"".equals(getCodigoDelAlumno(posSgte))){
                i++;
                posSgte = pos + i*i;
                    
                if(posSgte >= TAM_TABLA){
                    while(posSgte >= TAM_TABLA){
                        posSgte -= TAM_TABLA;
                    }                 
                }
                                  
            }
            
            if("".equals(getCodigoDelAlumno(posSgte))){
                setCodigoDelAlumno(codigo, posSgte);
                setNombreDelAlumno(nombre, posSgte);
                setPensionDelAlumno(pension, posSgte);
            
                return true;
            }
            
            else
                return false;
            
        }

    }
    
    public boolean EliminarPruebaCuadratica(String codigo)
    {
        int alumnoAEliminar = BusquedaPruebaCuadratica(codigo);
        if(alumnoAEliminar == -1){
            return false;
        }
        else{
            setCodigoDelAlumno("",alumnoAEliminar);
            setNombreDelAlumno("",alumnoAEliminar);
            setPensionDelAlumno(0,alumnoAEliminar);
            return true;
        }
    }
    
}