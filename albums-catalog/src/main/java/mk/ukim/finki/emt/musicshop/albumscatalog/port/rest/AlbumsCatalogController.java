package mk.ukim.finki.emt.musicshop.albumscatalog.port.rest;

import mk.ukim.finki.emt.musicshop.albumscatalog.application.AlbumsCatalog;
import mk.ukim.finki.emt.musicshop.albumscatalog.domain.model.Album;
import mk.ukim.finki.emt.musicshop.albumscatalog.domain.model.AlbumId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
class AlbumsCatalogController {

    private final AlbumsCatalog albumsCatalog;

    AlbumsCatalogController(AlbumsCatalog albumsCatalog) {
        this.albumsCatalog = albumsCatalog;
    }

    // Please note: in a real-world application it would be better to have separate DTO classes that are serialized
    // to JSON. However, to save time, we're using the entity classes directly in this example.

    @GetMapping("/{id}")
    public ResponseEntity<Album> findById(@PathVariable("id") String albumId) {
        return albumsCatalog.findById(new AlbumId(albumId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Album> findAll() {
        return albumsCatalog.findAll();
    }
}
