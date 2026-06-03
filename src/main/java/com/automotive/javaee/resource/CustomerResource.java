package com.automotive.javaee.resource;

import com.automotive.javaee.dto.CustomerDTO;
import com.automotive.javaee.service.CustomerService;
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

@Path("/v1/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Customer")
public class CustomerResource {

    @Inject
    private CustomerService service;

    @GET
    @Counted(name = "customer_list_count", description = "Number of list calls")
    @Timed(name = "customer_list_time", description = "Time spent listing")
    @Operation(summary = "List all customers")
    public List<CustomerDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get one customer by id")
    public CustomerDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Operation(summary = "Create a new customer")
    public Response create(@Valid CustomerDTO dto) {
        CustomerDTO created = service.create(dto);
        return Response.created(URI.create("/api/customers/" + created.getId())).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update an existing customer")
    public CustomerDTO update(@PathParam("id") Long id, @Valid CustomerDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete a customer")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
