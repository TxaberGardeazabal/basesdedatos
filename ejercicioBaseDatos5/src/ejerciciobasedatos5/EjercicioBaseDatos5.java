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
import datobase.exceptions.PreexistingEntityException;
import excepciones.*;
import java.time.Instant;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class EjercicioBaseDatos5 {

    private static EmpresaJpaController oEmpresas;
    private static EventoJpaController oEventos;
    private static PersonaJpaController oPersonas;
    
    private static Vmenu vm;
    private static Veventos ve;
    private static Vasistencia va;
    private static Vlista vl;
    
    private static Evento e;
    private static Persona p;
    
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
        catch (Exception s) {
            System.out.println(s.getCause());
        }
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

    public static void listaEventos(JComboBox<String> cbEventos) throws Exception{
        // haria falta validar los eventos y restringir los que no se pueden unir
        List<Evento> lista = oEventos.findEventoEntities();
        
        if (lista == null) 
            throw new FilaNoEncontrada();
        for (int x = 0;x < lista.size(); x++) {
            cbEventos.addItem(lista.get(x).getNombre());
        }
        
    }
    
    public static void listaAsistentes(JTextArea taAsistentes, String nevento) throws Exception{
        taAsistentes.setText("");
        String texto = "evento: "+nevento+"\n";
        
        Evento evento = oEventos.findEvento(nevento);
        List<Persona> asistentes = evento.getPersonaList();
        if (asistentes.isEmpty())
            throw new FilaNoEncontrada();
        
        for (int x = 0;x < asistentes.size(); x++) {
            texto += "asiste: "+asistentes.get(x).getDni()+" nombre: "+asistentes.get(x).getNombre()+"\n";
        }
        taAsistentes.setText(texto);
    }

    public static boolean comprobarPersona(String dni) {
        p = null;
        p = oPersonas.findPersona(dni);
        
        if (p == null) {
            return false;
        }
        return true;
    }

    public static String getNombre() {
        return p.getNombre();
    }

    public static int getEdad() {
        return p.getEdad();
    }

    public static int getTelefono() {
        return p.getTelefono();
    }

    public static String getNombreEmpresa() {
        return p.getEmpresa().getNombre();
    }

    public static int getCNAEEmpresa() {
        return p.getEmpresa().getCnae();
    }

    public static void procesoAsistencia(String nomEvento) throws Exception{
        
        Evento ev = rebuscarEvento(nomEvento);
        
        for (Persona per : ev.getPersonaList()) {
            if (per.equals(p))
                throw new PreexistingEntityException("se encontro la misma persona durante la busqueda");
        }
        ev.getPersonaList().add(p);
        oEventos.edit(ev);
    }

    public static void procesoAsistencia(String nomEvento, String dni, String nombre, int edad, int telefono, String nomEmpresa, int cnae) throws Exception{
        
        Evento ev = rebuscarEvento(nomEvento);
        
        Empresa emp = crearEmpresa(nomEmpresa,cnae);
        
        Persona per = new Persona(dni,nombre,edad,telefono);
        per.setEventoList(new ArrayList<Evento>());
        per.getEventoList().add(ev);
        per.setEmpresa(emp);
        
        oPersonas.create(per);
    }
    
    public static Evento rebuscarEvento(String nomEvento) throws Exception {
        List<Evento> listaEvento = oEventos.findEventoEntities();
        Evento ev = null;
        // buscar el evento
        for (int x = 0;x < listaEvento.size() && ev == null;x++) {
            if (listaEvento.get(x).getNombre().equals(nomEvento)) {
                ev = listaEvento.get(x);
            }
        }
        return ev;
    }

    private static Empresa crearEmpresa(String nomEmpresa, int cnae) throws Exception{
        
        Empresa emp = new Empresa(nomEmpresa,cnae);
        boolean nuevo = true;
        
        List<Empresa> listaEmpresa = oEmpresas.findEmpresaEntities();
        for (Empresa empresa : listaEmpresa) {
            if (empresa.equals(emp))
                nuevo = false;
        }
        
        if (nuevo)
            oEmpresas.create(emp);
        
        return emp;
    }
    
    public static void vEvento() {
        ve = new Veventos(vm, true);
        ve.setVisible(true);
    }
    
    public static void vAsistencia() {
        va = new Vasistencia(vm,true);
        va.setVisible(true);
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
    
    public static void vListado() {
        vl = new Vlista(vm,true);
        vl.setVisible(true);
    }
    
    public static void salir() {
        vm.dispose();
    }

}
