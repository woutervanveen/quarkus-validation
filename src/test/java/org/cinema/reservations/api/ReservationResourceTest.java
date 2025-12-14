package org.cinema.reservations.api;

import static io.restassured.RestAssured.given;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import java.time.Instant;
import org.cinema.reservations.api.model.ReservationRequest;
import org.cinema.reservations.api.model.TicketTypeRequest;
import org.junit.jupiter.api.Test;

@QuarkusTest
class ReservationResourceTest {

  @Test
  void valid_requests_result_in_a_204() {
    var request =
        new ReservationRequest(
            "Donald Duck", "D3", TicketTypeRequest.TOP, 1L, Instant.parse("2025-01-01T12:00:00Z"));
    given()
        .body(request)
        .contentType(ContentType.JSON)
        .when()
        .post("/api/v1/reservations")
        .then()
        .statusCode(204);
  }

  @Test
  void movie_not_screening_results_in_500() {
    var request =
        new ReservationRequest(
            "Donald Duck", "D3", TicketTypeRequest.TOP, 2L, Instant.parse("2025-01-01T12:00:00Z"));
    given()
        .body(request)
        .contentType(ContentType.JSON)
        .when()
        .post("/api/v1/reservations")
        .then()
        .statusCode(500);
  }

  @Test
  void invalid_request_results_in_a_400() {
    var request = new ReservationRequest(null, null, null, null, null);
    given()
        .body(request)
        .contentType(ContentType.JSON)
        .when()
        .post("/api/v1/reservations")
        .then()
        .statusCode(400);
  }
}
