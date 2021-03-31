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
}
