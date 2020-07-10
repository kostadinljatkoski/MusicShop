package mk.ukim.finki.emt.musicshop.albumscatalog.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.financial.Price;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "albums")
@Getter
public class Album extends AbstractEntity<AlbumId> {

    @OneToMany(mappedBy = "album")
    private Set<Genre> genres;

    @Column(name = "rating", nullable = false)
    private float rating;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "release_year", nullable = false)
    private int releaseYear;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "currency", nullable = false)),
            @AttributeOverride(name = "amount", column = @Column(name = "amount", nullable = false))
    })
    private Price price;

    @Column(name = "available_quantity", nullable = false)
    private int availableQuantity;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "artist_id", nullable = false))
    private ArtistId artistId;

    public Album(AlbumId albumId, @NonNull String title, @NonNull int releaseYear, @NonNull float rating, @NonNull Price price, @NonNull int availableQuantity, @NonNull ArtistId artistId, List<String> genres) {
        super(albumId);
        this.genres = new HashSet<>();
        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.artistId = artistId;
        genres.forEach(g -> this.genres.add(new Genre(g, this)));
    }

    protected Album() {
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setAvailableQuantity(int availableQuantity) {
        if (availableQuantity < 0) {
            throw new IllegalArgumentException("Available quantity cannot be negative");
        }
        this.availableQuantity = availableQuantity;
    }

    public void subtractQuantity(int qnt) {
        if (qnt > this.availableQuantity) {
            throw new RuntimeException("unsupported quantity");
        }
        this.availableQuantity -= qnt;
    }

    public void addQuantity(int qnt) {
        this.availableQuantity += qnt;
    }

    public void addGenre(String genre) {
        this.genres.add(new Genre(genre, this));
    }
}
