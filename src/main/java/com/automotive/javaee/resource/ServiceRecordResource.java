package com.automotive.javaee.resource;

import com.automotive.javaee.dto.ServiceRecordDTO;
import com.automotive.javaee.service.ServiceRecordService;
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

@Path("/service-records")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "ServiceRecord")
public class ServiceRecordResource {

    @Inject
    private ServiceRecordService service;

    @GET
    @Counted(name = "servicerecord_list_count", description = "Number of list calls")
    @Timed(name = "servicerecord_list_time", description = "Time spent listing")
    @Operation(summary = "List all service records")
    public List<ServiceRecordDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get one service record by id")
    public ServiceRecordDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Operation(summary = "Create a new service record")
    public Response create(@Valid ServiceRecordDTO dto) {
        ServiceRecordDTO created = service.create(dto);
        return Response.created(URI.create("/api/service-records/" + created.getId())).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update an existing service record")
    public ServiceRecordDTO update(@PathParam("id") Long id, @Valid ServiceRecordDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete a service record")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
