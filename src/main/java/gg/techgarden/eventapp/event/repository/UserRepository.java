package gg.techgarden.eventapp.event.repository;

import gg.techgarden.eventapp.event.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByPhoneOrEmailIgnoreCase(String phone, String email);
    List<User> findByPhone(String phone);
    List<User> findByEmailIgnoreCase(String email);
}
