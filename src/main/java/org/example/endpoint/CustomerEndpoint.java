package org.example.endpoint;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.example.dto.CustomerDto;

@Path("/customers")
public class CustomerEndpoint
{
   static Map<Long , CustomerDto> customers= new HashMap<>();
  static {
    customers.put(1L, new CustomerDto(1L,"Bob"));
    customers.put(2L, new CustomerDto(2L,"Alex"));
    customers.put(3L, new CustomerDto(3L,"Mark"));
  }

   static  Random random = new Random();

    @GET
    @Path("random")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getRandom() {
        return Response.ok(random.nextInt(100)).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOneCustomer(@PathParam("id") Long id) {
        return Response.ok(customers.get(id)).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomers() {
        return Response.ok(customers.entrySet().stream().toList()).build();
    }
}