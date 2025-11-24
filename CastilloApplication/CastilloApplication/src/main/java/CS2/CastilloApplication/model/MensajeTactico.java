package CS2.CastilloApplication.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mensajes_tacticos")
public class MensajeTactico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "pilar_id", nullable = false)
    private Long pilarId;
    
    @Column(name = "contenido_fragmentado", nullable = false, length = 1000)
    private String contenidoFragmentado;
    
    @Column(name = "contenido_reconstruido", length = 1000)
    private String contenidoReconstruido;
    
    @Column(nullable = false)
    private LocalDateTime timestamp;
    
    // Constructores
    public MensajeTactico() {
        this.timestamp = LocalDateTime.now();
    }
    
    public MensajeTactico(Long pilarId, String contenidoFragmentado) {
        this.pilarId = pilarId;
        this.contenidoFragmentado = contenidoFragmentado;
        this.timestamp = LocalDateTime.now();
    }
    
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getPilarId() { return pilarId; }
    public void setPilarId(Long pilarId) { this.pilarId = pilarId; }
    
    public String getContenidoFragmentado() { return contenidoFragmentado; }
    public void setContenidoFragmentado(String contenidoFragmentado) { 
        this.contenidoFragmentado = contenidoFragmentado; 
    }
    
    public String getContenidoReconstruido() { return contenidoReconstruido; }
    public void setContenidoReconstruido(String contenidoReconstruido) { 
        this.contenidoReconstruido = contenidoReconstruido; 
    }
    
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}