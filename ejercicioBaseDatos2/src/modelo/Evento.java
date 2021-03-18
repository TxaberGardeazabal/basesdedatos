/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.*;
import java.util.ArrayList;
/**
 *
 * @author txaber
 */
public class Evento {
    
    private String nombre;
    private String lugar;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private int maxAsistencia;

    public Evento(String nombre, String lugar, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, int maxAsistencia) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.maxAsistencia = maxAsistencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public int getMaxAsistencia() {
        return maxAsistencia;
    }

    public void setMaxAsistencia(int maxAsistencia) {
        this.maxAsistencia = maxAsistencia;
    }
    
    private ArrayList<Persona> asistentes;

    public ArrayList<Persona> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(Persona asistentes) {
        if (this.asistentes == null)
            this.asistentes = new ArrayList();
        
        this.asistentes.add(asistentes);
    }
    
    
}
