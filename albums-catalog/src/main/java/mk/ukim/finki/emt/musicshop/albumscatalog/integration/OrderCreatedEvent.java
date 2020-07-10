package mk.ukim.finki.emt.musicshop.albumscatalog.integration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import mk.ukim.finki.emt.musicshop.albumscatalog.domain.model.ClientId;
import mk.ukim.finki.emt.musicshop.albumscatalog.domain.model.OrderId;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.base.DomainEvent;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.Objects;

public class OrderCreatedEvent implements DomainEvent {

    @JsonProperty("orderId")
    private final OrderId orderId;
    @JsonProperty("clientId")
    private final ClientId clientId;
    @JsonProperty("occurredOn")
    private final Instant occurredOn;


    @JsonCreator
    public OrderCreatedEvent(@JsonProperty("orderId") @NonNull OrderId orderId,
                             @JsonProperty("clientId") @NonNull ClientId clientId,
                             @JsonProperty("occurredOn") @NonNull Instant occurredOn) {
        this.orderId = Objects.requireNonNull(orderId, "orderId must not be null");
        this.clientId = Objects.requireNonNull(clientId, "clientId must not be null");
        this.occurredOn = Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }

    @NonNull
    public OrderId orderId() {
        return orderId;
    }

    @NonNull
    public ClientId clientId() {
        return clientId;
    }

    @Override
    @NonNull
    public Instant occurredOn() {
        return occurredOn;
    }


}
