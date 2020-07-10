package mk.ukim.finki.emt.musicshop.ordermanagement.application.form;

import com.sun.istack.NotNull;
import mk.ukim.finki.emt.musicshop.ordermanagement.domain.model.Client;
import mk.ukim.finki.emt.musicshop.ordermanagement.domain.model.ClientId;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.financial.Currency;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderForm implements Serializable {

    @NotNull
    private Currency currency;

    @Valid
    @NotEmpty
    private List<OrderItemForm> items = new ArrayList<>();

    @NotNull
    private ClientId clientId;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public List<OrderItemForm> getItems() {
        return items;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public void setClientId(ClientId clientId) {
        this.clientId = clientId;
    }
}
