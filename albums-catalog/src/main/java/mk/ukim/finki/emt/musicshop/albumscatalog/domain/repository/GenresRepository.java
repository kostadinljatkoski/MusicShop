package mk.ukim.finki.emt.musicshop.albumscatalog.domain.repository;

import mk.ukim.finki.emt.musicshop.albumscatalog.domain.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenresRepository extends JpaRepository<Genre, Integer> {
}
