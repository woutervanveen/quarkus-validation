package org.cinema.reservations.api.model;

import java.time.Instant;

public record ReservationRequest(String customerName, String seatNumber, TicketType ticketType, Long movieId,
                                 Instant reservationDate) {
}
