package edu.eci.ieti.lab1.controller.health.controller;

import edu.eci.ieti.lab1.controller.health.exception.UserNotFoundException;
import edu.eci.ieti.lab1.controller.health.repository.User;
import edu.eci.ieti.lab1.controller.health.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users/")
public class UsersController {

    private final UsersService usersService;

    public UsersController(@Autowired UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        URI createdUserUri = URI.create("/v1/users/" + user.getId());
        return ResponseEntity.created(createdUserUri).body(usersService.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(usersService.all());
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable("id") String id) {
        Optional<User> user = usersService.findById(id);
        if (user.isEmpty()) throw new UserNotFoundException(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        Optional<User> optionalUser = usersService.findById(id);
        if (optionalUser.isEmpty()) throw new UserNotFoundException(id);
        usersService.update(user, id);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        if (usersService.findById(id).isEmpty()) throw new UserNotFoundException(id);
        usersService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
