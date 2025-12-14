package org.cinema.reservations.api;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.time.Instant;
import java.util.List;
import org.cinema.reservations.api.model.ReservationRequest;
import org.cinema.reservations.api.model.TicketTypeRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ReservationResourceValidationTest {

  private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  private static List<Arguments> provideInvalidReservations() {
    return List.of(
        Arguments.of(new ReservationRequest(null, null, null, null, null)),
        Arguments.of(
            new ReservationRequest(
                "Donal Duck",
                "1D",
                TicketTypeRequest.TOP,
                1L,
                Instant.parse("2025-01-01T12:00:00Z"))),
        Arguments.of(
            new ReservationRequest(
                "Donal Duck",
                "A1",
                TicketTypeRequest.BACK,
                1L,
                Instant.parse("2025-01-01T12:00:00Z"))),
        Arguments.of(
            new ReservationRequest(
                "Donal Duck",
                "C1",
                TicketTypeRequest.NORMAL,
                1L,
                Instant.parse("2025-01-01T12:00:00Z"))));
  }

  @Test
  void valid_case() {
    var reservationRequest =
        new ReservationRequest(
            "Donal Duck", "A1", TicketTypeRequest.TOP, 1L, Instant.parse("2025-01-01T12:00:00Z"));

    var result = validator.validate(reservationRequest);

    assertThat(result).isEmpty();
  }

  @ParameterizedTest
  @MethodSource("provideInvalidReservations")
  void invalid_cases(ReservationRequest reservationRequest) {
    assertThat(validator.validate(reservationRequest)).isNotEmpty();
  }
}
