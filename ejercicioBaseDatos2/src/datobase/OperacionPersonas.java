/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datobase;

import java.util.ArrayList;
import modelo.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import ejerciciobasedatos2.EjercicioBaseDatos2;
/**
 *
 * @author txaber
 */
public class OperacionPersonas {
    
    private Conexion con;

    public OperacionPersonas(Conexion con) {
        this.con = con;
    }
    
    public ArrayList<Persona> listaAsistentes(String evento) {
        
        try {
            ArrayList<Persona> ret = new ArrayList();
            con.conectar();
            
            PreparedStatement ps = con.getCon().prepareStatement("SELECT dni,nombre FROM `personas` WHERE dni IN ("
                                                                + "SELECT dni FROM `persona-eventos` WHERE nombre = ?);");
            ps.setString(1, evento);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                ret.add(new Persona(res.getString("dni"),res.getString("nombre")));
                
            }
            
            con.desconectar();
            return ret;
            
        } catch (SQLException ex) {
            con.desconectar();
            Logger.getLogger(OperacionPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Persona consultaPersona(String dni) {
        try {
            con.conectar();
            PreparedStatement ps = con.getCon().prepareStatement("SELECT * FROM personas WHERE dni = ?;");
            ps.setString(1, dni);
            ResultSet res = ps.executeQuery();
            
            if (res.next()) {
                Empresa e = EjercicioBaseDatos2.comprobarEmpresa(res.getString("empresa"));
                    
                Persona p = new Persona(res.getString("dni"),res.getString("nombre"),res.getInt("edad"),res.getInt("telefono"),e);
            
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void altaPersona(Persona p) throws Exception {
        try {
            con.conectar();
            
            PreparedStatement ps = con.getCon().prepareStatement("INSERT INTO personas VALUES(?,?,?,?,?)");
            ps.setString(1, p.getDni());
            ps.setString(2, p.getNombre());
            ps.setInt(3, p.getEdad());
            ps.setInt(4, p.getTelefono());
            ps.setString(5, p.getEmpresa().getNombre());
        
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(OperacionEmpresas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        con.desconectar();
    }
}
