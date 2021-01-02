package com.example.service;

import com.example.dto.UserDto;
import com.example.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserDto userDto);
}
