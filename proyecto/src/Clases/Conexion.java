      
package Clases;

import java.sql.*;

public class Conexion {
    
    private String DB = "jdbc:postgresql://localhost/ABmaquinarias";
    private String user = "postgres";
    private String password = "";
    Connection conn = null;
    
    
    // metodo para obtener la conexion con la BD
    public void connect() {
       try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex) {
            System.out.println("EXCEPCIÓN: Error al cargar el driver de PostgreSQL\n" + ex);
        }
        
        try {
            conn = DriverManager.getConnection(DB, user, password);
            System.out.println("Conexión a la base de datos exitosa!");
        } catch (SQLException ex) {
            System.out.println("EXCEPCIÓN: No fue posible conectarse a la base de datos\n" + ex);
        } 
    }
    
    //Insertar empleado p
    
    public void insertarEmpleado(String id, String nombres, String apellidos, String funcion) {
        connect();
        PreparedStatement p = null;
        try {
            p = conn.prepareStatement(String.format("INSERT INTO empleados(id_empleado, nombres, apellidos, funcion) "
                                                    + "VALUES ('%s', '%s', '%s', '%s')", id, nombres, apellidos, funcion));
            p.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }    
        
    }
    
    //Insertar maquina p
    
    public void insertarMaquina(String id, String modelo, String tipo) {
        connect();
        PreparedStatement p = null;
        try {
            p = conn.prepareStatement(String.format("INSERT INTO maquinas(id_maquina, modelo, tipo) "
                                                    + "VALUES ('%s', '%s', '%s')", id, modelo, tipo));
            p.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
    }
    
    // metodo pa eliminar empleado q te devuelve un String con los datos importantes del weon eliminado:
    // (nombres, apellidos y funcion)
    
    public String eliminarEmpleado(String id) {
        connect();
        String eliminado = null;
        PreparedStatement p = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(String.format("SELECT * FROM empleados WHERE id_empleado = '%s'", id));
            rs.next();
            eliminado = rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5);
            
            st.close();
            rs.close();
            
            p = conn.prepareStatement(String.format("DELETE FROM empleados WHERE id_empleado = '%s'", id));
            p.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        
        
        return eliminado; 
        // Taría bueno que en la clase en la que se invoque este método haya un 
        //      si (eliminado == null) entonces 
        //          imprimir("ID incorrecto")
        // o algo asi porque el metodo te bota null si es que el id es incorrecto p gaa
    }
    
    // metodo pa eliminar maquina q te devuelve un String con los datos importantes de la wea eliminada:
    // (modelo y tipo)
    
    public String eliminarMaquina(String id) {
        connect();
        String eliminado = null;
        PreparedStatement p = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(String.format("SELECT * FROM maquinas WHERE id_maquina = '%s'", id));
            rs.next();
            eliminado = rs.getString(3) + " " + rs.getString(4);
            
            st.close();
            rs.close();
            
            p = conn.prepareStatement(String.format("DELETE FROM maquinas WHERE id_maquina = '%s'", id));
            p.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        
        
        return eliminado;
        // Taría bueno que en la clase en la que se invoque este método haya un 
        //      si (eliminado == null) entonces 
        //          imprimir("ID incorrecto")
        // o algo asi porque el metodo te bota null si es que el id es incorrecto p gaa
    }
    
   //metodo que asigna una maquina a un empleado con el id de los dos p loco
    // retorna false si no se logro asignar la wea sea cual sea el motivo
    // retorna true si esta todo ok.
    // la idea es que este booleano sea chapado desde donde se invoca y segun si es true o false se imprima
    // si se logro o no se logro asignar la maquina.
    
    public boolean asignarMaquina(String idEmpl, String idMaq) {
        connect();
        PreparedStatement p = null;

        try {
            p = conn.prepareStatement(String.format("UPDATE empleados SET maquina_id = '%s' WHERE id_empleado = '%s'", idMaq, idEmpl));
            p.executeUpdate();
        } catch(SQLException ex) {
            System.out.println(ex);
            return false;
        }
        
        return true;
    }
    
    
    ////////////////////////////////////////////////////
    //          IMPORTANTEEEEEEEEEEEE
    /////////////////////////////////////////////////////
    // cada uno de los dos métodos sgtes tienen otro método que los sobrecarga (están más abajo esos metodos).
    // El objetivo de los dos métodos sgtes es que sirvan para mostrar datos de los empleados o de las maquinas en una tabla
    // esto se haría con un for y un iterador que empieze en 1 y que este iterador sea pasado de argumento a dichos metodos.
    // Y luego los dos metodos de sobrecarga que estan mas abajo son para el resto de casos en los que se necesiten los datos
    // de un empleado o una maquina a los cuales se accede con su id real.
    
  public Empleado obtenerEmpleado(int id) { // este id es uno interno a la base de datos, no es el que se ingresa.
        connect();
        Statement st = null;
        ResultSet rs = null;
        Empleado empl = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(String.format("SELECT * FROM empleados WHERE id = %d", id));
            rs.next();
            
            empl = new Empleado(rs.getString(2), rs.getString(3), rs.getString(4));
            
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        return empl;
    }
    
    public Maquina obtenerMaquina(int id) {
        connect();
        
        Statement st = null;
        ResultSet rs = null;
        Maquina maq = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(String.format("SELECT * FROM maquinas WHERE id = %d", id));
            rs.next();
            
            maq = new Maquina(rs.getString(2),rs.getString(4), rs.getString(3));
            
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return maq;
    }


    
    /////////////////////////////////////////////////////////
    // SOBRECARGA DE METODOS
    /////////////////////////////////////////////////////////
    // 
    
    
       public Empleado obtenerEmpleado(String id) {
        connect();
        Statement st = null;
        ResultSet rs = null;
        Empleado empl = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(String.format("SELECT * FROM empleados WHERE id_empleado = %s", id));
            rs.next();
            
            empl = new Empleado(rs.getString(2), rs.getString(3), rs.getString(4));
            
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        return empl;
    }
    
    public Maquina obtenerMaquina(String id) {
        connect();
        
        Statement st = null;
        ResultSet rs = null;
        Maquina maq = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(String.format("SELECT * FROM maquinas WHERE id_maquina = %s", id));
            rs.next();
            
            maq = new Maquina(rs.getString(2),rs.getString(4), rs.getString(3));
            
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return maq;
    }
    
}
   