package mk.ukim.finki.emt.musicshop.albumscatalog;

import mk.ukim.finki.emt.musicshop.sharedkernel.SharedConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
@Import(SharedConfiguration.class)
public class AlbumsCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlbumsCatalogApplication.class, args);
    }

}
