package com.example.waupetshop.service;

import com.example.waupetshop.dto.UserDto;

public interface UserService {

    UserDto getUserById(Long id);

    void save(UserDto userDto);

    UserDto findByEmail(String email);
}
