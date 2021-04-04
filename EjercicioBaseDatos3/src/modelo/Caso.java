/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author txaber
 */
public class Caso {
    
    private Integer ID;
    private LocalDate juicioInicio;
    private LocalDate juicioFin;
    private String estado;
    
    private Cliente cliente;
    private ArrayList<Abogado> abogadoCargo;

    public Caso(Integer ID, LocalDate juicioInicio, LocalDate juicioFin, String estado, Cliente cliente, ArrayList<Abogado> abogadoCargo) {
        this.ID = ID;
        this.juicioInicio = juicioInicio;
        this.juicioFin = juicioFin;
        this.estado = estado;
        this.cliente = cliente;
        this.abogadoCargo = abogadoCargo;
    }

    public Caso(Integer ID, LocalDate juicioInicio, LocalDate juicioFin, String estado, Cliente cliente) {
        this.ID = ID;
        this.juicioInicio = juicioInicio;
        this.juicioFin = juicioFin;
        this.estado = estado;
        this.cliente = cliente;
        this.abogadoCargo = new ArrayList();
    }

    public Caso() {}
    
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public LocalDate getJuicioInicio() {
        return juicioInicio;
    }

    public void setJuicioInicio(LocalDate juicioInicio) {
        this.juicioInicio = juicioInicio;
    }

    public LocalDate getJuicioFin() {
        return juicioFin;
    }

    public void setJuicioFin(LocalDate juicioFin) {
        this.juicioFin = juicioFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Abogado> getAbogadoCargo() {
        return abogadoCargo;
    }

    public void setAbogadoCargo(Abogado abogadoCargo) {
        this.abogadoCargo.add(abogadoCargo);
    }
    
    public void setAbogadosCargo(ArrayList<Abogado> abogados) {
        this.abogadoCargo = abogados;
    }

    @Override
    public String toString() {
        String ret = "Caso con identificador = "+String.valueOf(ID)+
                "\nfecha comienzo: "+juicioInicio.toString();
        
        if (estado.equals("archivado")) {
            ret += " fecha finalizacion: "+juicioFin.toString();
        }
        ret +=" estado: "+estado+
            "\ncliente: "+cliente.getNombre()+
            "\nabogados:";
        ret = abogadoCargo.stream().map((abogadoCargo1) -> "\n"+abogadoCargo1.getNombre()+" "+abogadoCargo1.getApellido()).reduce(ret, String::concat);
        
        return ret;
    }
    
    
}
