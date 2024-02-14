package edu.eci.ieti.lab1.repository;

import edu.eci.ieti.lab1.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
