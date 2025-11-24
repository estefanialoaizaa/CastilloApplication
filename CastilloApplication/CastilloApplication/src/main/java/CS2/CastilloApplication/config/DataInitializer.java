package CS2.CastilloApplication.config;

import CS2.CastilloApplication.model.Pilar;
import CS2.CastilloApplication.repository.PilarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private PilarRepository pilarRepository;
    
    @Override
    public void run(String... args) throws Exception {
        
        if (pilarRepository.count() == 0) {
           
            pilarRepository.save(new Pilar("Giyu Tomioka", -500, -200, "Combatiendo"));
            pilarRepository.save(new Pilar("Sanemi Shinazugawa", 100, -100, "Combatiendo"));
            pilarRepository.save(new Pilar("Mitsuri Kanroji", 500, 100, "Combatiendo"));
            
            System.out.println("Datos iniciales de Pilares cargados");
        }
    }
}