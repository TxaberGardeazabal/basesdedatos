/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datoBase;

import excepciones.Excepcion;
import java.sql.*;
import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author txaber
 */

public class OperacionPersonas {
    
    private Connection con;

    public OperacionPersonas(Connection con) {
        this.con = con;
    }
    
    public void registrar(Persona p) throws Exception{
        
        PreparedStatement ps = con.prepareStatement("INSERT INTO personas VALUES(?,?,?,?);");
        ps.setString(1, p.getNombre());
        ps.setInt(2, p.getEdad());
        ps.setString(3, p.getProfesion());
        ps.setInt(4, p.getTelefono());
        int r = ps.executeUpdate();
        
        if (r != 1)
            throw new Excepcion("mas de una fila ha sido insertada");
    }
    
    public Persona consultaIndividual(String nombre) throws Exception{
        
        PreparedStatement ps = con.prepareStatement("SELECT * FROM personas WHERE nombre = ?;");
        ps.setString(1, nombre);
        ResultSet res = ps.executeQuery();
        
        Persona p;
        if (res.next()) {
            p = new Persona(res.getString("nombre"),res.getInt("edad"),res.getString("profesion"),res.getInt("telefono"));
        }
        else {
            throw new Excepcion("no hay una persona con ese nombre");
        }
        return p;
    }
    
    public ArrayList<Persona> consulta() throws Exception{
        
        ArrayList<Persona> lista = new ArrayList();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM personas");
        
        ResultSet res = ps.executeQuery();
        while (res.next()) {
            Persona p = new Persona(res.getString("nombre"),res.getInt("edad"),res.getString("profesion"),res.getInt("telefono"));
            lista.add(p);
        }
        
        return lista;
    }
}
