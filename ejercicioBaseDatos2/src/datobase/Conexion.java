/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datobase;

/**
 *
 * @author txaber
 */
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author txaber
 */
public class Conexion {
    
    private Connection con;

    public Conexion() {
    }

    public Connection getCon() {
        return con;
    }
    
    public void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String bd="ejercicio2";
            String url = "jdbc:mysql://localhost:3306/"+bd;
            String login="root";
            String password = "usbw";
            con = DriverManager.getConnection(url,login,password);
            if (con == null) 
                throw new Exception("problemas con la conexion");
        }
        catch(Exception e) {
            System.out.println(e.getCause());
        } 
    }
    
    public void desconectar() {
        try {
            con.close();
        }
        catch (Exception e) {
            System.out.println("problemas cerrando la conexion");
        }
    }
}
