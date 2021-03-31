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
import modelo.*;
import java.sql.*;
import excepciones.*;
import java.util.ArrayList;
import ejerciciobasedatos3.EjercicioBaseDatos3;
public class OpClientes {
    
    private Conexion con;

    public OpClientes(Conexion con) {
        this.con = con;
    }
    
    public void altaCliente(Cliente cli) throws Exception{
        
        con.conectar();
        
        PreparedStatement ps = con.getCon().prepareStatement("INSERT INTO clientes VALUES (?, ?, ?, ?, ?, ?);");
        ps.setString(1, cli.getDni());
        ps.setString(2, cli.getNombre());
        ps.setString(3, cli.getApellido());
        ps.setString(4, cli.getDireccion());
        ps.setString(5, cli.getTelefono());
        ps.setString(6, cli.getCorreo());
        
        ps.executeUpdate();
        
        con.desconectar();
    }
    
    public void modificarCliente(Cliente cli) throws Exception {
        
        con.conectar();
        
        PreparedStatement ps = con.getCon().prepareStatement("UPDATE clientes set "
                                                            + "nombre = ?, apellidos = ?, direccion = ?, telefono = ?, correo = ? "
                                                            + "WHERE dni = ?;");
        
        ps.setString(1, cli.getNombre());
        ps.setString(2, cli.getApellido());
        ps.setString(3, cli.getDireccion());
        ps.setString(4, cli.getTelefono());
        ps.setString(5, cli.getCorreo());
        ps.setString(6, cli.getDni());
        
        ps.executeUpdate();
        
        con.desconectar();
    }
    
    public void bajaCliente(String dni) throws Exception{
        
        con.conectar();
        PreparedStatement ps = con.getCon().prepareStatement("DELETE FROM clientes WHERE dni = ?;");
        ps.setString(1, dni);
        ps.executeUpdate();
        con.desconectar();
    }
    
    public Cliente consultaUno(String dni, boolean casos) throws Exception{
        
        con.conectar();
        Cliente c;
        
        PreparedStatement ps = con.getCon().prepareStatement("SELECT * FROM clientes WHERE dni = ?;");
        ps.setString(1, dni);
        
        ResultSet res = ps.executeQuery();
        
        if (res.next()) {
            c = new Cliente(dni,res.getString("nombre"),res.getString("apellidos"),res.getString("direccion"),res.getString("telefono"),res.getString("correo"));
            
            if (casos) {
                c.setCasos(EjercicioBaseDatos3.consultaCasosPorDniCli(dni));
            }
        }
        else {
            con.desconectar();
            return null;
        }
        
        con.desconectar();
        return c;
    }

    public ArrayList<Cliente> consultaTodo() throws Exception{
        
        con.conectar();
        ArrayList<Cliente> li = new ArrayList();
        
        Statement s = con.getCon().createStatement();
        
        ResultSet res = s.executeQuery("SELECT * FROM clientes");
        
        while(res.next()) {
            Cliente c = new Cliente();
            c.setDni(res.getString("dni"));
            c.setNombre(res.getString("nombre"));
            c.setApellido(res.getString("apellidos"));
            c.setDireccion(res.getString("direccion"));
            c.setTelefono(res.getString("telefono"));
            c.setCorreo(res.getString("correo"));
            
            li.add(c);
        }
        con.desconectar();
        return li;
    }
}

