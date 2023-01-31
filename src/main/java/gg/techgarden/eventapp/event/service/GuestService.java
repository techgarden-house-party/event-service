package gg.techgarden.eventapp.event.service;

import gg.techgarden.eventapp.event.data.Event;
import gg.techgarden.eventapp.event.data.Guest;
import gg.techgarden.eventapp.event.data.User;
import gg.techgarden.eventapp.event.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class GuestService {

    private final UserService userService;

    public void setHostInvites(Event event) {
        if (CollectionUtils.isEmpty(event.getGuestList())) {
            return;
        }
        event.getGuestList().forEach(g -> {
            if (StringUtils.isBlank(g.getInvitedBy())) {
                g.setInvitedBy(event.getHost().getId());
            };
        });
    }

    public void saveGuests(Set<Guest> guestList) {
        guestList.stream().forEach(g -> {
            g.setId(null);
            User u = userService.saveUser(g);
            g.setId(u.getId());
            g.setName(u.getName());
            g.setPhone(u.getPhone());
            g.setEmail(u.getEmail());
        });

    }

    public void sendNotifications(Set<Guest> guestList) {
        if (CollectionUtils.isEmpty(guestList)) {
            return;
        }
        guestList.stream().filter(g -> !g.getNotified()).forEach(this::sendNotification);
    }

    private void sendNotification(Guest guest) {
        log.info("Notifying guest with id: {}", guest.getId());
        guest.setNotified(Boolean.TRUE);
        guest.setNotifiedDateTime(LocalDateTime.now());
    }
}
