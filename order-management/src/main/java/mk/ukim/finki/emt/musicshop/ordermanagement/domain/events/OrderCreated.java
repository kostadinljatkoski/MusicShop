package mk.ukim.finki.emt.musicshop.ordermanagement.domain.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import mk.ukim.finki.emt.musicshop.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.base.DomainEvent;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.Objects;

public class OrderCreated implements DomainEvent {

    @JsonProperty("orderId")
    private final OrderId orderId;
    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    @JsonCreator
    public OrderCreated(@JsonProperty("orderId") @NonNull OrderId orderId,
                        @JsonProperty("occurredOn") @NonNull Instant occurredOn) {
        this.orderId = Objects.requireNonNull(orderId, "orderId must not be null");
        this.occurredOn = Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }

    @NonNull
    public OrderId orderId() {
        return orderId;
    }

    @Override
    @NonNull
    public Instant occurredOn() {
        return occurredOn;
    }
}
