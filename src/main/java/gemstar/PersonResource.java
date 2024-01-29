package gemstar;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@RunOnVirtualThread
@Path("/api/person")
@Produces("application/json")
@Consumes("application/json")
public class PersonResource {

    @Inject
    IPersonService personService;

    @GET
    public List<Person> get() {
        return personService.getAll();
    }

    @GET
    @Path("{id}")
    public Person getSingle(@PathParam("id") UUID id) {
        return personService.getById(id);
    }

    @POST
    public Response create(Person person) {
        return personService.create(person);
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") UUID id, Person person) {
        return personService.update(id, person);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") UUID id) {
        return personService.delete(id);
    }
}

