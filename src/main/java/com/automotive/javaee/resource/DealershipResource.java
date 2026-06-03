package com.automotive.javaee.resource;

import com.automotive.javaee.dto.DealershipDTO;
import com.automotive.javaee.service.DealershipService;
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

@Path("/v1/dealerships")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Dealership")
public class DealershipResource {

    @Inject
    private DealershipService service;

    @GET
    @Counted(name = "dealership_list_count", description = "Number of list calls")
    @Timed(name = "dealership_list_time", description = "Time spent listing")
    @Operation(summary = "List all dealerships")
    public List<DealershipDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get one dealership by id")
    public DealershipDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Operation(summary = "Create a new dealership")
    public Response create(@Valid DealershipDTO dto) {
        DealershipDTO created = service.create(dto);
        return Response.created(URI.create("/api/dealerships/" + created.getId())).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update an existing dealership")
    public DealershipDTO update(@PathParam("id") Long id, @Valid DealershipDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete a dealership")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
