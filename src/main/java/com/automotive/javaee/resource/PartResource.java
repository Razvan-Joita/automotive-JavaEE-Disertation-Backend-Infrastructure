package com.automotive.javaee.resource;

import com.automotive.javaee.dto.PartDTO;
import com.automotive.javaee.service.PartService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URI;
import java.util.List;

@Path("/parts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Part")
public class PartResource {

    @Inject
    private PartService service;

    @GET
    @Counted(name = "part_list_count", description = "Number of list calls")
    @Timed(name = "part_list_time", description = "Time spent listing")
    @Operation(summary = "List all parts")
    public List<PartDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get one part by id")
    public PartDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Operation(summary = "Create a new part")
    public Response create(@Valid PartDTO dto) {
        PartDTO created = service.create(dto);
        return Response.created(URI.create("/api/parts/" + created.getId())).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update an existing part")
    public PartDTO update(@PathParam("id") Long id, @Valid PartDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete a part")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
