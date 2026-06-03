package com.automotive.javaee.resource;

import com.automotive.javaee.dto.EmployeeDTO;
import com.automotive.javaee.service.EmployeeService;
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

@Path("/v1/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Employee")
public class EmployeeResource {

    @Inject
    private EmployeeService service;

    @GET
    @Counted(name = "employee_list_count", description = "Number of list calls")
    @Timed(name = "employee_list_time", description = "Time spent listing")
    @Operation(summary = "List all employees")
    public List<EmployeeDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get one employee by id")
    public EmployeeDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Operation(summary = "Create a new employee")
    public Response create(@Valid EmployeeDTO dto) {
        EmployeeDTO created = service.create(dto);
        return Response.created(URI.create("/api/employees/" + created.getId())).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update an existing employee")
    public EmployeeDTO update(@PathParam("id") Long id, @Valid EmployeeDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete a employee")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
