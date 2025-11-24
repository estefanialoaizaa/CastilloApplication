package CS2.CastilloApplication.controller;

import CS2.CastilloApplication.controller.dto.TriangulacionResponse;
import CS2.CastilloApplication.controller.service.InteligenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inteligencia")
public class InteligenciaController {
    
    @Autowired
    private InteligenciaService inteligenciaService;
    
    // ✅ ENDPOINT 2: GET - Obtener triangulación estimada del enemigo
    @GetMapping("/triangulacion")
    public ResponseEntity<TriangulacionResponse> obtenerTriangulacion() {
        TriangulacionResponse triangulacion = inteligenciaService.calcularTriangulacion();
        return ResponseEntity.ok(triangulacion);
    }
}