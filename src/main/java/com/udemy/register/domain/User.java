package com.udemy.register.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Document(collection = "users")
public class User {

    @MongoId
    private String id;

    private String name;

    private String password;

    private LocalDate dateOfBirth;

    public User() {
    }

    public User(String id, String name, String password, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}