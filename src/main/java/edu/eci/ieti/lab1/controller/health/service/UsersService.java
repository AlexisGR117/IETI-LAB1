package edu.eci.ieti.lab1.controller.health.service;

import edu.eci.ieti.lab1.controller.health.repository.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    User save(User user);

    Optional<User> findById(String id);

    List<User> all();

    void deleteById(String id);

    User update(User user, String userId);
}
