package com.automotive.javaee.resource;

import com.automotive.javaee.dto.InvoiceDTO;
import com.automotive.javaee.service.InvoiceService;
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

@Path("/v1/invoices")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Invoice")
public class InvoiceResource {

    @Inject
    private InvoiceService service;

    @GET
    @Counted(name = "invoice_list_count", description = "Number of list calls")
    @Timed(name = "invoice_list_time", description = "Time spent listing")
    @Operation(summary = "List all invoices")
    public List<InvoiceDTO> findAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get one invoice by id")
    public InvoiceDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    @Operation(summary = "Create a new invoice")
    public Response create(@Valid InvoiceDTO dto) {
        InvoiceDTO created = service.create(dto);
        return Response.created(URI.create("/api/invoices/" + created.getId())).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update an existing invoice")
    public InvoiceDTO update(@PathParam("id") Long id, @Valid InvoiceDTO dto) {
        return service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete a invoice")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
