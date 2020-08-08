/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio06;

/**
 *
 * @author Edward
 */
public class Alumno {

    private String codigoDelAlumno;
    private String nombreDelAlumno;
    private float pensionDelAlumno;

    public Alumno(String codigo, String nombre, float pension) {
        codigoDelAlumno = codigo;
        nombreDelAlumno = nombre;
        pensionDelAlumno = pension;
    }

    public void setCodigoDelAlumno(String codigo) {
        codigoDelAlumno = codigo;
    }

    public String getCodigoDelAlumno() {
        return codigoDelAlumno;
    }

    public void setNombreDelAlumno(String nombre) {
        nombreDelAlumno = nombre;
    }

    public String getNombreDelAlumno() {
        return nombreDelAlumno;
    }

    public void setPensionDelAlumno(float pension) {
        pensionDelAlumno = pension;
    }

    public float getPensionDelAlumno() {
        return pensionDelAlumno;
    }
}
