package gg.techgarden.eventapp.event.repository;

import gg.techgarden.eventapp.event.data.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {
}
