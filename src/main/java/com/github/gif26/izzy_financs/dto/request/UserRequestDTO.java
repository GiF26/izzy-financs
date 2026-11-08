package com.github.gif26.izzy_financs.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDTO (@NotBlank(message = "Nome nao pode ser vazio")
                              String name,
                              @Email(message = "E-mail inválido")
                              @NotBlank(message = "email nao pode ser vazio")
                              String email,
                              @NotBlank(message = "senha nao pode ser vazio")
                              @Size(min = 8, message = "a senha deve ter no minimo 8 caracteres")
                              String password) {

}