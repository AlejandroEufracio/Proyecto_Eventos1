/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import logica.Cuenta;
import basedatos.conexionBD;

public class CrearCuenta {
    public static void main(String[] args) {
        Cuenta objCuenta = new Cuenta();
        conexionBD BD = new conexionBD();
        
        objCuenta.setUser("Yeyo");
        objCuenta.setEmail("email");
        objCuenta.setPassword("hola");
        
        System.out.println(objCuenta.mostrarDatos());
    }
}
