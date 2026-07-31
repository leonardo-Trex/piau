package mercurio.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mercurio.service.interfaces.GroupProjectService;
import mercurio.service.interfaces.TopicService;

@Path("/group_projects")
public class GroupProjectResource {

    @Inject
    GroupProjectService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {

        return Response.ok(service.findAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {

        return Response.ok(service.findById(id)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        service.deleteById(id);
        return Response.ok().build();
    }
}
