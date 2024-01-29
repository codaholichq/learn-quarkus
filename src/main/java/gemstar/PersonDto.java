package gemstar;

import java.io.Serializable;
import java.util.UUID;

public record PersonDto(
    UUID id,
    String firstName,
    String lastName,
    String email,
    int age
) implements Serializable {}
