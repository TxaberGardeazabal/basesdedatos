/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datobase;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author txaber
 */
public class Conexion {
    
    private Connection con;

    public Conexion(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }
    
    public void conectar() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio3","root","usbw");
            if (con == null)
                throw new Exception("Problemas en la conexion");
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void desconectar() {
        try {
            con.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }
}
