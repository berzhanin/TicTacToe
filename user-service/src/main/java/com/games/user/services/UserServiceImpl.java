package com.games.user.services;

import com.games.user.domain.User;
import com.games.user.model.UserDto;
import com.games.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> listAllUsers() {

        User user = new User(UUID.randomUUID(), "alex", "email", "pass");
        List<User> userList = new ArrayList<>();

        if (user != null && !ObjectUtils.isEmpty(user.getId())) {
            userList = userRepository.findAllUsers();
        }
        return userList;
    }

    @Override
    public UserDto findUserById(UUID userId) {

        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            return UserDto.builder().build();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found. UUID: " + userId);
        }
    }

    @Override
    public UserDto findUserByEmail(String email) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findUserByEmail(email));

        if (userOptional.isPresent()) {
            return UserDto.builder().build();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found. Email: " + email);
        }
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        return null;
    }

    @Override
    public void updateUserById(UUID userId, UserDto userDto) {
        Optional<User> userOptional = userRepository.findById(userId);

        userOptional.ifPresentOrElse(user -> {
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            userRepository.save(user);
        }, () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found. UUID: " + userId);
        });
    }

    @Override
    public void deleteUserById(UUID userId) {
        userRepository.deleteById(userId);
    }
}
