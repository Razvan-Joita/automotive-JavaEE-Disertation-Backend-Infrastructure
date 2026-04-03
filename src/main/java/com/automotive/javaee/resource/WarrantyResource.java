package com.automotive.javaee.resource;

import com.automotive.javaee.dto.WarrantyDTO;
import com.automotive.javaee.service.WarrantyService;
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

@Path("/warranties")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Warranty")
public class WarrantyResource {

    @Inject
    private WarrantyService service;

    @GET
    @Counted(name = "warranty_list_count", description = "Number of list calls")
    @Timed(name = "warranty_list_time", description = "Time spent listing")
    @Operation(summary = "List all warranties")
    public List<WarrantyDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get one warranty by id")
    public WarrantyDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Operation(summary = "Create a new warranty")
    public Response create(@Valid WarrantyDTO dto) {
        WarrantyDTO created = service.create(dto);
        return Response.created(URI.create("/api/warranties/" + created.getId())).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update an existing warranty")
    public WarrantyDTO update(@PathParam("id") Long id, @Valid WarrantyDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete a warranty")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
