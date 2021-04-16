/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciobasedatos4;

/**
 *
 * @author txaber
 */
import modelo.*;
import vista.*;
import datobase.*;
import excepciones.*;
import java.util.List;
import javax.persistence.Persistence;
public class EjercicioBaseDatos4 {

    public static PersonaJpaController personabd;
    
    public static VentanaMenu vm;
    public static VentanaOperacion vo;
    
    private static List<Persona> personas;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            personabd = new PersonaJpaController(Persistence.createEntityManagerFactory("ejercicioBaseDatos4PU"));
            
            vm = new VentanaMenu();
            vm.setVisible(true);
        }
        catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    public static void alta() {
        vm.dispose();
        
        vo = new VentanaOperacion();
        vo.setVisible(true);
    }

    public static void consultaIndividual(String p) throws Exception{
        Persona per = personabd.findPersona(p);
        if (per == null )
            throw new Excepcion("no existe la persona "+p);
        
        vm.dispose();
        vo = new VentanaOperacion(p,per.getEdad(),per.getProfesion(),per.getTelefono());
        vo.setVisible(true);
    }

    public static void consulta() throws Exception{
        personas = null;
        personas = personabd.findPersonaEntities();
        if (personas == null) {
            throw new Excepcion("no hay personas en la base de datos");
        }
        
        vm.dispose();
        vo = new VentanaOperacion(personas.size());
        vo.setVisible(true);
    }

    public static void salir() {
        vm.dispose();
    }

    public static void insertar(String nom, int edad, String prof, int tel) throws Exception{
        Persona p = new Persona(nom,edad,prof,tel);
        
        personabd.create(p);
    }

    public static void volver() {
        vo.dispose();
        vm.setVisible(true);
    }
    
    public static String getNombre(int pos) {
        return personas.get(pos).getNombre();
    }
    
    public static int getEdad(int pos) {
        return personas.get(pos).getEdad();
    }
    
    public static String getProfesion(int pos) {
        return personas.get(pos).getProfesion();
    }
    
    public static int getTelefono(int pos) {
        return personas.get(pos).getTelefono();
    }
    
}
