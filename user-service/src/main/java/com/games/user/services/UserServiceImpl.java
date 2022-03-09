package com.games.user.services;

import com.games.user.domain.User;
import com.games.user.model.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> listAllUsers() {
        return null;
    }

    @Override
    public UserDto findUserById(Long id) {
        return null;
    }

    @Override
    public UserDto findUserByEmail(String email) {
        return null;
    }

    @Override
    public void updateUserById(UUID userId, UserDto userDto) {

    }

    @Override
    public void deleteUserById(UUID userId) {

    }
}
