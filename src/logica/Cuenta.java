
package logica;

public class Cuenta {
    //Atributos
    
    private String user;
    private String email;
    private String password;
    
    //Metodos

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String mostrarDatos() {
        String datos = "";
        datos += "Nombre : " + getUser() + "\n" +
                 "Email : " + getEmail() + "\n" +
                 "Password : " + getPassword() + "\n";
        
        return datos;
    }
}
