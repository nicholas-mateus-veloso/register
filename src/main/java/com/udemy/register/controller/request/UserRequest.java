package com.udemy.register.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserRequest {

    @NotBlank
    @Size(min = 3, max = 10, message = "O tamanho deve ser entre 3 e 10")
    private String name;

    @NotBlank
    @Size(min = 4, max = 6, message = "O tamanho deve ser entre 4 e 6")
    private String password;

    @NotNull(message = "O campo de data não pode ser nulo")
    private LocalDate dateOfBirth;

    public UserRequest(String name, String password, LocalDate dateOfBirth) {
        this.name = name;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public UserRequest() {
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
