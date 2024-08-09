package com.vti.springframework.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class PostUpdateForm {
    @NotBlank(message = "Post title must not be blank")
    @Length(max = 50, message = "Post title max has max 50 characters")
    private String title;

    @NotBlank(message = "Post description must not be blank")
    @Length(max = 75, message = "Post title max has max 75 characters")
    private String description;

    @NotBlank(message = "Post content must not be blank")
    @Length(max = 150, message = "Post title max has max 150 characters")
    private String content;
}
