package edu.eci.ieti.lab1.controller.health.service;

import edu.eci.ieti.lab1.controller.health.repository.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class UsersServiceMap implements UsersService {

    private final HashMap<String, User> users = new HashMap<>();

    @Override
    public User save(User user) {
        return users.put(user.getId(), user);
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public List<User> all() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void deleteById(String id) {
        users.remove(id);
    }

    @Override
    public User update(User user, String userId) {
        return users.put(userId, user);
    }
}
