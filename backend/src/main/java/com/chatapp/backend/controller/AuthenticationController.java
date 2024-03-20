package com.chatapp.backend.controller;

import com.chatapp.backend.service.AuthenticationService;
import com.chatapp.backend.service.dto.auth.AuthenticationRequestDTO;
import com.chatapp.backend.service.dto.auth.AuthenticationResponseDTO;
import com.chatapp.backend.service.dto.userCreate.UserCreateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/users")
    public ResponseEntity<AuthenticationResponseDTO> registerUser(@Valid @RequestBody UserCreateRequestDTO request) {
        return ResponseEntity.ok(authService.registerUser(request));
    }

    @PostMapping("/users/auth")
    public ResponseEntity<AuthenticationResponseDTO> authenticateUser(@Valid @RequestBody AuthenticationRequestDTO request) {
        return ResponseEntity.ok(authService.authenticateUser(request));
    }
}
