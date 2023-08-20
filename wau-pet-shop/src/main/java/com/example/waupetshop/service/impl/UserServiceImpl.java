package com.example.waupetshop.service.impl;

import com.example.waupetshop.dto.UserDto;
import com.example.waupetshop.entity.Role;
import com.example.waupetshop.entity.User;
import com.example.waupetshop.mapper.UserMapper;
import com.example.waupetshop.repository.CartRepository;
import com.example.waupetshop.repository.RoleRepository;
import com.example.waupetshop.repository.UserReponsitory;
import com.example.waupetshop.service.CartService;
import com.example.waupetshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserReponsitory userReponsitory;

    private final RoleRepository roleRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(UserDto userDto) {
        User user = userMapper.dtoToEntity(userDto);
        if (!userDto.getPassword().isEmpty()) {
//            passwordEncoder.encode(userDto.getPassword());
            String hashedPassword = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt(10));
            user.setPassword(hashedPassword);
        }
        Role role = roleRepository.findById(2L).orElse(null);
        user.getRoles().add(role);
        userReponsitory.save(user);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userReponsitory.findById(id).orElse(null);
        return userMapper.entityToDto(user);
    }

    @Override
    public UserDto findByEmail(String email) {
        User user = userReponsitory.findByEmail(email);
        return userMapper.entityToDto(user);
    }
}
