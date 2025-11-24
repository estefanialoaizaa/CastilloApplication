package CS2.CastilloApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("CS2.CastilloApplication.model")
@EnableJpaRepositories("CS2.CastilloApplication.repository")
public class CastilloApplication {
    public static void main(String[] args) {
        SpringApplication.run(CastilloApplication.class, args);
    }
}