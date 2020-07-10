package mk.ukim.finki.emt.musicshop.artistsinfo.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.info.Name;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "artists")
@Getter
public class Artist extends AbstractEntity<ArtistId> {

    @OneToMany(mappedBy = "artist")
    private Set<Label> labels;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "first_name", column = @Column(name = "first_name", nullable = false)),
            @AttributeOverride(name = "last_name", column = @Column(name = "last_name", nullable = false)),
    })
    private Name name;

    public Artist(Name name) {
        this.labels = new HashSet<>();
        this.name = name;
    }

    protected Artist() {}

    public void setLabels(Set<Label> labels) {
        this.labels = labels;
    }

    public void setName(Name name) {
        this.name = name;
    }
}