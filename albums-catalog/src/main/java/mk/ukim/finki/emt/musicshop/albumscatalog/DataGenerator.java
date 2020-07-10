package mk.ukim.finki.emt.musicshop.albumscatalog;

import mk.ukim.finki.emt.musicshop.albumscatalog.domain.model.Album;
import mk.ukim.finki.emt.musicshop.albumscatalog.domain.model.AlbumId;
import mk.ukim.finki.emt.musicshop.albumscatalog.domain.model.ArtistId;
import mk.ukim.finki.emt.musicshop.albumscatalog.domain.model.Genre;
import mk.ukim.finki.emt.musicshop.albumscatalog.domain.repository.AlbumsRepository;
import mk.ukim.finki.emt.musicshop.albumscatalog.domain.repository.GenresRepository;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.financial.Price;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
class DataGenerator {

    private final AlbumsRepository albumsRepository;

    DataGenerator(AlbumsRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    @PostConstruct
    @Transactional
    public void generateData() {
        if (albumsRepository.findAll().size()==0) {
            var albums = new ArrayList<Album>();
            albums.add(new Album(new AlbumId("1"), "Rare", 2020, 8.5F, new Price(Currency.MKD, 6200), 10, new ArtistId("1"), new ArrayList<String>() {{ add("pop"); }}));
            albums.add(new Album(new AlbumId("2"), "When we all fall asleep, where do we go", 2019, 9.5F, new Price(Currency.MKD, 8000), 15, new ArtistId("2"), new ArrayList<String>() {{ add("pop"); }}));
            albums.add(new Album(new AlbumId("3"), "Believe", 2012, 6.0F, new Price(Currency.MKD, 4100), 3, new ArtistId("3"), new ArrayList<String>() {{ add("pop"); }}));
            albumsRepository.saveAll(albums);
        }
    }

}
