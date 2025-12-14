package org.cinema.reservations.api;

import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.cinema.reservations.api.model.ReservationRequest;
import org.cinema.reservations.api.model.TicketTypeRequest;
import org.cinema.reservations.domain.Reservation;
import org.cinema.reservations.domain.TicketType;
import org.cinema.reservations.services.ReservationService;

@Path("/api/v1/reservations")
public class ReservationResource {

  private final ReservationService reservationService;

  public ReservationResource(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  @POST
  public void makeReservation(@Valid ReservationRequest reservationRequest) {
    reservationService.makeReservation(
        new Reservation(
            reservationRequest.customerName(),
            reservationRequest.seatNumber(),
            mapTicketType(reservationRequest.ticketType()),
            reservationRequest.movieId(),
            reservationRequest.reservationDate()));
  }

  private TicketType mapTicketType(TicketTypeRequest ticketTypeRequest) {
    return switch (ticketTypeRequest) {
      case TOP -> TicketType.TOP;
      case BACK -> TicketType.BACK;
      case NORMAL -> TicketType.NORMAL;
    };
  }
}
