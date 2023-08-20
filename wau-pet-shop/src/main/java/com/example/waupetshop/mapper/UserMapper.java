package com.example.waupetshop.mapper;

import com.example.waupetshop.dto.UserDto;
import com.example.waupetshop.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {
    public List<UserDto> entitiesToDtos(List<User> element) {
        return element.stream()
                .map(this::entityToDto)
                .toList();
    }

    public UserDto entityToDto(User element) {
        UserDto result = new UserDto();
        BeanUtils.copyProperties(element, result);
        return result;
    }

    public User dtoToEntity(UserDto element) {
        User result = new User();
        BeanUtils.copyProperties(element, result);
        return result;
    }
}
