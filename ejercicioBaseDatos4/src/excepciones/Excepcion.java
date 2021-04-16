/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author txaber
 */
public class Excepcion extends Exception{
    
    private String message;

    public Excepcion(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
    
    
    
}
