package mk.ukim.finki.emt.musicshop.albumscatalog.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.info.Name;

import java.util.Set;

@Getter
public class Artist {

    private ArtistId id;

    private Set<String> labels;

    private Name name;

}
