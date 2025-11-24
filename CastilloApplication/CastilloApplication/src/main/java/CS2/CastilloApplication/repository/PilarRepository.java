package CS2.CastilloApplication.repository;

import CS2.CastilloApplication.model.Pilar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilarRepository extends JpaRepository<Pilar, Long> {
}