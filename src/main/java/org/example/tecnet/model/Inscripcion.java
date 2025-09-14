package org.example.tecnet.model;

import java.time.LocalDateTime;

public class Inscripcion {
    private Integer id;
    private Integer usuarioId;
    private Integer eventoId;
    private LocalDateTime fechaReg;

    // getters y setters
    public Integer getId(){ return id; }
    public void setId(Integer id){ this.id = id; }
    public Integer getUsuarioId(){ return usuarioId; }
    public void setUsuarioId(Integer usuarioId){ this.usuarioId = usuarioId; }
    public Integer getEventoId(){ return eventoId; }
    public void setEventoId(Integer eventoId){ this.eventoId = eventoId; }
    public LocalDateTime getFechaReg(){ return fechaReg; }
    public void setFechaReg(LocalDateTime fechaReg){ this.fechaReg = fechaReg; }
}