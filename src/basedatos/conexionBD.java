
package basedatos;

import java.sql.Connection; // paquete para manipular la conexion 
import java.sql.SQLException; // es un tipo de error 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class conexionBD {
    Connection conexion;
    
    public conexionBD(){ 
        try{ // lineas de codigo  que pueden generar un error
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        }catch( ClassNotFoundException ex){
            System.out.println("Error al cargar el controlador de Mysql");
            }
    }
    
    public void abrirConexion(){
        try{  // conexion par a la base de datos 
        conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/crudpoe", "root","");
        }catch(SQLException ex ){
            System.out.println("Error al abrir db ");
        }
    }
    
    public void cerrarConexion(){
        try{
            conexion.close();
        }catch(SQLException ex){
            System.out.println("error al cerrar conexion ");
        }
    }
}
