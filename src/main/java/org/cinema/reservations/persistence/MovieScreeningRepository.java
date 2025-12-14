package org.cinema.reservations.persistence;

import jakarta.enterprise.context.ApplicationScoped;
import java.time.Instant;
import java.util.Map;
import java.util.Optional;
import org.cinema.reservations.domain.MovieScreening;

@ApplicationScoped
public class MovieScreeningRepository {
  private static final Map<Long, MovieScreening> movieScreenings =
      Map.ofEntries(
          Map.entry(
              1L, new MovieScreening(1L, "About time", Instant.parse("2013-10-13T12:00:00Z"))));

  public Optional<MovieScreening> findMovieScreeningById(long movieId) {
    return Optional.ofNullable(movieScreenings.get(movieId));
  }
}
