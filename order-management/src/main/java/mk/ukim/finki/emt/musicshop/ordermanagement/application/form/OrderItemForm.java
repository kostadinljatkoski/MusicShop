package mk.ukim.finki.emt.musicshop.ordermanagement.application.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


import mk.ukim.finki.emt.musicshop.ordermanagement.domain.model.Album;

import java.io.Serializable;

public class OrderItemForm implements Serializable {

    @NotNull
    private Album album;

    @Min(1)
    private int quantity = 1;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
