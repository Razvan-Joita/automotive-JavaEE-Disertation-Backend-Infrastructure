package com.automotive.javaee.resource;

import com.automotive.javaee.dto.AppointmentDTO;
import com.automotive.javaee.service.AppointmentService;
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

@Path("/v1/appointments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Appointment")
public class AppointmentResource {

    @Inject
    private AppointmentService service;

    @GET
    @Counted(name = "appointment_list_count", description = "Number of list calls")
    @Timed(name = "appointment_list_time", description = "Time spent listing")
    @Operation(summary = "List all appointments")
    public List<AppointmentDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get one appointment by id")
    public AppointmentDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Operation(summary = "Create a new appointment")
    public Response create(@Valid AppointmentDTO dto) {
        AppointmentDTO created = service.create(dto);
        return Response.created(URI.create("/api/appointments/" + created.getId())).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update an existing appointment")
    public AppointmentDTO update(@PathParam("id") Long id, @Valid AppointmentDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete a appointment")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
