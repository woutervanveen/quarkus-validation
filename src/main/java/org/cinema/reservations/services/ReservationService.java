package org.cinema.reservations.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.cinema.reservations.domain.Reservation;
import org.cinema.reservations.services.validators.MovieScreeningValidator;

@ApplicationScoped
public class ReservationService {

  private final MovieScreeningValidator movieScreeningValidator;

  public ReservationService(MovieScreeningValidator movieScreeningValidator) {
    this.movieScreeningValidator = movieScreeningValidator;
  }

  public void makeReservation(Reservation reservation) {
    movieScreeningValidator.validate(reservation);
  }
}
