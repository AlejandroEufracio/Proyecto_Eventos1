
package basedatos;

import java.sql.Connection; // paquete para manipular la conexion 
import java.sql.SQLException; // es un tipo de error 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import logica.Usuario;

public class conexionBD {
    Connection conexion;
    PreparedStatement insertarUser;
    
    public conexionBD(){ 
        try{ // lineas de codigo  que pueden generar un error
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        }catch( ClassNotFoundException ex){
            System.out.println("Error al cargar el controlador de Mysql");
            }
    }
    
    public void abrirConexion(){
        try{  // conexion par a la base de datos 
        conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/nutripoe", "root", "");
        insertarUser = conexion.prepareStatement("INSERT INTO Cuenta values (?,?,?)");
        }catch(SQLException ex ){
            System.out.println("Error al abrir bd");
        }
    }
    
    public void cerrarConexion(){
        try{
            conexion.close();
        }catch(SQLException ex){
            System.out.println("Error al cerrar conexion");
        }
    }
    
    public void insertarUser(Usuario objUs){
        try{
            insertarUser.setString(1, objUs.getUser());
            insertarUser.setString(2, objUs.getEmail());
            insertarUser.setString(3, objUs.getPassword());
            
            insertarUser.executeUpdate();
        }catch( SQLException ex  ){
            System.out.println("Error al insertar usuario");
            System.out.println(ex.getMessage() );
        }
    }
}
