package mk.ukim.finki.emt.musicshop.artistsinfo.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class ArtistId extends DomainObjectId {

    protected ArtistId() {
        super(DomainObjectId.randomId(ArtistId.class).toString());
    }

    @JsonCreator
    public ArtistId(String id) {
        super(id);
    }

}