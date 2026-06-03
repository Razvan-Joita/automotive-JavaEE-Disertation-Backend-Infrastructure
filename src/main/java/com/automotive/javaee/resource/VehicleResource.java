package com.automotive.javaee.resource;

import com.automotive.javaee.dto.VehicleDTO;
import com.automotive.javaee.service.VehicleService;
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

@Path("/v1/vehicles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Vehicle")
public class VehicleResource {

    @Inject
    private VehicleService service;

    @GET
    @Counted(name = "vehicle_list_count", description = "Number of list calls")
    @Timed(name = "vehicle_list_time", description = "Time spent listing")
    @Operation(summary = "List all vehicles")
    public List<VehicleDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get one vehicle by id")
    public VehicleDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Operation(summary = "Create a new vehicle")
    public Response create(@Valid VehicleDTO dto) {
        VehicleDTO created = service.create(dto);
        return Response.created(URI.create("/api/vehicles/" + created.getId())).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update an existing vehicle")
    public VehicleDTO update(@PathParam("id") Long id, @Valid VehicleDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete a vehicle")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
