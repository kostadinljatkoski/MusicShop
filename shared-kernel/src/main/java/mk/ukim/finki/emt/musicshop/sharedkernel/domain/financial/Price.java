package mk.ukim.finki.emt.musicshop.sharedkernel.domain.financial;

import lombok.Getter;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.base.ValueObject;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@Embeddable
@Getter
public class Price implements ValueObject {

    @NonNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "currency")
    private final Currency currency;

    @Column(name = "amount")
    private final int amount;

    public Price(@NonNull Currency currency, @NonNull int amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public static Price valueOf(Currency currency, int amount) {
        return new Price(currency, amount);
    }

    @SuppressWarnings("unused")
    protected Price() {
        this.currency = Currency.MKD;
        this.amount = 0;
    }

    public Price add(Price price) {
        if (!currency.equals(price.currency)) {
            throw new IllegalArgumentException("Cannot add two Price objects with different currencies");
        }
        return new Price(currency, amount + price.amount);
    }

    public Price subtract(Price price) {
        if (!currency.equals(price.currency)) {
            throw new IllegalArgumentException("Cannot add two Price objects with different currencies");
        }
        return new Price(currency, amount - price.amount);
    }

    public Price multiply(int m) {
        return new Price(currency, amount * m);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return amount == price.amount &&
                currency == price.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }

    @Override
    public String toString() {
        return "Price{" +
                "currency=" + currency +
                ", amount=" + amount +
                '}';
    }
}