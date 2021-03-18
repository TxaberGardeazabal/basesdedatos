/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author txaber
 */
public class Empresa {
    
    private String nombre;
    private Integer CNAE;

    public Empresa(String nombre, Integer CNAE) {
        this.nombre = nombre;
        this.CNAE = CNAE;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCNAE() {
        return CNAE;
    }

    public void setCNAE(Integer CNAE) {
        this.CNAE = CNAE;
    }
    
    
}
