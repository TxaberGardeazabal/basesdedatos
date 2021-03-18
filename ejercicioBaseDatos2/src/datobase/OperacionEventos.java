/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datobase;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;
import excepciones.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author txaber
 */

public class OperacionEventos {

    private Conexion con;

    public OperacionEventos(Conexion con) {
        this.con = con;
    }
    
    // añadir un nuevo evento a la base de datos
    public void altaEvento(Evento ev) throws Exception{
        
        try {
            con.conectar();
        
            PreparedStatement ps = con.getCon().prepareStatement("INSERT INTO eventos VALUES(?,?,?,?,?,?)");
            ps.setString(1, ev.getNombre());
            ps.setString(2, ev.getLugar());
            ps.setDate(3, java.sql.Date.valueOf(ev.getFecha()));
            ps.setTime(4, java.sql.Time.valueOf(ev.getHoraInicio()));
            ps.setTime(5, java.sql.Time.valueOf(ev.getHoraFin()));
            ps.setInt(6, ev.getMaxAsistencia());
            
            int a = ps.executeUpdate();
            if (a == 0) 
                throw new ErrorBaseDatos();
                
            con.desconectar();
            
        } catch (SQLException ex) {
            con.desconectar();
            System.out.println(ex.getClass() +"problema con SQL");
        }
    }
    
    // borrar un evento de la base de datos
    // devuelve las filas que han sido eliminadas
    public int borrarEvento(String nombre) {
        
        try {
            con.conectar();
            
            PreparedStatement ps = con.getCon().prepareStatement("DELETE FROM eventos WHERE nombre = ?");
            ps.setString(1, nombre);
            
            int ret = ps.executeUpdate();
            
            con.desconectar();
            return ret;
            
        } catch (SQLException ex) {
            con.desconectar();
            Logger.getLogger(OperacionEventos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    // modificar los datos de un evento existente
    // recibe el nombre y los datos a cambiar
    // devuelve el numero de filas cambiadas
    public int modificarEvento(Evento e)  {
        
        try {
            con.conectar();
            
            PreparedStatement ps = con.getCon().prepareStatement("UPDATE eventos SET lugar = ?, fecha = ?, horaInicio = ?, horaFin = ?, maxAsistencia = ? WHERE nombre = ?");
            ps.setString(1, e.getLugar());
            ps.setDate(2, java.sql.Date.valueOf(e.getFecha()));
            ps.setTime(3, java.sql.Time.valueOf(e.getHoraInicio()));
            ps.setTime(4, java.sql.Time.valueOf(e.getHoraFin()));
            ps.setInt(5, e.getMaxAsistencia());
            ps.setString(6, e.getNombre());
            
            int ret = ps.executeUpdate();
            con.desconectar();
            return ret;
        }
        catch (SQLException ex) {
            con.desconectar();
                Logger.getLogger(OperacionEventos.class.getName()).log(Level.SEVERE, null, ex);
            }
        return 0;
    }
    
    // consulta para saber si existe tal evento
    // recibe el nombre del evento a consultar
    // devuelve true si a encontrado una fila con ese nombre, false si no encuentra nada
    public boolean consultar(String nombre) {
        
        try {
            con.conectar();
            
            PreparedStatement ps = con.getCon().prepareStatement("SELECT * FROM eventos WHERE nombre = ?;");
            ps.setString(1, nombre);
            
            ResultSet res = ps.executeQuery();
            boolean ret = res.next();
            
            con.desconectar();
            
            return ret;
            
        } catch (SQLException ex) {
            con.desconectar();
            Logger.getLogger(OperacionEventos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    // consulta para obtener los datos de un evento
    // recibe el nombre del evento a consultar
    // devuelve todos los datos del evento encontrado
    public Evento consultaV2(String nombre) {
        
        try {
            con.conectar();
            
            PreparedStatement ps = con.getCon().prepareStatement("SELECT * FROM eventos WHERE nombre = ?;");
            ps.setString(1, nombre);
            
            ResultSet res = ps.executeQuery();
            res.next();
            
            Evento ret = new Evento(
                    res.getString("nombre"),
                    res.getString("lugar"),
                    res.getDate("fecha").toLocalDate(),
                    res.getTime("horaInicio").toLocalTime(),
                    res.getTime("horaFin").toLocalTime(),
                    res.getInt("maxAsistencia"));
            
            con.desconectar();
            
            return ret;
            
        } catch (SQLException ex) {
            con.desconectar();
            Logger.getLogger(OperacionEventos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    // consultar todos los datos en la tabla eventos
    // devuelve una lista con todas las filas de la tabla
    public ArrayList<Evento> consultaTodo() {
        
        try {
            ArrayList<Evento> lista = new ArrayList();
            con.conectar();
            
            PreparedStatement ps = con.getCon().prepareStatement("SELECT * FROM eventos WHERE fecha > ?;");
            ps.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
            ResultSet res = ps.executeQuery();
            
            while (res.next()) {
                
                lista.add(new Evento(
                    res.getString("nombre"),
                    res.getString("lugar"),
                    res.getDate("fecha").toLocalDate(),
                    res.getTime("horaInicio").toLocalTime(),
                    res.getTime("horaFin").toLocalTime(),
                    res.getInt("maxAsistencia")));
                    
            }
            return lista;
        }
        catch (SQLException ex) {
            con.desconectar();
            Logger.getLogger(OperacionEventos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
