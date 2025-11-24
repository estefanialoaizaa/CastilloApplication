package CS2.CastilloApplication.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pilares")
public class Pilar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private Integer posX;
    
    @Column(nullable = false)
    private Integer posY;
    
    @Column(nullable = false)
    private String estado;
    
    @Column(name = "ultima_actualizacion")
    private LocalDateTime ultimaActualizacion;
    
    // Constructores
    public Pilar() {}
    
    public Pilar(String nombre, Integer posX, Integer posY, String estado) {
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.estado = estado;
        this.ultimaActualizacion = LocalDateTime.now();
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
    public void setEstado(String estado) { 
        this.estado = estado; 
        this.ultimaActualizacion = LocalDateTime.now();
    }
    
    public LocalDateTime getUltimaActualizacion() { return ultimaActualizacion; }
    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) { 
        this.ultimaActualizacion = ultimaActualizacion; 
    }
}