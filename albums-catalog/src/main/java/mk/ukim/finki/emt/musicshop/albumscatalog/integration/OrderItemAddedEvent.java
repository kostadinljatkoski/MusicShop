package mk.ukim.finki.emt.musicshop.albumscatalog.integration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.musicshop.albumscatalog.domain.model.AlbumId;
import mk.ukim.finki.emt.musicshop.albumscatalog.domain.model.OrderId;
import mk.ukim.finki.emt.musicshop.albumscatalog.domain.model.OrderItemId;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.base.DomainEvent;

import java.time.Instant;

@Getter
public class OrderItemAddedEvent implements DomainEvent {

    @JsonProperty("orderId")
    private final OrderId orderId;

    @JsonProperty("orderItemId")
    private final OrderItemId orderItemId;

    @JsonProperty("albumId")
    private final AlbumId albumId;

    @JsonProperty("quantity")
    private final int quantity;

    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    @JsonCreator
    public OrderItemAddedEvent(OrderId orderId, OrderItemId orderItemId, AlbumId albumId, int quantity, Instant occurredOn) {
        this.orderId = orderId;
        this.orderItemId = orderItemId;
        this.albumId = albumId;
        this.quantity = quantity;
        this.occurredOn = occurredOn;
    }

    @Override
    public Instant occurredOn() {
        return occurredOn;
    }

}
