package mk.ukim.finki.emt.musicshop.ordermanagement.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.geo.Address;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.info.Name;

import javax.persistence.Embedded;

@Getter
public class Client {

    private ClientId id;

    @Embedded
    private Name name;

    @Embedded
    private Address billingAddress;

    private String email;
}
