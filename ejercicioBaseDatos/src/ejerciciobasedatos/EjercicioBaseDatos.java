/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobasedatos;

/**
 *
 * @author txaber
 */

import vista.*;
import modelo.*;
import datoBase.*;
import java.util.ArrayList;

public class EjercicioBaseDatos {

    private static BaseDatos bd;
    private static OperacionPersonas oPersona;
    
    private static VentanaMenu vm;
    private static VentanaOperacion vo;
    
    private static Persona pMem;
    
    public static void main(String[] args) {
        try {
            bd = new BaseDatos();
            bd.conectar();
            
            oPersona = new OperacionPersonas(bd.getCon());
            
            vm = new VentanaMenu();
            vm.setVisible(true);
        }
        catch (Exception e) {
            bd.desconectar();
            System.out.println(e.getMessage());
        }
    }
    
    public static void alta() {
        vm.setVisible(false);
        
        vo = new VentanaOperacion();
        vo.setVisible(true);
    }
    
    public static boolean validarPersona(String p){
    return true;}
    
    public static void insertar(String nombre, int edad, String profesion, int telefono) throws Exception{
        Persona p = new Persona(nombre,edad,profesion,telefono);
        
        oPersona.registrar(p);
    }
    
    public static void consultaIndividual(String nombre) throws Exception{
        Persona per = oPersona.consultaIndividual(nombre);
        
        vm.setVisible(false);
        vo = new VentanaOperacion(per);
        vo.setVisible(true);
    }
    
    public static void consulta() throws Exception{
        ArrayList<Persona> lista = oPersona.consulta();
        
        vm.setVisible(false);
        vo = new VentanaOperacion(lista);
        vo.setVisible(true);
    }
    
    public static void salir() {
        vm.dispose();
    }
    
    public static void volver() {
        vo.dispose();
        vm.setVisible(true);
    }
    
}
