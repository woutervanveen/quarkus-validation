package org.cinema.reservations.api.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.cinema.reservations.api.model.ReservationRequest;

public class CheckSeatIsAllowedConstraint
    implements ConstraintValidator<CheckSeatIsAllowed, ReservationRequest> {
  @Override
  public boolean isValid(
      ReservationRequest reservationRequest,
      ConstraintValidatorContext constraintValidatorContext) {

    if (reservationRequest.seatNumber() == null) {
      return false;
    }

    return switch (reservationRequest.ticketType()) {
      case TOP -> true;
      case BACK -> reservationRequest.seatNumber().contains("E");
      case NORMAL -> !reservationRequest.seatNumber().contains("C");
    };
  }
}
