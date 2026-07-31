package mercurio.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mercurio.service.interfaces.TopicService;

@Path("/topics")
public class TopicResource {

    @Inject
    TopicService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {

        return Response.ok(service.findAll()).build();
    }
}
