/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobasedatos5;

/**
 *
 * @author txaber
 */

import modelo.*;
import vista.*;
import datobase.*;
import java.time.Instant;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import javax.persistence.Persistence;

public class EjercicioBaseDatos5 {

    private static EmpresaJpaController oEmpresas;
    private static EventoJpaController oEventos;
    private static PersonaJpaController oPersonas;
    
    private static Vmenu vm;
    private static Veventos ve;
    private static Vasistencia va;
    private static Vlista vl;
    
    private static Evento e;
    
    public static ZoneId defaultZoneId = ZoneId.systemDefault();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            oEmpresas = new EmpresaJpaController(Persistence.createEntityManagerFactory("ejercicioBaseDatos5PU"));
            oEventos = new EventoJpaController(Persistence.createEntityManagerFactory("ejercicioBaseDatos5PU"));
            oPersonas = new PersonaJpaController(Persistence.createEntityManagerFactory("ejercicioBaseDatos5PU"));
            
            vm = new Vmenu();
            vm.setVisible(true);
        }
        catch (Exception e) {
            System.out.println(e.getCause());
        }
    }
    
    public static void vEvento() {
        ve = new Veventos(vm, true);
        ve.setVisible(true);
    }
    
    public static void vAsistencia() {
        va = new Vasistencia(vm,true);
        va.setVisible(true);
    }
    
    public static void vListado() {
        vl = new Vlista(vm,true);
        vl.setVisible(true);
    }
    
    public static void salir() {
        vm.dispose();
    }

    public static void altaEventos(String nom, String lugar, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, int max) throws Exception{
        
        //LocalDate nulo = LocalDate.of(0000, 1, 1);
        //LocalDateTime horaInicioDT = LocalDateTime.of(nulo, horaInicio);
        //LocalDateTime horaFinDT = LocalDateTime.of(nulo, horaFin);
        
        Instant instant = horaInicio.atDate(LocalDate.of(2000, 1, 1)).
        atZone(defaultZoneId).toInstant();
        Date horaInicioD = Date.from(instant);
        
        instant = horaFin.atDate(LocalDate.of(2000, 1, 1)).
                atZone(defaultZoneId).toInstant();
        Date horaFinD = Date.from(instant);
        
        Date fechaD = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
        //Date horaInicioD = Date.from(horaInicioDT.atZone(defaultZoneId).toInstant());
        //Date horaFinD = Date.from(horaFinDT.atZone(defaultZoneId).toInstant());
        
        Evento e = new Evento(nom,lugar,fechaD,horaInicioD,horaFinD,max);
        oEventos.create(e);
    }

    public static void modificarEvento(String lugar, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, int max) throws Exception{
        Instant instant = horaInicio.atDate(LocalDate.of(2000, 1, 1)).
        atZone(defaultZoneId).toInstant();
        Date horaInicioD = Date.from(instant);
        
        instant = horaFin.atDate(LocalDate.of(2000, 1, 1)).
                atZone(defaultZoneId).toInstant();
        Date horaFinD = Date.from(instant);
        
        Date fechaD = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        e.setLugar(lugar);
        e.setFecha(fechaD);
        e.setHoraInicio(horaInicioD);
        e.setHoraFin(horaFinD);
        e.setMaxAsistencia(max);
        
        oEventos.edit(e);
    }
    
    public static void borrarEvento (String nombre) throws Exception{
        oEventos.destroy(nombre);
    }

    public static boolean buscarEvento(String nombre) {
        e = oEventos.findEvento(nombre);
        if (e == null)
            return false;
        
        return true;
    }

    public static void vOperacionConDatos(String nombre) {
        
        LocalDate fecha = e.getFecha().toInstant().atZone(defaultZoneId).toLocalDate();
        LocalTime horaInicioT = LocalDateTime.ofInstant(e.getHoraInicio().toInstant(), defaultZoneId).toLocalTime();
        LocalTime horaFinT = LocalDateTime.ofInstant(e.getHoraFin().toInstant(), defaultZoneId).toLocalTime();
        
        ve = new Veventos (vm,true,
            e.getNombre(),
            e.getLugar(),
            fecha,
            horaInicioT,
            horaFinT,
            e.getMaxAsistencia());
        ve.setVisible(true);
    }

}
