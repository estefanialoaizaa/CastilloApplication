package CS2.CastilloApplication.controller.dto;

import java.time.LocalDateTime;

public class PilarDTO {
    private Long id;
    private String nombre;
    private Integer posX;
    private Integer posY;
    private String estado;
    private LocalDateTime ultimaActualizacion;
    
    // Constructores
    public PilarDTO() {}
    
    public PilarDTO(Long id, String nombre, Integer posX, Integer posY, String estado, LocalDateTime ultimaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.estado = estado;
        this.ultimaActualizacion = ultimaActualizacion;
    }
    
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public Integer getPosX() { return posX; }
    public void setPosX(Integer posX) { this.posX = posX; }
    
    public Integer getPosY() { return posY; }
    public void setPosY(Integer posY) { this.posY = posY; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    public LocalDateTime getUltimaActualizacion() { return ultimaActualizacion; }
    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) { 
        this.ultimaActualizacion = ultimaActualizacion; 
    }
}