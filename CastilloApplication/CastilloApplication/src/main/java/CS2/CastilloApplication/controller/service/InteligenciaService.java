package CS2.CastilloApplication.controller.service;

import CS2.CastilloApplication.model.Pilar;
import CS2.CastilloApplication.controller.dto.TriangulacionResponse;
import CS2.CastilloApplication.repository.PilarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class InteligenciaService {
    
    @Autowired
    private PilarRepository pilarRepository;
    
    public TriangulacionResponse calcularTriangulacion() {
        List<Pilar> pilares = pilarRepository.findAll();
        
        if (pilares.isEmpty()) {
            return new TriangulacionResponse(
                new TriangulacionResponse.Posicion(0, 0),
                0.0,
                "No hay datos suficientes de los Pilares para calcular triangulación."
            );
        }
        
        // Algoritmo simple de triangulación: promedio ponderado por estado del Pilar
        double sumaX = 0;
        double sumaY = 0;
        double pesoTotal = 0;
        
        for (Pilar pilar : pilares) {
            double peso = calcularPesoPorEstado(pilar.getEstado());
            sumaX += pilar.getPosX() * peso;
            sumaY += pilar.getPosY() * peso;
            pesoTotal += peso;
        }
        
        int posX = (int) (sumaX / pesoTotal);
        int posY = (int) (sumaY / pesoTotal);
        
        // Nivel de confianza basado en cantidad de pilares y sus estados
        double nivelConfianza = calcularNivelConfianza(pilares);
        
        String descripcion = generarDescripcion(nivelConfianza, pilares.size());
        
        return new TriangulacionResponse(
            new TriangulacionResponse.Posicion(posX, posY),
            nivelConfianza,
            descripcion
        );
    }
    
    private double calcularPesoPorEstado(String estado) {
        return switch (estado.toLowerCase()) {
            case "combatiendo" -> 1.0;
            case "herido" -> 0.7;
            case "descansando" -> 0.5;
            case "inmovil" -> 0.3;
            default -> 0.5;
        };
    }
    
    private double calcularNivelConfianza(List<Pilar> pilares) {
        double confianzaBase = 0.5;
        double factorCantidad = Math.min(pilares.size() / 3.0, 1.0);
        double factorEstado = pilares.stream()
            .mapToDouble(p -> calcularPesoPorEstado(p.getEstado()))
            .average()
            .orElse(0.5);
        
        return Math.min(confianzaBase + (factorCantidad * 0.3) + (factorEstado * 0.2), 0.95);
    }
    
    private String generarDescripcion(double confianza, int cantidadPilares) {
        if (confianza > 0.8) {
            return "Alta probabilidad de presencia demoníaca. Múltiples fuentes confirman la ubicación.";
        } else if (confianza > 0.6) {
            return "Probabilidad media-alta. Se recomienda preparar contingencia.";
        } else if (confianza > 0.4) {
            return "Estimación con margen de error considerable. Se necesitan más datos.";
        } else {
            return "Datos insuficientes para triangulación confiable. Esperando más reportes.";
        }
    }
}