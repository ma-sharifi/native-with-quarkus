package org.example;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.example.dto.CustomerDto;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class CustomerEndpointTest
{

  @Test
  public void shouldGetOneCustomer()
  {
    given()
        .header(ACCEPT, APPLICATION_JSON)
    .when()
        .get("/customers/1")
    .then()
        .statusCode(OK.getStatusCode())
        .body("name", Is.is("Bob"));
  }

  @Test
  public void shouldGetCustomers() {
    ArrayList actualCustomers =
        given()
            .header(ACCEPT, APPLICATION_JSON)
        .when()
            .get("/customers")
        .then()
            .statusCode(OK.getStatusCode())
            .extract().body().as(ArrayList.class);

    assertEquals(3, actualCustomers.size());

  }

}