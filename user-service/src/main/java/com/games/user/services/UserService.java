package com.games.user.services;

import com.games.user.domain.User;
import com.games.user.model.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<User> listAllUsers();
    UserDto findUserById(Long id);
    UserDto findUserByEmail(String email);
    void updateUserById(UUID userId, UserDto userDto);
    void deleteUserById(UUID userId);
}
