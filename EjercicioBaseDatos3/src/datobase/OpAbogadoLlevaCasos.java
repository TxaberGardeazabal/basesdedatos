/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datobase;

import modelo.*;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author txaber
 */
public class OpAbogadoLlevaCasos {
    
    private Conexion con;

    public OpAbogadoLlevaCasos(Conexion con) {
        this.con = con;
    }
    
    public ArrayList<Abogado> consultaAbogadosPorCaso(int ID) throws Exception{
        
        ArrayList<Abogado> lista = new ArrayList();
        con.conectar();
        
        PreparedStatement s = con.getCon().prepareStatement("SELECT ab.dni, ab.nombre, ab.apellidos FROM `abogadollevacasos` ac, `abogados` ab WHERE ac.ID = ? AND ac.dni = ab.dni");
        s.setInt(1, ID);
        ResultSet res = s.executeQuery();
        
        while(res.next()) {
            Abogado  ab = new Abogado();
            ab.setDni(res.getString("dni"));
            ab.setNombre(res.getString("nombre"));
            ab.setApellido(res.getString("apellidos"));
            
            lista.add(ab);
        }
        con.desconectar();
        return lista;
    }

    public void asignar(String dni, Integer id) throws Exception{
        con.conectar();
        
        PreparedStatement ps = con.getCon().prepareStatement("INSERT INTO `abogadollevacasos` VALUES (?,?);");
        ps.setInt(1, id);
        ps.setString(2, dni);
        ps.executeUpdate();
        
        con.desconectar();
    }

    public ArrayList<Caso> consultaCasosPorAbogado(String dni) throws Exception{
        ArrayList<Caso> lista = new ArrayList();
        con.conectar();
        
        PreparedStatement ps = con.getCon().prepareStatement("SELECT ca.ID, ca.juicioInicio, ca.JuicioFin, ca.estado, ca.cliente FROM `abogadollevacasos` ac, `casos_juicios` ca WHERE ac.dni = ? AND ac.ID = ca.ID;");
        ps.setString(1, dni);
        ResultSet res = ps.executeQuery();
        
        while (res.next()){
            Caso c = new Caso();
            c.setID(res.getInt("ID"));
            c.setJuicioInicio(res.getDate("juicioInicio").toLocalDate());
            c.setEstado(res.getString("estado"));
            if (!(res.getDate("juicioFin") == null))
                c.setJuicioFin(res.getDate("juicioFin").toLocalDate());
            
            lista.add(c);
        }
        
        con.desconectar();
        return lista;
    }
}
