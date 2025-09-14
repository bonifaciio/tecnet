package org.example.tecnet.model;

public class Usuario {
    private Integer id;
    private String username;
    private String email;
    private String nombres;
    private String apellidos;
    private String carrera;
    private String rol;
    private String estado;

    // getters y setters
    public Integer getId(){ return id; }
    public void setId(Integer id){ this.id = id; }
    public String getUsername(){ return username; }
    public void setUsername(String username){ this.username = username; }
    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }
    public String getNombres(){ return nombres; }
    public void setNombres(String nombres){ this.nombres = nombres; }
    public String getApellidos(){ return apellidos; }
    public void setApellidos(String apellidos){ this.apellidos = apellidos; }
    public String getCarrera(){ return carrera; }
    public void setCarrera(String carrera){ this.carrera = carrera; }
    public String getRol(){ return rol; }
    public void setRol(String rol){ this.rol = rol; }
    public String getEstado(){ return estado; }
    public void setEstado(String estado){ this.estado = estado; }
}