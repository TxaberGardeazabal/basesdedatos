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
public class Persona {
    
    private String dni;
    private String nombre;
    private Integer edad;
    private Integer telefono;
    private Empresa empresa;
    
    private ArrayList<Evento> asiste;

    public Persona(String dni, String nombre, Integer edad, Integer telefono, Empresa empresa) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.empresa = empresa;
    }
    
    public Persona(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public ArrayList<Evento> getAsiste() {
        return asiste;
    }

    public void setAsiste(Evento asiste) {
        if (this.asiste == null)
            this.asiste = new ArrayList();
        
        this.asiste.add(asiste);
    }
    
    
}
