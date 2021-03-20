/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobasedatos2;

import modelo.*;
import vista.*;
import datobase.*;
import excepciones.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author txaber
 */
/*
* demasiados accesos a la base de datos, en borrar no es necesario
* validar si existe la fila
*/
public class EjercicioBaseDatos2 {

    private static Conexion con;
    private static OperacionEventos oEventos;
    private static OperacionPersonas oPersonas;
    private static OperacionEmpresas oEmpresas;
    private static OperacionEvtPer oEvtPer;
    
    private static Vmenu vm;
    private static Veventos ve;
    private static Vasistencia va;
    private static Vlista vl;
    
    private static Evento e;
    private static Persona p;
    
    
    public static void main(String[] args) {
        try {
            con = new Conexion();
            oEventos = new OperacionEventos(con);
            oPersonas = new OperacionPersonas(con);
            oEmpresas = new OperacionEmpresas(con);
            oEvtPer = new OperacionEvtPer(con);
            
            vm = new Vmenu();
            vm.setVisible(true);
            
        }
        catch (Exception e) {
            System.out.println(e.getCause());
        }
    }
    
    public static void altaEventos(String nombre, String lugar, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, int maxPersonas) throws Exception{
        e = new Evento(nombre,lugar,fecha,horaInicio,horaFin,maxPersonas);
        
        oEventos.altaEvento(e);
    }
    
    public static int borrarEvento(String nombre) throws Exception {
        // mirar si existe la fila
        if (!oEventos.consultar(nombre))
            throw new FilaNoEncontrada();
        
        // si ya existe borrar las que haya
        return oEventos.borrarEvento(nombre);
    }
    
    public static boolean buscarEvento(String nombre) {
        // mirar si existe la fila
        return oEventos.consultar(nombre);
        
    }
    
    public static int modificarEvento(String lugar, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, int maxPersonas) throws Exception {
        // tenemos ya el nombre
        e.setLugar(lugar);
        e.setFecha(fecha);
        e.setHoraInicio(horaInicio);
        e.setHoraFin(horaFin);
        e.setMaxAsistencia(maxPersonas);
        
        return oEventos.modificarEvento(e);
    }
    
    public static void vOperacion() {
        ve = new Veventos(vm, true);
        ve.setVisible(true);
    }
    
    public static void vOperacionConDatos(String nombre) throws Exception{
        
        // mirar si existe la fila
        if (!oEventos.consultar(nombre))
            throw new FilaNoEncontrada();
        else {
            // fila existe, mostrar los datos por pantalla para modificar
            e = oEventos.consultaV2(nombre);
            ve = new Veventos (vm,true,
                e.getNombre(),
                e.getLugar(),
                e.getFecha(),
                e.getHoraInicio(),
                e.getHoraFin(),
                e.getMaxAsistencia());
            ve.setVisible(true);
        }
    }
    
    public static void listaEventos(javax.swing.JComboBox<String> lista) throws Exception{
        ArrayList<Evento> listaBD = oEventos.consultaTodo();
        
        if (listaBD == null)
            throw new FilaNoEncontrada();
        
        listaBD.forEach((evento) -> {
            lista.addItem(evento.getNombre());
        });
    }
    
    public static boolean comprobarPersona(String dni) throws Exception {
        
        p = oPersonas.consultaPersona(dni);
        
        if (p == null)
            return false;
        
        return true;
    }
    
    public static String getNombre() {return p.getNombre();}
    
    public static String getDni() {return p.getDni();}
    
    public static int getEdad() {return p.getEdad();}
    
    public static int getTelefono() {return p.getTelefono();}
    
    public static String getNombreEmpresa() {return p.getEmpresa().getNombre();}
    
    public static int getCNAEEmpresa() {return p.getEmpresa().getCNAE();}
    
    public static Empresa comprobarEmpresa(String nombre) {
        return oEmpresas.comprobarEmpresa(nombre);
    }
    
    public static void procesoAsistencia(String evento) throws Exception{
        // solo insertar en eventos-personas
        oEvtPer.altaAsitencia(evento, p.getDni());
    }
    
    public static void procesoAsistencia(String evento, String dni, String nombre, int edad, int telefono, String nombreEmp, int CNAE) throws Exception{
        // aqui se inserta la empresa (si no existe), la persona y el evento-persona
        Empresa em = new Empresa(nombreEmp,CNAE);
        p = new Persona(dni,nombre,edad,telefono,em);
        
        oEmpresas.altaEmpresa(em);
        oPersonas.altaPersona(p);
        oEvtPer.altaAsitencia(evento, p.getDni());
        
    }
    
    public static void listaAsistentes(javax.swing.JTextArea texto,String nombre) throws Exception{
        texto.setText("");
        String text = "evento: "+nombre+"\n";
        
        ArrayList<Persona> lista = oPersonas.listaAsistentes(nombre);
        
        if (lista == null)
            throw new FilaNoEncontrada();
        
        for (int x = 0;x < lista.size(); x++) {
            text += "asiste: "+lista.get(x).getDni()+" nombre "+lista.get(x).getNombre()+"\n";
        }
        
        texto.setText(text);
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
}
