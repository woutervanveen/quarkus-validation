package org.cinema.reservations.api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.Instant;
import org.cinema.reservations.api.validation.CheckSeatIsAllowed;

@CheckSeatIsAllowed
public record ReservationRequest(
    @NotNull @NotBlank String customerName,
    @NotNull @NotBlank @Pattern(regexp = "^[A-E]([1-9]|10)$") String seatNumber,
    @NotNull TicketTypeRequest ticketType,
    @NotNull Long movieId,
    @NotNull Instant reservationDate) {}
