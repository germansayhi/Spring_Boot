package com.vti.springframework.service;

import com.vti.springframework.dto.UserDto;
import com.vti.springframework.form.UserCreatedForm;

public interface UserService {
    UserDto create(UserCreatedForm form);
}
