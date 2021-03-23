/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author txaber
 */
public class Cliente extends Persona{
    
    private String telefono;
    private String correo;
    
    private ArrayList<Caso> casos;

    public Cliente(String dni, String nombre, String apellidos, String direccion, String telefono, String correo, ArrayList<Caso> casos) {
        super (dni,nombre,apellidos,direccion);
        this.telefono = telefono;
        this.correo = correo;
        this.casos = casos;
    }

    public Cliente(String dni, String nombre, String apellidos, String direccion, String telefono, String correo) {
        super (dni,nombre,apellidos,direccion);
        this.telefono = telefono;
        this.correo = correo;
        this.casos = new ArrayList();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ArrayList<Caso> getCasos() {
        return casos;
    }

    public void setCasos(Caso casos) {
        this.casos.add(casos);
    }

    @Override
    public String toString() {
        return "Cliente{" + "dni=" + this.getDni() + ", nombre=" + this.getNombre() + ", apellidos=" + this.getApellido() + ", direccion=" + this.getDireccion() + ", telefono=" + telefono + ", correo=" + correo + '}';
    }
    
}
