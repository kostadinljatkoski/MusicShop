package mk.ukim.finki.emt.musicshop.sharedkernel.domain.base;

import mk.ukim.finki.emt.musicshop.sharedkernel.infra.eventlog.StoredDomainEvent;

import java.util.List;

public interface RemoteEventLog {
    List<StoredDomainEvent> events();
}
