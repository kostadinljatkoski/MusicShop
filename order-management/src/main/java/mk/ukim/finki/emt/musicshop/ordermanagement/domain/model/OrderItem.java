package mk.ukim.finki.emt.musicshop.ordermanagement.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.financial.Price;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
@Getter
public class OrderItem extends AbstractEntity<OrderItemId> {

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "album_id", nullable = false))
    private AlbumId albumId;

    @Embedded
    private Price itemPrice;

    @Column(name = "qty", nullable = false)
    private int quantity;

    protected OrderItem() {
    }

    OrderItem(@NonNull AlbumId albumId, @NonNull Price itemPrice, @NonNull int quantity) {
        super(DomainObjectId.randomId(OrderItemId.class));
        setProductId(albumId);
        setItemPrice(itemPrice);
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    public void setProductId(AlbumId albumId) {
        this.albumId = albumId;
    }

    public void setItemPrice(Price itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    public Price subtotal() {
        return itemPrice.multiply(quantity);
    }

}

