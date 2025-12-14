package org.cinema.reservations.services;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class MovieService {

    private static final Map<Long, String> movies = Map.ofEntries(Map.entry(1L, "About time"), Map.entry(2L, "The Holiday"));

    public Optional<String> findMovie(long movieId) {
        return Optional.ofNullable(movies.get(movieId));
    }

}
