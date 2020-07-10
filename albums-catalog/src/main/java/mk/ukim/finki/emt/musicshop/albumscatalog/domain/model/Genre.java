package mk.ukim.finki.emt.musicshop.albumscatalog.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "genres")
@Data
public class Genre{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String genre;

    @ManyToOne(fetch = FetchType.LAZY)
    private Album album;

    public Genre(String genre, Album album) {
        this.genre = genre;
        this.album = album;
    }

    protected Genre() {}

}
