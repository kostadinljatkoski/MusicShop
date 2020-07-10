package mk.ukim.finki.emt.musicshop.sharedkernel.infra.eventlog;

import mk.ukim.finki.emt.musicshop.sharedkernel.domain.base.DomainEvent;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RemoteEventTranslator {

    boolean supports(StoredDomainEvent storedDomainEvent);

    Optional<DomainEvent> translate(StoredDomainEvent remoteEvent);
}
