
package logica;


public class Usuario extends Cuenta{
    
    private int edad;
    private String sexo;
    private double peso;
    private double estatura;
    private double caloriasDiarias;
    private double proteinaDiaria;
    private double carbohidratosDiarios;
     
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getCaloriasDiarias() {
        return caloriasDiarias;
    }

    public void setCaloriasDiarias(double caloriasDiarias) {
        this.caloriasDiarias = caloriasDiarias;
    }

    public double getProteinaDiaria() {
        return proteinaDiaria;
    }

    public void setProteinaDiaria(double proteinaDiaria) {
        this.proteinaDiaria = proteinaDiaria;
    }

    public double getCarbohidratosDiarios() {
        return carbohidratosDiarios;
    }

    public void setCarbohidratosDiarios(double carbohidratosDiarios) {
        this.carbohidratosDiarios = carbohidratosDiarios;
    }
    
    @Override
    public String mostrarDatos(){
        
        String dato = super.mostrarDatos();
        
        dato += "Edad: " + getEdad()+ "\n" + 
                "Peso: " + getPeso()+ "\n" +
                "Estatura: " + getEstatura()+ "\n" + 
                "Calorias recomenadas: " + getCaloriasDiarias()+ "\n" +
                "Proteinas recomendadas: " + getProteinaDiaria()+ "\n" +
                "Carbohidratos recomendadas: " + getCarbohidratosDiarios()+ "\n";
        
        return dato;
                
    }
    
    
    
}
