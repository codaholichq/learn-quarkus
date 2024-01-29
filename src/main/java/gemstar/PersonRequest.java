package gemstar;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record PersonRequest(
    @NotBlank(message = "First Name cannot be blank")
    String firstName,

    @NotBlank(message = "Last Name cannot be blank")
    String lastName,

    @Email(message = "Enter a valid email address")
    String email,

    @NotBlank(message = "Age name cannot be blank")
    int age
) implements Serializable {}

