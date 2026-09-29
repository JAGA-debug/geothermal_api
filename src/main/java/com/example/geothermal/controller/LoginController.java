package com.example.geothermal.controller;

import com.example.geothermal.dto.LoginRequest;
import com.example.geothermal.dto.LoginResponse;
import com.example.geothermal.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {

        LoginResponse response =
                loginService.login(request);

        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(401).body(response);
    }
}