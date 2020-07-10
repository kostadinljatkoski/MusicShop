package mk.ukim.finki.emt.musicshop.albumscatalog.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class AlbumId extends DomainObjectId {

    protected AlbumId() {
        super(DomainObjectId.randomId(AlbumId.class).toString());
    }

    @JsonCreator
    public AlbumId(String id) {
        super(id);
    }

}
