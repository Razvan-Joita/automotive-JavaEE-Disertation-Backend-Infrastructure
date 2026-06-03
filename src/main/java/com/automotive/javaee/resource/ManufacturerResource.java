package com.automotive.javaee.resource;

import com.automotive.javaee.dto.ManufacturerDTO;
import com.automotive.javaee.service.ManufacturerService;
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

@Path("/v1/manufacturers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Manufacturer")
public class ManufacturerResource {

    @Inject
    private ManufacturerService service;

    @GET
    @Counted(name = "manufacturer_list_count", description = "Number of list calls")
    @Timed(name = "manufacturer_list_time", description = "Time spent listing")
    @Operation(summary = "List all manufacturers")
    public List<ManufacturerDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get one manufacturer by id")
    public ManufacturerDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Operation(summary = "Create a new manufacturer")
    public Response create(@Valid ManufacturerDTO dto) {
        ManufacturerDTO created = service.create(dto);
        return Response.created(URI.create("/api/manufacturers/" + created.getId())).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update an existing manufacturer")
    public ManufacturerDTO update(@PathParam("id") Long id, @Valid ManufacturerDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete a manufacturer")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
