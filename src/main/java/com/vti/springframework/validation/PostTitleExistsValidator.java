package com.vti.springframework.validation;

import com.vti.springframework.reponsitory.PostRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PostTitleExistsValidator implements ConstraintValidator<PostTitleExists, String> {
    private PostRepository postRepository;

    @Override
    public boolean isValid(String title, ConstraintValidatorContext constraintValidatorContext) {
        return postRepository.existsByTitle(title);
    }
}
