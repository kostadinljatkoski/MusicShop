package mk.ukim.finki.emt.musicshop.albumscatalog.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import mk.ukim.finki.emt.musicshop.sharedkernel.domain.base.DomainEvent;
import mk.ukim.finki.emt.musicshop.sharedkernel.infra.eventlog.RemoteEventTranslator;
import mk.ukim.finki.emt.musicshop.sharedkernel.infra.eventlog.StoredDomainEvent;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemAddedEventTranslator implements RemoteEventTranslator {

    private final ObjectMapper objectMapper;

    public OrderItemAddedEventTranslator(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supports(StoredDomainEvent storedDomainEvent) {
        return storedDomainEvent.domainEventClassName().equals("mk.ukim.finki.emt.musicshop.albumscatalog.domain.event.OrderItemAdded");
    }

    @Override
    public Optional<DomainEvent> translate(StoredDomainEvent remoteEvent) {
        return Optional.of(remoteEvent.toDomainEvent(objectMapper, mk.ukim.finki.emt.musicshop.albumscatalog.integration.OrderItemAddedEvent.class));
    }
}
