package mercurio.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mercurio.dto.group_project.GroupProjectCreateDTO;
import mercurio.dto.group_project.GroupProjectResponseDTO;
import mercurio.service.interfaces.GroupProjectService;

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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(GroupProjectCreateDTO dto) {

        GroupProjectResponseDTO response = service.create(dto);
        return Response
                .status(Response.Status.CREATED)
                .entity(response)
                .build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(GroupProjectCreateDTO dto, @PathParam("id")Long id) {

        service.update(dto, id);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {

        service.deleteById(id);
        return Response.ok().build();
    }
}
