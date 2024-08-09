package com.vti.springframework.validation;

import com.vti.springframework.reponsitory.CommentReponsitory;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommentIdExistsValidator implements ConstraintValidator<CommentIdExists, Long> {
    private CommentReponsitory commentReponsitory;
    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        return commentReponsitory.existsById(id);
    }
}
