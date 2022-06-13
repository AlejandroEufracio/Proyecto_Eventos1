package basedatos;

import java.sql.Connection; // paquete para manipular la conexion 
import java.sql.SQLException; // es un tipo de error 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import logica.Usuario;

import logica.Comida;

public class conexionBD {
//    Connection conexion;
    
    Connection conexion;
    PreparedStatement autentificarUsuario;
    PreparedStatement autentificarAsesor;
    PreparedStatement insertarUser;
    PreparedStatement insertarAsesor;
    PreparedStatement contarUsuarios;
    PreparedStatement contarAsesores;
    PreparedStatement mostrarTodaComida;
    PreparedStatement mostrarCategoriaComida;
    PreparedStatement buscarComida;
    PreparedStatement agregarComida;
    PreparedStatement borrarComida;
    PreparedStatement agregarProgresoDiario;
    PreparedStatement ActualizarProgresoDiario;
    PreparedStatement mostrarProgreso;
    PreparedStatement actualizarUsuario;
    PreparedStatement verUsuario;
    
    
    
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
        insertarUser = conexion.prepareStatement("INSERT INTO usuario values (?,?,?)");
        insertarAsesor = conexion.prepareStatement("INSERT INTO Asesor values (?,?,?)");
        autentificarUsuario = conexion.prepareStatement("SELECT * FROM usuario WHERE user =? AND password =?");
        autentificarAsesor = conexion.prepareStatement("SELECT * FROM asesor WHERE user =? AND password =?");
        contarUsuarios = conexion.prepareStatement("SELECT COUNT(*) FROM usuario WHERE user =?");
        contarAsesores = conexion.prepareStatement("SELECT COUNT(*) FROM asesor WHERE user =?");
        mostrarTodaComida = conexion.prepareStatement("SELECT * FROM comida");
        mostrarCategoriaComida = conexion.prepareStatement("SELECT * FROM comida WHERE categoria =?");
        buscarComida = conexion.prepareStatement("SELECT * FROM comida WHERE nombre =?");
        agregarComida = conexion.prepareStatement("INSERT INTO comida values (?,?,?,?,?,?,?)");
        borrarComida = conexion.prepareStatement("DELETE FROM comida WHERE nombre =?");
        agregarProgresoDiario = conexion.prepareStatement("INSERT INTO Progreso values (?,?,?)");
        ActualizarProgresoDiario = conexion.prepareStatement("UPDATE Progreso SET TotalCalorias=? WHERE Dia=?");
        mostrarProgreso = conexion.prepareCall("SELECT * FROM Progreso WHERE user=?");
        actualizarUsuario = conexion.prepareStatement("UPDATE usuario SET Edad=?, Peso=?, Estatura=?, CalRec=?, ProteinaRec=?, "
                + " CarboRec=? WHERE user=?  ");
        verUsuario = conexion.prepareStatement("Select * FROM usuario WHERE user=?");
        }catch(SQLException ex ){
            System.out.println("Error al abrir bd ");
        }
    }
    
    public void cerrarConexion(){
        try{
            conexion.close();
        }catch(SQLException ex){
            System.out.println("Error al cerrar conexion ");
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
                objUsuario.setEmail(rs.getString("email"));
                objUsuario.setEdad(rs.getInt("Edad"));
                objUsuario.setPeso(rs.getDouble("Peso"));
                objUsuario.setEstatura(rs.getDouble("Estatura"));
                objUsuario.setCaloriasDiarias(rs.getDouble("CalRec"));
                objUsuario.setProteinaDiaria(rs.getDouble("ProteinaRec"));
                objUsuario.setCarbohidratosDiarios(rs.getDouble("CarboRec"));
                
            }           
        } catch (SQLException ex) {
           System.out.println("Error al autentificar en la BD");
           System.out.println(ex.getMessage());
            
        }
        
        return objUsuario;
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
    
    
    
    
    public ResultSet mostrarTodasComidas(){
        ResultSet rs;
        
        try {
            
            rs = mostrarTodaComida.executeQuery();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener todas las comidas");
            System.out.println(ex.getMessage() );
            return null;
        }
        
        return rs;
    }
    
    public ResultSet mostrarCategoriaComidas(String categorias){
        ResultSet rs;
        try {
            
            mostrarCategoriaComida.setString(1, categorias);
            rs = mostrarCategoriaComida.executeQuery();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener todas las comidas donde categoria: " + categorias);
            System.out.println(ex.getMessage());
            return null;
        }
        
        return rs;
    }
    
        public ResultSet mostrarComidaBuscada(String nombre){
        ResultSet rs;
        
        try {
            buscarComida.setString(1, nombre);
            rs = buscarComida.executeQuery();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener buscar la comidas");
            System.out.println(ex.getMessage() );
            return null;
        }
        
        return rs;
    }
    
        public boolean agregarComida(Comida objComida){
            
            ResultSet rs;

        
        try{
            
            agregarComida.setString(1, objComida.getNombre());
            agregarComida.setString(2, objComida.getCategoria());
            agregarComida.setDouble(3, objComida.getCalorias());
            agregarComida.setDouble(4, objComida.getProteina());
            agregarComida.setDouble(5, objComida.getCarbohidratos());
            agregarComida.setDouble(6, objComida.getGrasas());
            agregarComida.setDouble(7, objComida.getAzucares());
            
            
            agregarComida.executeUpdate();
            
            return true;
            
        }catch( SQLException ex  ){
                
            System.out.println("Error al insertar comida");
            System.out.println(ex.getMessage() );
            
            }
            
        
        return false;  
        
        }
        
        public void borrarComida(String nombre){
        ResultSet rs;
        
        try {
            
            borrarComida.setString(1, nombre);
            borrarComida.execute();
            
        } catch (SQLException ex) {
            System.out.println("Error al borrar todas las comidas donde nombre: " + nombre);
            System.out.println(ex.getMessage());
            
        }
        
       
    }  
        
        public boolean agregarProgresoDiario(String dia, double calorias, String user) {
            try {
                agregarProgresoDiario.setString(1, user);
                agregarProgresoDiario.setString(2, dia);
                agregarProgresoDiario.setDouble(3, calorias);
                
                agregarProgresoDiario.executeUpdate();
                
                return true;
                
            }catch( SQLException ex  ){
                
                System.out.println("Error al insertar comida");
                System.out.println(ex.getMessage() );
            
            }

            return false;  
        }
        
        public ResultSet mostrarProgreso(String user) {
            ResultSet rs;
        
            try {
                mostrarProgreso.setString(1, user);
                rs = mostrarProgreso.executeQuery();
            
            } catch (SQLException ex) {
                System.out.println("Error al obtener el progreso");
                System.out.println(ex.getMessage() );
                return null;
            }
        
            return rs;
        }
    
        
        
        public boolean actualizarUsuario(Usuario objUsuario){
            
            ResultSet rs;

        
        try{
            
            actualizarUsuario.setInt(1, objUsuario.getEdad());
            actualizarUsuario.setDouble(2, objUsuario.getPeso());
            actualizarUsuario.setDouble(3, objUsuario.getEstatura());
            actualizarUsuario.setDouble(4, objUsuario.getCaloriasDiarias());
            actualizarUsuario.setDouble(5, objUsuario.getProteinaDiaria());
            actualizarUsuario.setDouble(6, objUsuario.getCarbohidratosDiarios());
            actualizarUsuario.setString(7, objUsuario.getUser());
            
            
            
            actualizarUsuario.executeUpdate();
            
            return true;
            
        }catch( SQLException ex  ){
                
            System.out.println("Error al actualizar usuario");
            System.out.println(ex.getMessage() );
            
            }
            
        
        return false;  
        
        }   
        
        
        public Usuario verUsuario(String usuario){
        
                
        ResultSet rs =  null;
        Usuario objUsuario = null;
         
        try {
            
            verUsuario.setString(1,usuario);
           
            rs = verUsuario.executeQuery();
            
            
            if(rs.next() ) {
                System.out.println("Entro");
                objUsuario = new Usuario();
                objUsuario.setUser(rs.getString("user"));
                objUsuario.setEmail(rs.getString("email"));
                objUsuario.setEdad(rs.getInt("Edad"));
                objUsuario.setPeso(rs.getDouble("Peso"));
                objUsuario.setEstatura(rs.getDouble("Estatura"));
                objUsuario.setCaloriasDiarias(rs.getDouble("CalRec"));
                objUsuario.setProteinaDiaria(rs.getDouble("ProteinaRec"));
                objUsuario.setCarbohidratosDiarios(rs.getDouble("CarboRec"));
                
            }           
        } catch (SQLException ex) {
           System.out.println("Error al autentificar en la BD");
           System.out.println(ex.getMessage());
            
        }
        
        return objUsuario;
    }    
}