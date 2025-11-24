package CS2.CastilloApplication.controller.dto;

public class TriangulacionResponse {
    private Posicion posiblePosicionMuzan;
    private Double nivelConfianza;
    private String descripcion;
    
    // Clase interna para la posición
    public static class Posicion {
        private Integer x;
        private Integer y;
        
        public Posicion() {}
        
        public Posicion(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
        
        // Getters y Setters
        public Integer getX() { return x; }
        public void setX(Integer x) { this.x = x; }
        
        public Integer getY() { return y; }
        public void setY(Integer y) { this.y = y; }
    }
    
    // Constructores
    public TriangulacionResponse() {}
    
    public TriangulacionResponse(Posicion posiblePosicionMuzan, Double nivelConfianza, String descripcion) {
        this.posiblePosicionMuzan = posiblePosicionMuzan;
        this.nivelConfianza = nivelConfianza;
        this.descripcion = descripcion;
    }
    
    // Getters y Setters
    public Posicion getPosiblePosicionMuzan() { return posiblePosicionMuzan; }
    public void setPosiblePosicionMuzan(Posicion posiblePosicionMuzan) { 
        this.posiblePosicionMuzan = posiblePosicionMuzan; 
    }
    
    public Double getNivelConfianza() { return nivelConfianza; }
    public void setNivelConfianza(Double nivelConfianza) { this.nivelConfianza = nivelConfianza; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}