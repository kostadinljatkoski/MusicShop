package mk.ukim.finki.emt.musicshop.ordermanagement.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.financial.Price;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
public class Order extends AbstractEntity<OrderId> {

    @Version
    private Long version;

    @Column(name = "ordered_on", nullable = false)
    private Instant orderedOn;

    @Column(name = "order_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "order_currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "client_id", nullable = false))
    private ClientId clientId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> items;

    protected Order() {}

    public Order(@NonNull Instant orderedOn, @NonNull Currency currency, @NonNull ClientId clientId) {
        super(DomainObjectId.randomId(OrderId.class));
        this.items = new HashSet<>();
        setCurrency(currency);
        setOrderedOn(orderedOn);
        setState(OrderStatus.RECEIVED);
        setClientId(clientId);
    }

    private void setState(@NonNull OrderStatus state) {
        this.status = state;
    }

    public void setOrderedOn(Instant orderedOn) {
        this.orderedOn = orderedOn;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setClientId(ClientId clientId) {
        this.clientId = clientId;
    }

    public OrderItem addItem(@NonNull Album album, int qty) {
        Objects.requireNonNull(album, "Album must not be null");
        var item = new OrderItem(album.getId(), album.getPrice(), qty);
        item.setQuantity(qty);
        items.add(item);
        return item;
    }

    public Price total() {
        return items.stream().map(OrderItem::subtotal).reduce(new Price(currency, 0), Price::add);
    }

}
