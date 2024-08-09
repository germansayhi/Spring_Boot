package com.vti.springframework.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(
        validatedBy = CommentIdExistsValidator.class
)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CommentIdExists {
    String message() default "Comment id does not exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

