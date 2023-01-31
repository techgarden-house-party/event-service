package gg.techgarden.eventapp.event.service;

import gg.techgarden.eventapp.event.data.Event;
import gg.techgarden.eventapp.event.data.Guest;
import gg.techgarden.eventapp.event.repository.EventRepository;
import gg.techgarden.eventapp.event.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponse;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class EventService {
    private final EventRepository eventRepository;
    private final GuestService guestService;

    private final UserService userService;

    private final UserRepository userRepository;

    public Event createEvent(Event event) {
        event.setHost(userService.saveUser(event.getHost()));
        guestService.setHostInvites(event);
        guestService.saveGuests(event.getGuestList());
        guestService.sendNotifications(event.getGuestList());
        return eventRepository.save(event);
    }

    public Event saveEvent(Event event) {
        guestService.sendNotifications(event.getGuestList());
        return eventRepository.save(event);
    }

    public Event getEvent(String eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
    }

    public void deleteEvent(String eventId) {
        eventRepository.deleteById(eventId);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public void deleteAllEvents() {
        eventRepository.deleteAll();
    }
}
