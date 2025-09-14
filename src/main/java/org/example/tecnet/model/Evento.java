package org.example.tecnet.model;

import java.time.LocalDateTime;

public class Evento {
    private Integer id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private String modalidad;
    private String lugar;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Integer aforo;
    private String estado;

    // getters y setters
    public Integer getId(){ return id; }
    public void setId(Integer id){ this.id = id; }
    public String getTitulo(){ return titulo; }
    public void setTitulo(String titulo){ this.titulo = titulo; }
    public String getDescripcion(){ return descripcion; }
    public void setDescripcion(String descripcion){ this.descripcion = descripcion; }
    public String getCategoria(){ return categoria; }
    public void setCategoria(String categoria){ this.categoria = categoria; }
    public String getModalidad(){ return modalidad; }
    public void setModalidad(String modalidad){ this.modalidad = modalidad; }
    public String getLugar(){ return lugar; }
    public void setLugar(String lugar){ this.lugar = lugar; }
    public LocalDateTime getFechaInicio(){ return fechaInicio; }
    public void setFechaInicio(LocalDateTime fechaInicio){ this.fechaInicio = fechaInicio; }
    public LocalDateTime getFechaFin(){ return fechaFin; }
    public void setFechaFin(LocalDateTime fechaFin){ this.fechaFin = fechaFin; }
    public Integer getAforo(){ return aforo; }
    public void setAforo(Integer aforo){ this.aforo = aforo; }
    public String getEstado(){ return estado; }
    public void setEstado(String estado){ this.estado = estado; }
}