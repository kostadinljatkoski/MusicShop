package mk.ukim.finki.emt.musicshop.albumscatalog.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class OrderItemId extends DomainObjectId {

    protected OrderItemId() {
        super(DomainObjectId.randomId(OrderItemId.class).toString());
    }

    @JsonCreator
    public OrderItemId(@NonNull String id) {
        super(id);
    }
}