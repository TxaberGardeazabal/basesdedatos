/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datobase;

import ejerciciobasedatos3.EjercicioBaseDatos3;
import java.util.ArrayList;
import modelo.*;
import java.sql.*;
import java.time.LocalDate;
/**
 *
 * @author txaber
 */

public class OpCasos {
    
    private Conexion con;

    public OpCasos(Conexion con) {
        this.con = con;
    }
    
    public ArrayList<Caso> consultaCasosPorDniCli(String dni) throws Exception {
        
        ArrayList<Caso> lista = new ArrayList();
        con.conectar();
        
        PreparedStatement s = con.getCon().prepareStatement("SELECT * FROM `casos_juicios` WHERE cliente = ?;");
        s.setString(1, dni);
        ResultSet res = s.executeQuery();
        
        while (res.next()) {
            Caso c = new Caso();
            c.setID(res.getInt("ID"));
            c.setJuicioInicio(res.getDate("juicioInicio").toLocalDate());
            c.setJuicioFin(res.getDate("juicioFin").toLocalDate());
            c.setEstado(res.getString("estado"));
            c.setAbogadosCargo(EjercicioBaseDatos3.consultaAbogadosPorCaso(res.getInt("ID")));
            
            lista.add(c);
        }
        
        con.desconectar();
        return lista;
    }
    
    public Caso consultaCasosPorID(String ID) throws Exception{
        con.conectar();
        
        PreparedStatement ps = con.getCon().prepareStatement("SELECT * FROM `casos_juicios` WHERE ID = ?");
        ps.setInt(1, Integer.parseInt(ID));
        ResultSet res = ps.executeQuery();
        
        res.next();
        Caso cs = new Caso();
        cs.setID(Integer.parseInt(ID));
        cs.setJuicioInicio(res.getDate("juicioInicio").toLocalDate());
        cs.setEstado(res.getString("estado"));
        
        cs.setCliente(EjercicioBaseDatos3.consultaClientePorDniv2(res.getString("cliente"), false));
        cs.setAbogadosCargo(EjercicioBaseDatos3.consultaAbogadosPorCaso(Integer.parseInt(ID)));
        
        if (res.getDate("juicioFin") != null) {
            cs.setJuicioFin(res.getDate("juicioFin").toLocalDate());
        }
        
        con.desconectar();
        return cs;
    }
    
    public String getMaxID() throws Exception {
        con.conectar();
        
        Statement s = con.getCon().createStatement();
        ResultSet res = s.executeQuery("SELECT MAX(ID) FROM `casos_juicios`");
        res.next();
        
        String a = String.valueOf(res.getInt(1) + 1);
        con.desconectar();
        return a;
    }

    public void altaCaso(Caso s) throws Exception{
        con.conectar();
        
        PreparedStatement ps = con.getCon().prepareStatement("INSERT INTO `casos_juicios` VALUES (?,?,null,?,?)");
        ps.setInt(1, s.getID());
        ps.setDate(2, java.sql.Date.valueOf(s.getJuicioInicio()));
        ps.setString(3, s.getEstado());
        ps.setString(4, s.getCliente().getDni());
        ps.executeUpdate();
        
        con.desconectar();
        
    }

    public void bajaCasos(int ID) throws Exception{
        con.conectar();
        
        PreparedStatement ps = con.getCon().prepareStatement("DELETE FROM `casos_juicios` WHERE ID = ?");
        ps.setInt(1, ID);
        ps.executeUpdate();
        
        con.desconectar();
    }

    public void terminarCasos(int ID, LocalDate fechaFin, String estado) throws Exception{
        con.conectar();
        
        PreparedStatement ps = con.getCon().prepareStatement("UPDATE `casos_juicios` SET juicioFin = ?, estado = ? WHERE ID = ?;");
        ps.setDate(1, java.sql.Date.valueOf(fechaFin));
        ps.setString(2, estado);
        ps.setInt(3, ID);
        ps.executeUpdate();
        
        con.desconectar();
    }
    
    public ArrayList<Caso> consultaTodo() throws Exception{
        ArrayList<Caso> ret = new ArrayList();
        con.conectar();
        
        PreparedStatement ps = con.getCon().prepareStatement("SELECT * FROM `casos_juicios`");
        ResultSet res = ps.executeQuery();
        
        while (res.next()) {
            Caso c = new Caso();
            c.setID(res.getInt("ID"));
            c.setJuicioInicio(res.getDate("juicioInicio").toLocalDate());
            c.setEstado(res.getString("estado"));
            if (res.getDate("juicioFin") != null) {
                c.setJuicioFin(res.getDate("juicioFin").toLocalDate());
            }
            
            c.setCliente(EjercicioBaseDatos3.consultaClientePorDniv2(res.getString("cliente"), false));
            ret.add(c);
        }
        
        con.desconectar();
        return ret;
    }
}
