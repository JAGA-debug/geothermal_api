package com.example.geothermal.service;

import com.example.geothermal.dto.LoginRequest;
import com.example.geothermal.dto.LoginResponse;
import com.example.geothermal.entity.User;
import com.example.geothermal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginResponse login(LoginRequest request) {

        Optional<User> userOptional =
                userRepository.findByUsername(request.getUsername());

        if (userOptional.isEmpty()) {

            return new LoginResponse(
                    false,
                    "Invalid username or password",
                    null,
                    null
            );
        }

        User user = userOptional.get();

        if (!user.getPassword().equals(request.getPassword())) {

            return new LoginResponse(
                    false,
                    "Invalid username or password",
                    null,
                    null
            );
        }

        if (user.getStatus() != null
                && !"Active".equalsIgnoreCase(user.getStatus())) {

            return new LoginResponse(
                    false,
                    "User account is inactive",
                    null,
                    null
            );
        }

        return new LoginResponse(
                true,
                "Login successful",
                user.getUsername(),
                user.getRole()
        );
    }
}