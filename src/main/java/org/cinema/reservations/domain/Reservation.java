package org.cinema.reservations.domain;

import java.time.Instant;

public record Reservation(
    String customerName,
    String seatNumber,
    TicketType ticketType,
    Long movieId,
    Instant reservationDate) {}
