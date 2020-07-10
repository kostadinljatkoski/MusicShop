package mk.ukim.finki.emt.musicshop.ordermanagement.application;

import mk.ukim.finki.emt.musicshop.ordermanagement.domain.model.Album;
import mk.ukim.finki.emt.musicshop.ordermanagement.domain.model.AlbumId;

import java.util.List;

public interface AlbumsCatalog {

    List<Album> findAll();

    Album findById(AlbumId id);
}
