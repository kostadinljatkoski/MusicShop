package mk.ukim.finki.emt.musicshop.albumscatalog.application;

import mk.ukim.finki.emt.musicshop.albumscatalog.domain.model.Album;
import mk.ukim.finki.emt.musicshop.albumscatalog.domain.model.AlbumId;
import mk.ukim.finki.emt.musicshop.albumscatalog.domain.repository.AlbumsRepository;
import mk.ukim.finki.emt.musicshop.albumscatalog.integration.OrderItemAddedEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class AlbumsCatalog {

    private final AlbumsRepository albumsRepository;

    public AlbumsCatalog(AlbumsRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    @NonNull
    public List<Album> findAll() {
        return albumsRepository.findAll();
    }

    @NonNull
    public Optional<Album> findById(@NonNull AlbumId albumId) {
        Objects.requireNonNull(albumId, "albumId must not be null");
        return albumsRepository.findById(albumId);
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void onOrderCreatedEvent(OrderItemAddedEvent event) {
        Album a = albumsRepository.findById(event.getAlbumId()).orElseThrow(RuntimeException::new);
        a.subtractQuantity(event.getQuantity());
        albumsRepository.save(a);
    }
}

