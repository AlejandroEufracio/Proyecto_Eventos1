package basedatos;

import java.sql.Connection; // paquete para manipular la conexion 
import java.sql.SQLException; // es un tipo de error 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import logica.Usuario;
import logica.Asesor;

public class conexionBD {
//    Connection conexion;
    
    Connection conexion;
    PreparedStatement autentificarUsuario;
    PreparedStatement autentificarAsesor;
    PreparedStatement insertarUser;
    PreparedStatement insertarAsesor;
    PreparedStatement contarUsuarios;
    PreparedStatement contarAsesores;
    
    
    
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
        insertarUser = conexion.prepareStatement("INSERT INTO Cuenta values (?,?,?)");
        insertarAsesor = conexion.prepareStatement("INSERT INTO Asesor values (?,?,?)");
        autentificarUsuario = conexion.prepareStatement("SELECT * FROM cuenta WHERE user =? AND password =?");
        autentificarAsesor = conexion.prepareStatement("SELECT * FROM asesor WHERE user =? AND password =?");
        contarUsuarios = conexion.prepareStatement("SELECT COUNT(*) FROM cuenta WHERE user =?");
        contarAsesores = conexion.prepareStatement("SELECT COUNT(*) FROM asesor WHERE user =?");
        }catch(SQLException ex ){
            System.out.println("Error al abrir bd ");
        }
    }
    
    public void cerrarConexion(){
        try{
            conexion.close();
        }catch(SQLException ex){
            System.out.println("error al cerrar conexion ");
        }
    }
    
    public Usuario autentificarUsuario(String usuario, String contraseña){
        
                
        ResultSet rs =  null;
        Usuario objUsuario = null;
         
        try {
            
            autentificarUsuario.setString(1,usuario);
            autentificarUsuario.setString(2,contraseña);
            rs = autentificarUsuario.executeQuery();
            
            
            if(rs.next() ) {
                System.out.println("Entro");
                objUsuario = new Usuario();
                objUsuario.setUser(rs.getString("user"));
                //objUsuario.setEdad(rs.getInt("edad"));
                objUsuario.setEmail(rs.getString("email"));
                
            }           
        } catch (SQLException ex) {
           System.out.println("Error al autentificar en la BD");
           System.out.println(ex.getMessage());
            
        }
        
        return objUsuario;
    }
    
     public Asesor autentificarAsesor(String usuario, String contraseña){
        
                
        ResultSet rs =  null;
        Asesor objAsesor = null;
         
        try {
            
            autentificarAsesor.setString(1,usuario);
            autentificarAsesor.setString(2,contraseña);
            rs = autentificarAsesor.executeQuery();
            
            
            if(rs.next() ) {
                System.out.println("Entro");
                objAsesor = new Asesor();
                objAsesor.setUser(rs.getString("user"));
                //objUsuario.setEdad(rs.getInt("edad"));
                objAsesor.setEmail(rs.getString("email"));
                
            }           
        } catch (SQLException ex) {
           System.out.println("Error al autentificar en la BD");
           System.out.println(ex.getMessage());
            
        }
        
        return objAsesor;
    }
    
    public boolean insertarUser(Usuario objUs){
        
        ResultSet rs;

        
        try{
            contarUsuarios.setString(1, objUs.getUser());
            rs = contarUsuarios.executeQuery();
            if(rs.next()){
                
                if(rs.getInt(1)>0){
                    System.out.println("El usuario ya existe");
                    return false;
                }
                
                insertarUser.setString(1, objUs.getUser());
                insertarUser.setString(2, objUs.getEmail());
                insertarUser.setString(3, objUs.getPassword());
                insertarUser.executeUpdate();

            }}catch( SQLException ex  ){
            System.out.println("Error al insertar usuario");
            System.out.println(ex.getMessage() );
        }
        
        return true;
        
    }
    
    public boolean insertarAsesor(Asesor objAsesor){
        
        ResultSet rs;
        
        
        try{
            contarAsesores.setString(1, objAsesor.getUser());
            rs = contarAsesores.executeQuery();
            
            if(rs.next()){
            
            if(rs.getInt(1)>0){
                System.out.println("El asesor ya esta registrado");
                return false; 
            }
            
            insertarAsesor.setString(1, objAsesor.getUser());
            insertarAsesor.setString(2, objAsesor.getEmail());
            insertarAsesor.setString(3, objAsesor.getPassword());
            insertarAsesor.executeUpdate();
            
            }}catch( SQLException ex  ){
            System.out.println("Error al insertar usuario");
            System.out.println(ex.getMessage() );
        }
        
        return true;
        
    }
}