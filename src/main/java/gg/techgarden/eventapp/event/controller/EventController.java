package gg.techgarden.eventapp.event.controller;

import gg.techgarden.eventapp.event.data.Event;
import gg.techgarden.eventapp.event.data.Guest;
import gg.techgarden.eventapp.event.data.User;
import gg.techgarden.eventapp.event.service.EventService;
import gg.techgarden.eventapp.event.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(value="/event")
@AllArgsConstructor
@Slf4j
@CrossOrigin
public class EventController {

    private final EventService eventService;
    private final UserService userService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Event testGet() {
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        Jwt jwt = (Jwt) securityContext.getAuthentication().getPrincipal();
        return test();
    }

    @PostMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Event testPost() {
        return test();
    }

    private Event test() {
//        User host3 = User.builder().name("Caroline McKinney").phone("1234567890").email("caroline.m.mckinney@gmail.com").build();
//        Guest guest13 = Guest.builder().id(UUID.randomUUID().toString()).name("Keagan Lipak").email("keaganlipak@gmail.com").build();
//        Guest guest23 = Guest.builder().id(UUID.randomUUID().toString()).name("Steven Barker").phone("1231231234").build();
//        Guest guest33 = Guest.builder().id(UUID.randomUUID().toString()).name("Kian Alikhani").phone("7036151234").build();
//        Set<Guest> guestList3 = Set.of(
//                guest13, guest23, guest33
//        );
//        Event event3 = Event.builder().host(host3).title("test").description("test description").guestList(guestList3).build();
//        event3 = eventService.createEvent(event3);
//
//        User host2 = User.builder().name("Caroline McKinney").phone("1234567890").email("caroline.m.mckinney@gmail.com").build();
//        Guest guest12 = Guest.builder().id(UUID.randomUUID().toString()).name("Keagan Lipak").email("keaganlipak@gmail.com").build();
//        Guest guest22 = Guest.builder().id(UUID.randomUUID().toString()).name("Steven Barker").phone("1231231234").build();
//        Guest guest32 = Guest.builder().id(UUID.randomUUID().toString()).name("Kian Alikhani").email("kiansalikhani@gmail.com").build();
//        Set<Guest> guestList2 = Set.of(
//                guest12, guest22, guest32
//        );
//        Event event2 = Event.builder().host(host2).title("test").description("test description").guestList(guestList2).build();
//        event2 = eventService.createEvent(event2);
//
//        User host = User.builder().name("Kian Alikhani").phone("7036151234").email("kiansalikhani@gmail.com").build();
//        Guest guest1 = Guest.builder().id(UUID.randomUUID().toString()).name("Caroline McKinney").phone("1234567890").build();
//        Guest guest2 = Guest.builder().id(UUID.randomUUID().toString()).name("Steven Barker").phone("1231231234").build();
//        Guest guest3 = Guest.builder().id(UUID.randomUUID().toString()).name("Brian Mandel").phone("1231237890").build();
//        Set<Guest> guestList = Set.of(
//                guest1, guest2, guest3
//        );
//        Event event = Event.builder().host(host).title("test").description("test description").guestList(guestList).build();
//        log.info(event.toString());
//        event = eventService.createEvent(event);
//
//        log.info(event.toString());
//        eventService.deleteAllEvents();
//        userService.deleteAllUsers();
//        return event;
        return null;
    }

    @PostMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Event getEvent(@PathVariable String id) {
        return eventService.getEvent(id);
    }

    @DeleteMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllEvents() {
        eventService.deleteAllEvents();
    }
}
