/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datoBase;

import java.sql.*;
/**
 *
 * @author txaber
 */
public class BaseDatos {
    
    private Connection con;

    public BaseDatos() {
    }

    public Connection getCon() {
        return con;
    }
    
    public void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String bd="ejercicio1";
            String url = "jdbc:mysql://localhost:3306/"+bd;
            String login="root";
            String password = "usbw";
            con = DriverManager.getConnection(url,login,password);
            
            if (con==null){
                       throw new Exception("Problemas con la conexión");
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void desconectar() {
        try {
            con.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
