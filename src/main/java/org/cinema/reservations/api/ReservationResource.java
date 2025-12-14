package org.cinema.reservations.api;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.cinema.reservations.api.model.ReservationRequest;

@Path("/api/v1/reservations")
public class ReservationResource {


    @POST
    public void makeReservation(ReservationRequest reservationRequest) {

    }
}
