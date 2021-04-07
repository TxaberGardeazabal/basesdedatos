/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datobase;

import java.util.ArrayList;
import java.sql.*;
import modelo.*;
import ejerciciobasedatos3.EjercicioBaseDatos3;
/**
 *
 * @author txaber
 */
public class OpAbogados {
    
    private Conexion con;

    public OpAbogados(Conexion con) {
        this.con = con;
    }
    
    public void altaAbogado(Abogado abo) throws Exception{
        
        con.conectar();
        
        PreparedStatement ps = con.getCon().prepareStatement("INSERT INTO abogados VALUES (?, ?, ?, ?);");
        ps.setString(1, abo.getDni());
        ps.setString(2, abo.getNombre());
        ps.setString(3, abo.getApellido());
        ps.setString(4, abo.getDireccion());
        
        ps.executeUpdate();
        
        con.desconectar();
    }
    
    public void modificarAbogado(Abogado abo) throws Exception {
        
        con.conectar();
        
        PreparedStatement ps = con.getCon().prepareStatement("UPDATE abogados set "
                                                            + "nombre = ?, apellidos = ?, direccion = ? "
                                                            + "WHERE dni = ?;");
        
        ps.setString(1, abo.getNombre());
        ps.setString(2, abo.getApellido());
        ps.setString(3, abo.getDireccion());
        ps.setString(4, abo.getDni());
        
        ps.executeUpdate();
        
        con.desconectar();
    }
    
    public void bajaAbogado(String dni) throws Exception{
        
        con.conectar();
        PreparedStatement ps = con.getCon().prepareStatement("DELETE FROM abogados WHERE dni = ?;");
        ps.setString(1, dni);
        ps.executeUpdate();
        con.desconectar();
    }
    
    public ArrayList<Abogado> consultaTodo() throws Exception{
        ArrayList<Abogado> listaRet = new ArrayList();
        con.conectar();
        
        Statement s  = con.getCon().createStatement();
        ResultSet res = s.executeQuery("SELECT * FROM abogados");
        
        while (res.next()) {
            listaRet.add(new Abogado(res.getString("dni"),res.getString("nombre"),res.getString("apellidos"),res.getString("direccion")));
        }
        con.desconectar();
        return listaRet;
    }
    
    public Abogado consultaUno(String dni, boolean casos) throws Exception{
        Abogado a;
        con.conectar();
        
        PreparedStatement ps = con.getCon().prepareStatement("SELECT * FROM abogados WHERE dni = ?;");
        ps.setString(1, dni);
        ResultSet res = ps.executeQuery();
        
        res.next();
        a = new Abogado(res.getString("dni"),res.getString("nombre"),res.getString("apellidos"),res.getString("direccion"));
        if(casos) {
            // buscar casos
        }
        
        con.desconectar();
        return a;
    }
}
