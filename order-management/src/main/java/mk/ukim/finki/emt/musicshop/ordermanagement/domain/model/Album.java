package mk.ukim.finki.emt.musicshop.ordermanagement.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.financial.Price;

import java.util.Set;

@Getter
public class Album {

    private AlbumId id;

    private Set<String> genres;

    private float rating;

    private String title;

    private int releaseYear;

    private Price price;

    private int availableQuantity;

}
