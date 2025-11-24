package CS2.CastilloApplication.controller.service;

import CS2.CastilloApplication.model.Pilar;
import CS2.CastilloApplication.controller.dto.PilarDTO;
import CS2.CastilloApplication.controller.dto.ActualizarPosicionRequest;
import CS2.CastilloApplication.repository.PilarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PilarService {
    
    @Autowired
    private PilarRepository pilarRepository;
    
    public List<Pilar> obtenerTodosLosPilares() {
        return pilarRepository.findAll();
    }
    
    public Optional<Pilar> obtenerPilarPorId(Long id) {
        return pilarRepository.findById(id);
    }
    
    public Pilar actualizarPosicion(ActualizarPosicionRequest request) {
        Optional<Pilar> pilarOpt = pilarRepository.findById(request.getPilarId());
        
        if (pilarOpt.isPresent()) {
            Pilar pilar = pilarOpt.get();
            pilar.setPosX(request.getPosX());
            pilar.setPosY(request.getPosY());
            pilar.setEstado(request.getEstado());
            return pilarRepository.save(pilar);
        }
        return null;
    }
    
    public PilarDTO convertirADTO(Pilar pilar) {
        return new PilarDTO(
            pilar.getId(),
            pilar.getNombre(),
            pilar.getPosX(),
            pilar.getPosY(),
            pilar.getEstado(),
            pilar.getUltimaActualizacion()
        );
    }
}