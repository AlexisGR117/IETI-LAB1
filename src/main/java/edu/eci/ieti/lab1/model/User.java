package edu.eci.ieti.lab1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Document("users")
public class User {

    @Id
    private String id;
    private Date createdAt;
    private String name;
    private String lastName;
    private String email;
    private String passwordHash;
    private List<UserRoleEnum> roles;

    public User(String id, String name, String lastName, String email, String passwordHash) {
        super();
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.createdAt = new Date();
        this.passwordHash = passwordHash;
        roles = new ArrayList<>(Collections.singleton(UserRoleEnum.USER));
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public List<UserRoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRoleEnum> roles) {
        this.roles = roles;
    }

    public void addRole(UserRoleEnum role) {
        if (!roles.contains(role)) {
            roles.add(role);
        }
    }


}
