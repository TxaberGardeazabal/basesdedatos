/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author txaber
 */
public class Abogado extends Persona{
    
    
    private ArrayList<Caso> casos;

    public Abogado(String dni, String nombre, String apellidos, String direccion, ArrayList<Caso> casos) {
        super(dni,nombre,apellidos,direccion);
        this.casos = casos;
    }

    public Abogado(String dni, String nombre, String apellidos, String direccion) {
        super(dni,nombre,apellidos,direccion);
        this.casos = new ArrayList();
    }

    public ArrayList<Caso> getCasos() {
        return casos;
    }

    public void setCasos(ArrayList<Caso> casos) {
        this.casos = casos;
    }

    @Override
    public String toString() {
        return "Abogado{" + "dni=" + this.getDni() + ", nombre=" + this.getNombre() + ", apellidos=" + this.getApellido() + ", direccion=" + this.getDireccion() + '}';
    }
    
    
}
