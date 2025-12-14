package org.cinema.reservations.services.validators;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.ValidationException;
import org.cinema.reservations.domain.Reservation;
import org.cinema.reservations.persistence.MovieScreeningRepository;

@ApplicationScoped
public class MovieScreeningValidator {

  private final MovieScreeningRepository movieScreeningRepository;

  public MovieScreeningValidator(MovieScreeningRepository movieScreeningRepository) {
    this.movieScreeningRepository = movieScreeningRepository;
  }

  public void validate(Reservation reservation) {
    if (movieScreeningRepository.findMovieScreeningById(reservation.movieId()).isEmpty()) {
      throw new ValidationException("The movie is not screening");
    }
  }
}
