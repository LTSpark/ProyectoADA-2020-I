package dispersion;
public class Instituto {
    private Alumno alumnos[];
    private final int TAM_TABLA = 20;
    public Instituto()
    {

        alumnos = new Alumno[TAM_TABLA];
        for (int i=0; i<TAM_TABLA; i++)
        {
            alumnos[i] = new Alumno(0,"",0);
        }
    }
    public void setCodigoDelAlumno (int codigo, int i)
    {
        alumnos[i].setCodigoDelAlumno(codigo);
    }
    public int getCodigoDelAlumno (int i)
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

    public int hash(int clave)
    {
        return clave%19;
    }

    public boolean Insertar(int codigo, String nombre, float pension)
    {
        int pos, pos_sigte;
        pos = hash (codigo);
        if (getCodigoDelAlumno(pos)==0)
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
            getCodigoDelAlumno(pos_sigte) !=0 &&
            pos_sigte!=pos)
            {
            pos_sigte++;
            if ( pos_sigte == getNumeroDeAlumnos())
            pos_sigte=0;

            }
            if (getCodigoDelAlumno(pos_sigte)==0)
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
    public int Buscar(int codigo)
    {
        int pos, pos_sigte;
        pos = hash (codigo);
        if (getCodigoDelAlumno(pos)==codigo)
        return pos;
        else //Se produce colisión: Solución por reasignación por prueba lineal
        {
            pos_sigte = pos + 1;
            while(pos_sigte < getNumeroDeAlumnos() &&
            getCodigoDelAlumno(pos_sigte) !=0 &&
            pos_sigte!=pos &&
            getCodigoDelAlumno(pos)!=codigo)
            {
                pos_sigte++;
                if ( pos_sigte == getNumeroDeAlumnos())
                pos_sigte=0;

            }
            if (getCodigoDelAlumno(pos_sigte)==0 || pos_sigte==pos)
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

    public int BuscarLineal(int codigo){
        int pos=hash(codigo);
        int contador=0;
        while(codigo!=getCodigoDelAlumno(pos)&&contador<TAM_TABLA){
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

    public boolean EliminarLineal (int codigo){
        int alumnoAEliminar = BuscarLineal(codigo);
        if(alumnoAEliminar == -1){
            return false;
        }
        else{
            setCodigoDelAlumno(0,alumnoAEliminar);
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
    public boolean InsertarDDireccion(int codigo, String nombre, float pension)
    {
        int pos = hash(codigo);
        int contador=0;
        boolean flag = false;
        
        while(flag == false && contador <TAM_TABLA){
            if(getCodigoDelAlumno(pos)==0){
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
    public int BuscarDDireccion(int codigo)
    {
        int pos = hash(codigo);
        int contador=0;
        //boolean flag = true;
        
        while(codigo != getCodigoDelAlumno(pos) && contador <TAM_TABLA){
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
    public boolean EliminarDDireccion(int codigo)
    {
        int alumnoAEliminar = BuscarDDireccion(codigo);
        if(alumnoAEliminar == -1){
            return false;
        }
        else{
            setCodigoDelAlumno(0,alumnoAEliminar);
            setNombreDelAlumno("",alumnoAEliminar);
            setPensionDelAlumno(0,alumnoAEliminar);
            return true;
        }
    }
}