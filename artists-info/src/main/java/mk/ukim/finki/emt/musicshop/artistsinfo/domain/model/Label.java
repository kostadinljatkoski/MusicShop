package mk.ukim.finki.emt.musicshop.artistsinfo.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "labels")
@Data
public class Label{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String label;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artist artist;

}
