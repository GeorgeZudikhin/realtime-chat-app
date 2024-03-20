package com.chatapp.backend.controller;

import com.chatapp.backend.service.UserService;
import com.chatapp.backend.service.dto.passwordChange.PasswordChangeRequestDTO;
import com.chatapp.backend.service.dto.userUpdate.UserUpdateRequestDTO;
import com.chatapp.backend.service.dto.userUpdate.UserUpdateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping("/users/{id}")
    public ResponseEntity<UserUpdateResponseDTO> updateUserProfile(
            @PathVariable Integer id,
            @Valid @RequestBody UserUpdateRequestDTO userUpdateRequest
    ) {
        UserUpdateResponseDTO updatedUser = userService.updateUserProfile(id, userUpdateRequest);
        return ResponseEntity.ok(updatedUser);
    }

    @PostMapping("/users/{id}/change-password")
    public ResponseEntity<?> changeUserPassword(
            @PathVariable Integer id,
            @Valid @RequestBody PasswordChangeRequestDTO passwordChangeRequest
    ) {
        userService.changeUserPassword(id, passwordChangeRequest);
        return ResponseEntity.ok().build();
    }
}
