package CS2.CastilloApplication.controller;

import CS2.CastilloApplication.model.MensajeTactico;
import CS2.CastilloApplication.controller.dto.MensajeRequest;
import CS2.CastilloApplication.controller.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeController {
    
    @Autowired
    private MensajeService mensajeService;
    
    // ✅ ENDPOINT 4: POST - Registrar mensaje táctico fragmentado
    @PostMapping
    public ResponseEntity<?> registrarMensaje(@RequestBody MensajeRequest request) {
        // Validaciones básicas
        if (request.getPilarId() == null || 
            request.getContenidoFragmentado() == null || 
            request.getContenidoFragmentado().trim().isEmpty()) {
            
            Map<String, String> response = new HashMap<>();
            response.put("error", "Datos incompletos o inválidos");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        
        MensajeTactico mensaje = new MensajeTactico(
            request.getPilarId(),
            request.getContenidoFragmentado()
        );
        
        MensajeTactico mensajeGuardado = mensajeService.guardarMensaje(mensaje);
        
        Map<String, Object> response = new HashMap<>();
        response.put("id", mensajeGuardado.getId());
        response.put("pilarId", mensajeGuardado.getPilarId());
        response.put("contenidoFragmentado", mensajeGuardado.getContenidoFragmentado());
        response.put("contenidoReconstruido", mensajeGuardado.getContenidoReconstruido());
        response.put("timestamp", mensajeGuardado.getTimestamp());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    // ✅ ENDPOINT 5: PUT - Reconstruir un mensaje táctico
    @PutMapping("/{id}/reconstruir")
    public ResponseEntity<?> reconstruirMensaje(
            @PathVariable Long id, 
            @RequestBody Map<String, String> request) {
        
        String contenidoReconstruido = request.get("contenidoReconstruido");
        
        if (contenidoReconstruido == null || contenidoReconstruido.trim().isEmpty()) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "El contenido reconstruido no puede estar vacío");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        
        MensajeTactico mensajeActualizado = mensajeService.reconstruirMensaje(id, contenidoReconstruido);
        
        if (mensajeActualizado != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("id", mensajeActualizado.getId());
            response.put("pilarId", mensajeActualizado.getPilarId());
            response.put("contenidoFragmentado", mensajeActualizado.getContenidoFragmentado());
            response.put("contenidoReconstruido", mensajeActualizado.getContenidoReconstruido());
            response.put("timestamp", mensajeActualizado.getTimestamp());
            
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("error", "No existe un mensaje con ese ID");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}