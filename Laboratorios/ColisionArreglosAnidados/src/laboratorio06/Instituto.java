package laboratorio06;

public class Instituto {

    private final int TAM_TABLA = 20;
    private final Alumno alu[][];

    public Instituto() {
        alu = new Alumno[TAM_TABLA][TAM_TABLA];
        for (int i = 0; i < TAM_TABLA; i++) {
            for (int j = 0; j < TAM_TABLA; j++) {
                alu[i][j] = new Alumno("", "", 0);
            }
        }
    }

    public void setCodigoDelAlu(String codigo, int pos, int i) {
        alu[pos][i].setCodigoDelAlumno(codigo);
    }

    public String getCodigoDelAlu(int pos, int i) {
        return alu[pos][i].getCodigoDelAlumno();
    }

    public void setNombreDelAlu(String nombre, int pos, int i) {
        alu[pos][i].setNombreDelAlumno(nombre);
    }

    public String getNombreDelAlu(int pos, int i) {
        return alu[pos][i].getNombreDelAlumno();
    }

    public void setPensionDelAlu(float pension, int pos, int i) {
        alu[pos][i].setPensionDelAlumno(pension);
    }

    public float getPensionDelAlu(int pos, int i) {
        return alu[pos][i].getPensionDelAlumno();
    }

    public int getNumeroDeAlumnos() {
        return TAM_TABLA;
    }

    public int convInt(String clave) {
        String nuevaclave = "";

        for (int i = 0; i < clave.length(); i++) {
            int aux = Character.getNumericValue(clave.charAt(i));
            nuevaclave += aux;
        }

        return Integer.parseInt(nuevaclave);
    }

    public int hash(int nclave) {
        return nclave % 19;
    }

    //MÉTODOS
    //Funcion para completar la matriz
    public boolean insertarArreglo(String codigo, String nombre, float pension) {
        int pos;
        pos = hash(convInt(codigo));
        int i = 0;
        if (getCodigoDelAlu(pos, i).equals("")) {
            setCodigoDelAlu(codigo, pos, i);
            setNombreDelAlu(nombre, pos, i);
            setPensionDelAlu(pension, pos, i);
            return true;
        } else {
            try {
                while (!getCodigoDelAlu(pos, i).equals("") && i < TAM_TABLA && pos < TAM_TABLA) {
                    while (!getCodigoDelAlu(pos, i).equals("") && i < TAM_TABLA) {
                        i++;
                    }
                    if (i != TAM_TABLA) {
                        alu[pos][i].setCodigoDelAlumno(codigo);
                        alu[pos][i].setNombreDelAlumno(nombre);
                        alu[pos][i].setPensionDelAlumno(pension);
                        return true;
                    } else {
                        i = 0;
                    }
                    pos++;
                }
                if (pos != TAM_TABLA) {
                    alu[pos][i].setCodigoDelAlumno(codigo);
                    alu[pos][i].setNombreDelAlumno(nombre);
                    alu[pos][i].setPensionDelAlumno(pension);
                    return true;
                } else {
                    return false;
                }
            } catch (IndexOutOfBoundsException ex) {
                return false;
            }
        }
    }

    /*Funcion entera que me retornará la posicion del vector donde están almacenadas las colisiones
      recibe como parámetro el código y me retorna el valor del iterador i en caso encuentre valor
      si no encuentra me retorna un -1.*/
    public int buscarArreglo(String codigo) {
        int pos;
        pos = hash(convInt(codigo));
        int i = 0;
        if (getCodigoDelAlu(pos, i).equals(codigo)) {
            return i;
        } else {
            try {
                while (!getCodigoDelAlu(pos, i).equals(codigo) && i < TAM_TABLA && pos < TAM_TABLA) {
                    while (!getCodigoDelAlu(pos, i).equals(codigo) && i < TAM_TABLA) {
                        i++;
                    }
                    if (i != TAM_TABLA) {
                        return i;
                    } else {
                        i = 0;
                    }
                    pos++;
                }
                if (pos != TAM_TABLA) {
                    return i;
                } else {
                    return -1;
                }
            } catch (IndexOutOfBoundsException ex) {
                return -1;
            }
        }
    }

    //Funcion para mostrar la matriz despues de buscar
    public void mostrarArreglo(int pos, int i) {
        System.out.printf("%s\t%20s%10.2f\t\t",
                getCodigoDelAlu(pos, i),
                getNombreDelAlu(pos, i),
                getPensionDelAlu(pos, i)
        );
        System.out.println("\nPosicion (" + i + ") de la fila " + pos);
    }

    //Funcion para eliminar 
    public boolean eliminarArreglo(String codigo) {
        int pos;
        pos = hash(convInt(codigo));
        int i = 0;
        if (getCodigoDelAlu(pos, i).equals(codigo)) {
            setCodigoDelAlu("", pos, i);
            setNombreDelAlu("", pos, i);
            setPensionDelAlu(0, pos, i);
            return true;
        } else {
            try {
                while (!getCodigoDelAlu(pos, i).equals(codigo) && i < TAM_TABLA && pos < TAM_TABLA) {
                    while (!getCodigoDelAlu(pos, i).equals(codigo) && i < TAM_TABLA) {
                        i++;
                    }
                    if (i != TAM_TABLA) {
                        alu[pos][i].setCodigoDelAlumno("");
                        alu[pos][i].setNombreDelAlumno("");
                        alu[pos][i].setPensionDelAlumno(0);
                        return true;
                    } else {
                        i = 0;
                    }
                    pos++;
                }
                if (pos != TAM_TABLA) {
                    alu[pos][i].setCodigoDelAlumno("");
                    alu[pos][i].setNombreDelAlumno("");
                    alu[pos][i].setPensionDelAlumno(0);
                    return true;
                } else {
                    return false;
                }
            } catch (IndexOutOfBoundsException ex) {
                return false;
            }
        }
    }
}
