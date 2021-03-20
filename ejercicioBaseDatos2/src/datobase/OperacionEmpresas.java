/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datobase;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;

/**
 *
 * @author txaber
 */
public class OperacionEmpresas {
    
    private Conexion con;

    public OperacionEmpresas(Conexion con) {
        this.con = con;
    }
    
    public Empresa comprobarEmpresa(String nombre) {
        
        try {
            con.conectar();
            PreparedStatement ps = con.getCon().prepareStatement("SELECT * FROM empresas WHERE nombre = ?;");
            ps.setString(1, nombre);
            
            ResultSet res = ps.executeQuery();
            
            res.next();
            Empresa e =  new Empresa(res.getString("nombre"),res.getInt("CNAE"));
            con.desconectar();
            return e;
            
        } catch (SQLException ex) {
            Logger.getLogger(OperacionEmpresas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void altaEmpresa(Empresa e) {
        try {
            con.conectar();
            
            PreparedStatement ps = con.getCon().prepareStatement("INSERT INTO empresas VALUES(?,?)");
            ps.setString(1, e.getNombre());
            ps.setInt(2, e.getCNAE());
        
            ps.executeUpdate();
        }
        catch (MySQLIntegrityConstraintViolationException er) {
            // la empresa ya existe
        } 
        catch (SQLException ex) {
            Logger.getLogger(OperacionEmpresas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
