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
    
    private String ID;
    private LocalDate juicioInicio;
    private LocalDate juicioFin;
    private String estado;
    
    private Cliente cliente;
    private ArrayList<Abogado> abogadoCargo;

    public Caso(String ID, LocalDate juicioInicio, LocalDate juicioFin, String estado, Cliente cliente, ArrayList<Abogado> abogadoCargo) {
        this.ID = ID;
        this.juicioInicio = juicioInicio;
        this.juicioFin = juicioFin;
        this.estado = estado;
        this.cliente = cliente;
        this.abogadoCargo = abogadoCargo;
    }

    public Caso(String ID, LocalDate juicioInicio, LocalDate juicioFin, String estado, Cliente cliente) {
        this.ID = ID;
        this.juicioInicio = juicioInicio;
        this.juicioFin = juicioFin;
        this.estado = estado;
        this.cliente = cliente;
        this.abogadoCargo = new ArrayList();
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
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

    @Override
    public String toString() {
        return "Caso{" + "ID=" + ID + ", juicioInicio=" + juicioInicio + ", juicioFin=" + juicioFin + ", estado=" + estado + ", cliente=" + cliente + ", abogadoCargo=" + abogadoCargo + '}';
    }
    
    
}
