package gemstar;

import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

public interface IPersonService {
    List<Person> getAll();
    Person getById(UUID id);
    Response create(Person person);
    Response update(UUID id, Person person);
    Response delete(UUID id);
}

