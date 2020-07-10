package mk.ukim.finki.emt.musicshop.albumscatalog.domain.repository;

import mk.ukim.finki.emt.musicshop.albumscatalog.domain.model.Album;
import mk.ukim.finki.emt.musicshop.albumscatalog.domain.model.AlbumId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumsRepository extends JpaRepository<Album, AlbumId> {
}
