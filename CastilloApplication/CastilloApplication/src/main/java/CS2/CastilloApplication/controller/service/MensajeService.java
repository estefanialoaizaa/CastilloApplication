package CS2.CastilloApplication.controller.service;

import CS2.CastilloApplication.model.MensajeTactico;
import CS2.CastilloApplication.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MensajeService {
    
    @Autowired
    private MensajeRepository mensajeRepository;
    
    public MensajeTactico guardarMensaje(MensajeTactico mensaje) {
        return mensajeRepository.save(mensaje);
    }
    
    public Optional<MensajeTactico> obtenerMensajePorId(Long id) {
        return mensajeRepository.findById(id);
    }
    
    public MensajeTactico reconstruirMensaje(Long id, String contenidoReconstruido) {
        Optional<MensajeTactico> mensajeOpt = mensajeRepository.findById(id);
        
        if (mensajeOpt.isPresent()) {
            MensajeTactico mensaje = mensajeOpt.get();
            mensaje.setContenidoReconstruido(contenidoReconstruido);
            return mensajeRepository.save(mensaje);
        }
        return null;
    }
    
    public List<MensajeTactico> obtenerTodosLosMensajes() {
        return mensajeRepository.findAll();
    }
}