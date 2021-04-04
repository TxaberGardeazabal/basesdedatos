/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobasedatos3;

import modelo.*;
import vista.*;
import datobase.*;
import excepciones.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author txaber
 */
public class EjercicioBaseDatos3 {

    /**
     * declarar variables globales
     */
    // conexion a base de datos
    private static Conexion con;
    
    // objetos con sentencias para base de datos
    private static OpClientes Ocliente;
    private static OpCasos Ocasos;
    private static OpAbogados Oabogados;
    private static OpAbogadoLlevaCasos OabogadoCasos;
    
    // objetos de memoria
    private static Cliente cl;
    private static Abogado ab;
    private static Caso ca;
    private static ArrayList<Cliente> listaCl;
    private static ArrayList<Abogado> listaAb;
    private static ArrayList<Caso> listaC;
    
    // ventanas
    private static Vprincipal vp;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            con = new Conexion();
            
            Ocliente = new OpClientes(con);
            Oabogados = new OpAbogados(con);
            Ocasos = new OpCasos(con);
            OabogadoCasos = new OpAbogadoLlevaCasos(con);
            
            vp = new Vprincipal();
            vp.setVisible(true);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    }
    
    public static void altaCliente(String dni, String n, String a, String d, String c, String t) throws Exception {
        // creo cliente
        Cliente cli = new Cliente(dni,n,a,d,t,c);
        
        // alta cliente
        Ocliente.altaCliente(cli);
    }
    
    public static void modificarCliente(String dni, String n, String a, String d, String c, String t,boolean casos) throws Exception {
        // se prueba si existe
        Cliente p = Ocliente.consultaUno(dni,casos);
        if (p == null) {
            throw new FilaNoEncontrada();
        }
        
        // creo cliente
        Cliente cli = new Cliente(dni,n,a,d,t,c);
        
        // modificar cliente
        Ocliente.modificarCliente(cli);
    }
    
    public static void bajaCliente() throws Exception {
        Ocliente.bajaCliente(cl.getDni());
    }
    
    public static void consultaClientePorDni(String dni,boolean casos) throws Exception{
        cl = Ocliente.consultaUno(dni,casos);
        if (cl == null)
            throw new FilaNoEncontrada();
    }
    
    public static Cliente consultaClientePorDniv2(String dni,boolean casos) throws Exception{
        Cliente c = Ocliente.consultaUno(dni,casos);
        if (c == null)
            throw new FilaNoEncontrada();
        return c;
    }
    
    public static void consultaTodoCliente() throws Exception{
        listaCl = Ocliente.consultaTodo();
        if (listaCl == null)
            throw new TablaVacia();
    }
    
    public static ArrayList<Caso> consultaCasosPorDniCli(String dni) throws Exception{
        return Ocasos.consultaCasosPorDniCli(dni);
    }
    
    public static ArrayList<Abogado> consultaAbogadosPorCaso(int ID) throws Exception{
        return OabogadoCasos.consultaAbogadosPorCaso(ID);
    }
    
    public static void textoClientes(javax.swing.JTextArea texto) {
        texto.setText(cl.toString());
    }
    
    public static String buscarIDSiguiente() throws Exception{
        // 
        String ret = Ocasos.getMaxID();
        if (ret == null)
            ret = "";
        return ret;
    }
    
    public static void consultaCasosPorID(String ID) throws Exception{
        ca = Ocasos.consultaCasosPorID(ID);
    }
    
    public static void llenarListaAbogados(javax.swing.JList<String> lista) throws Exception{
        listaAb = Oabogados.consultaTodo();
        if (listaAb == null) {
            // no hay abogados
            throw new FilaNoEncontrada();
        }
        
        javax.swing.DefaultListModel modelo = new javax.swing.DefaultListModel();
        for (int x = 0;x < listaAb.size(); x++) {
            modelo.add(x, listaAb.get(x).getNombre()+" "+listaAb.get(x).getApellido());
        }
        lista.setModel(modelo);
    }
    
    public static void llenarDatosCaso(javax.swing.JTextArea lista) {
        lista.setText(ca.toString());
    }
    
    public static void altaCaso(String ID, String fecha, String estado, int[] abogados) throws Exception{
        
        DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaIn = LocalDate.parse(fecha, form);
        
        Caso s = new Caso();
        s.setID(Integer.parseInt(ID));
        s.setJuicioInicio(fechaIn);
        s.setEstado(estado);
        s.setCliente(cl);
        Ocasos.altaCaso(s);
        
        for (int x = 0; x < abogados.length;x++) {
            OabogadoCasos.asignar(listaAb.get(abogados[x]).getDni(),s.getID());
        }
    }
    
    public static void bajaCasos() throws Exception{
        Ocasos.bajaCasos(ca.getID());
    }
    
    public static void terminarCaso(String ID, String fechaFin, String estado) throws Exception{
        DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaIn = LocalDate.parse(fechaFin, form);
        
        Ocasos.terminarCasos(Integer.parseInt(ID),fechaIn,estado);
    }

    public static void llenarCB (javax.swing.JComboBox<String> caja) throws Exception{
        listaC = Ocasos.consultaTodo();
        
        for (int x = 0;x < listaC.size();x++) {
            caja.insertItemAt(String.valueOf(listaC.get(x).getID()), x);
        }
    }
    
    // datos de los clientes en memoria
    public static String getDniCli(int pos) {
        return listaCl.get(pos).getDni();
    }
    
    public static String getNombreCli(int pos) {
        return listaCl.get(pos).getNombre();
    }
    
    public static String getApellidosCli(int pos) {
        return listaCl.get(pos).getApellido();
    }
    
    public static String getDireccionCli(int pos) {
        return listaCl.get(pos).getDireccion();
    }
    
    public static String getTelefonoCli(int pos) {
        return listaCl.get(pos).getTelefono();
    }
    
    public static String getCorreoCli(int pos) {
        return listaCl.get(pos).getCorreo();
    }
    
    public static int getCantidadCli() {
        return listaCl.size();
    }

    // datos del cliente en memoria
    public static String getDniCli() {
        return cl.getDni();
    }
    
    public static String getNombreCli() {
        return cl.getNombre();
    }
    
    public static String getApellidosCli() {
        return cl.getApellido();
    }
    
    public static String getDireccionCli() {
        return cl.getDireccion();
    }
    
    public static String getTelefonoCli() {
        return cl.getTelefono();
    }
    
    public static String getCorreoCli() {
        return cl.getCorreo();
    }
    
    // datos de caso en memoria
    public static String getEstadoCaso() {
        return ca.getEstado();
    }
    
    public static String getFechaInicioCaso(int pos) {
        return listaC.get(pos).getJuicioInicio().toString();
    }
    
    public static String getCliCaso(int pos) {
        return listaC.get(pos).getCliente().getDni();
    }
    
    public static void salir() {
        System.exit(0);
    } 
}
