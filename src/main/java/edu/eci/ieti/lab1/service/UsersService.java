package edu.eci.ieti.lab1.service;

import edu.eci.ieti.lab1.model.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    User save(User user);

    Optional<User> findById(String id);

    Optional<User> findByEmail(String email);

    List<User> all();

    void deleteById(String id);

    User update(User user, String userId);
}
