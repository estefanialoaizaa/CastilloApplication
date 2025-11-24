package CS2.CastilloApplication.repository;

import CS2.CastilloApplication.model.MensajeTactico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeRepository extends JpaRepository<MensajeTactico, Long> {
}