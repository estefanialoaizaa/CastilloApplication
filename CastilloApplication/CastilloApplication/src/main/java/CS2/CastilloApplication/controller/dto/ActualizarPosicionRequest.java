package CS2.CastilloApplication.controller.dto;

public class ActualizarPosicionRequest {
    private Long pilarId;
    private Integer posX;
    private Integer posY;
    private String estado;
    
    // Constructores
    public ActualizarPosicionRequest() {}
    
    public ActualizarPosicionRequest(Long pilarId, Integer posX, Integer posY, String estado) {
        this.pilarId = pilarId;
        this.posX = posX;
        this.posY = posY;
        this.estado = estado;
    }
    
    // Getters y Setters
    public Long getPilarId() { return pilarId; }
    public void setPilarId(Long pilarId) { this.pilarId = pilarId; }
    
    public Integer getPosX() { return posX; }
    public void setPosX(Integer posX) { this.posX = posX; }
    
    public Integer getPosY() { return posY; }
    public void setPosY(Integer posY) { this.posY = posY; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}