package CS2.CastilloApplication.controller;

import CS2.CastilloApplication.model.Pilar;
import CS2.CastilloApplication.controller.dto.PilarDTO;
import CS2.CastilloApplication.controller.dto.ActualizarPosicionRequest;
import CS2.CastilloApplication.controller.service.PilarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/pilares")
public class PilarController {
    
    @Autowired
    private PilarService pilarService;
    
    // ✅ ENDPOINT 1: GET - Consultar información completa de un Pilar
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPilar(@PathVariable Long id) {
        Optional<Pilar> pilarOpt = pilarService.obtenerPilarPorId(id);
        
        if (pilarOpt.isPresent()) {
            PilarDTO pilarDTO = pilarService.convertirADTO(pilarOpt.get());
            return ResponseEntity.ok(pilarDTO);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("error", "No existe un Pilar con ese ID");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
    
    // ✅ ENDPOINT 3: POST - Registrar o actualizar posición de un Pilar
    @PostMapping("/actualizar-posicion")
    public ResponseEntity<?> actualizarPosicion(@RequestBody ActualizarPosicionRequest request) {
        // Validaciones básicas
        if (request.getPilarId() == null || request.getPosX() == null || 
            request.getPosY() == null || request.getEstado() == null || 
            request.getEstado().trim().isEmpty()) {
            
            Map<String, String> response = new HashMap<>();
            response.put("error", "Datos incompletos o inválidos");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        
        Pilar pilarActualizado = pilarService.actualizarPosicion(request);
        
        if (pilarActualizado != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", "Posición actualizada exitosamente.");
            response.put("pilar", pilarService.convertirADTO(pilarActualizado));
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("error", "No existe un Pilar con ese ID");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}