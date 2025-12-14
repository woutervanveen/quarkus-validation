package org.cinema.reservations.domain;

import java.time.Instant;

public record MovieScreening(Long movieId, String movieName, Instant screeningTime) {}
