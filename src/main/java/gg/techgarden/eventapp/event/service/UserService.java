package gg.techgarden.eventapp.event.service;

import gg.techgarden.eventapp.event.data.User;
import gg.techgarden.eventapp.event.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User u) {
        User user = User.builder().email(u.getEmail()).phone(u.getPhone()).name(u.getName()).build();
        List<User> foundUsers;
        if (StringUtils.isNotBlank(user.getEmail()) && StringUtils.isNotBlank(user.getPhone())) {
            foundUsers = userRepository.findByPhoneOrEmailIgnoreCase(user.getPhone(), user.getEmail());
        } else if (StringUtils.isNotBlank(user.getEmail())) {
            foundUsers = userRepository.findByEmailIgnoreCase(user.getEmail());
        } else if (StringUtils.isNotBlank(user.getPhone())) {
            foundUsers = userRepository.findByPhone(user.getPhone());
        } else {
            return user;
        }
        if (foundUsers.isEmpty()) {
            return userRepository.save(user);
        }
        User foundUser = foundUsers.get(0);
        foundUsers.forEach(f -> {
            foundUser.setPhone(StringUtils.defaultIfEmpty(foundUser.getPhone(), f.getPhone()));
            foundUser.setEmail(StringUtils.defaultIfEmpty(foundUser.getEmail(), f.getEmail()));
        });
        if (foundUsers.size() > 1) {
            log.error("Found multiple users with duplicate emails or phones: ${}", foundUsers.stream().map(User::getId).collect(Collectors.toList()));
            userRepository.deleteAll(foundUsers);
        }
        return userRepository.save(foundUser);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
