package edu.eci.ieti.lab1.service;

import edu.eci.ieti.lab1.model.User;
import edu.eci.ieti.lab1.repository.UserRepository;
import edu.eci.ieti.lab1.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceMap implements UsersService {

    private final UserRepository userRepository;

    @Autowired
    public UsersServiceMap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }


    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> all() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User user, String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User userUpdate = optionalUser.get();
            userUpdate.setName(user.getName());
            userUpdate.setLastName(user.getEmail());
            userUpdate.setLastName(user.getLastName());
            return userRepository.save(userUpdate);
        } return null;
    }
}
