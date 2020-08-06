package dispersion;
public class Alumno {
    private int codigoDelAlumno;
    private String nombreDelAlumno;
    private float pensionDelAlumno;
    public Alumno(int codigo, String nombre, float pension)
    {
        codigoDelAlumno = codigo;
        nombreDelAlumno = nombre;
        pensionDelAlumno = pension;
    }
    
        public void setCodigoDelAlumno(int codigo)
    {
        codigoDelAlumno = codigo;
    }
        public int getCodigoDelAlumno()
    {
        return codigoDelAlumno;
    }
        public void setNombreDelAlumno(String nombre)
    {
        nombreDelAlumno = nombre;
    }
        public String getNombreDelAlumno()
    {
        return nombreDelAlumno;
    }
        public void setPensionDelAlumno(float pension)
    {
        pensionDelAlumno = pension;
    }
        public float getPensionDelAlumno()
    {
        return pensionDelAlumno;
    }
}