package gemstar;

import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class PersonService implements IPersonService {

    @Override
    public List<Person> getAll() {
        return Person.listAll(Sort.by("id"));
    }

    @Override
    public Person getById(UUID id) {
        return Person.findById(id);
    }

    @Override
    @Transactional
    public Response create(Person person) {
        if (person == null) {
            throw new WebApplicationException("Id was invalidly set on request.", 422);
        }

        person.persist();

        return Response.ok(person).status(Response.Status.CREATED).build();
    }

    @Override
    @Transactional
    public Response update(UUID id, Person person) {
        if (person == null) {
            throw new WebApplicationException("Person name was not set on request.", 422);
        }

        Person entity = Person.findById(id);
        if (entity != null) {
            entity.setFirstName(person.getFirstName());
            entity.setLastName(person.getLastName());
            entity.setEmail(person.getEmail());
            entity.setAge(person.getAge());
            return Response.ok(entity).build();
        } else {
            return Response.ok().status(Response.Status.NOT_FOUND).build();
        }
    }

    @Override
    @Transactional
    public Response delete(UUID id) {
        Person entity = Person.findById(id);
        if (entity != null) {
            entity.delete();
            return Response.ok().status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.ok().status(Response.Status.NOT_FOUND).build();
        }
    }
}

