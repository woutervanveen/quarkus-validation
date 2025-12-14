package org.cinema.reservations.api.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckSeatIsAllowedConstraint.class)
public @interface CheckSeatIsAllowed {

  String message() default "Check seat is allowed";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
