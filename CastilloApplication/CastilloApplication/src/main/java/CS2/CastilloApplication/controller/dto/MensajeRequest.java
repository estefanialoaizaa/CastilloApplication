package CS2.CastilloApplication.controller.dto;

public class MensajeRequest {
    private Long pilarId;
    private String contenidoFragmentado;
    
    // Constructores
    public MensajeRequest() {}
    
    public MensajeRequest(Long pilarId, String contenidoFragmentado) {
        this.pilarId = pilarId;
        this.contenidoFragmentado = contenidoFragmentado;
    }
    
    // Getters y Setters
    public Long getPilarId() { return pilarId; }
    public void setPilarId(Long pilarId) { this.pilarId = pilarId; }
    
    public String getContenidoFragmentado() { return contenidoFragmentado; }
    public void setContenidoFragmentado(String contenidoFragmentado) { 
        this.contenidoFragmentado = contenidoFragmentado; 
    }
}