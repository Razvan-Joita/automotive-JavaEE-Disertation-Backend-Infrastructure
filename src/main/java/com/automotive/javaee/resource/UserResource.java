package com.automotive.javaee.resource;

import com.automotive.javaee.dto.UserDTO;
import com.automotive.javaee.service.UserService;
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

@Path("/v1/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "User")
public class UserResource {

    @Inject
    private UserService service;

    @GET
    @Counted(name = "user_list_count", description = "Number of list calls")
    @Timed(name = "user_list_time", description = "Time spent listing")
    @Operation(summary = "List all users")
    public List<UserDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get one user by id")
    public UserDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Operation(summary = "Create a new user")
    public Response create(@Valid UserDTO dto) {
        UserDTO created = service.create(dto);
        return Response.created(URI.create("/api/users/" + created.getId())).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update an existing user")
    public UserDTO update(@PathParam("id") Long id, @Valid UserDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete a user")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
