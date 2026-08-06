package mercurio.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mercurio.dto.exam.ExamCreateDTO;
import mercurio.dto.exam.ExamResponseDTO;
import mercurio.service.interfaces.ExamService;
import mercurio.service.interfaces.TopicService;

@Path("/exams")
public class ExamResource {

    @Inject
    ExamService service;

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
    public Response create(ExamCreateDTO createDTO) {
        ExamResponseDTO responseDTO = service.create(createDTO);
        return Response.status(Response.Status.CREATED).entity(responseDTO).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, ExamCreateDTO dto) {
        service.update(id, dto);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("id") Long id) {
        service.deleteById(id);
        return Response.ok().build();
    }
}
