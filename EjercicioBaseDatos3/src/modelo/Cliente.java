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

    public Cliente() {}
    
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
    
    public void setCaso(Caso caso) {
        if (casos == null)
            casos = new ArrayList();
        this.casos.add(caso);
    }

    public void setCasos(ArrayList<Caso> casos) {
        this.casos = casos;
    }

    @Override
    public String toString() {
        String ret = "cliente: "+this.getDni()+" nombre: "+this.getNombre()+" "+this.getApellido()+" telefono: "+telefono+" estuvo en el/los caso(s):\n";
        for (int x = 0;x < casos.size();x++) {
            ret += "ID: "+casos.get(x).getID()+" fecha de inicio: "+casos.get(x).getJuicioInicio().toString()+" estado: "+casos.get(x).getEstado()+" llevado por los abogados:\n";
            for (int y = 0;y < casos.get(x).getAbogadoCargo().size(); y++) {
                ret += "dni: "+casos.get(x).getAbogadoCargo().get(y).getDni()+" nombre: "+casos.get(x).getAbogadoCargo().get(y).getNombre();
            }
        }
        return ret;
    }
    
}
