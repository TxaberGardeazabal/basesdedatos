/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datobase;

import java.util.ArrayList;
import modelo.*;
import java.sql.*;
/**
 *
 * @author txaber
 */
public class OperacionEvtPer {
    
    private Conexion con;

    public OperacionEvtPer(Conexion con) {
        this.con = con;
    }

    public void altaAsitencia(String nombre, String dni) throws Exception {
        
            con.conectar(); 
        
            PreparedStatement ps = con.getCon().prepareStatement("INSERT INTO `persona-eventos` VALUES(?,?)");
            ps.setString(1, nombre);
            ps.setString(2, dni);
        
            ps.executeUpdate();
        
        
        con.desconectar();
    }
}
