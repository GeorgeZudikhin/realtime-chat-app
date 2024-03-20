package com.chatapp.backend.service.dto.passwordChange;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PasswordChangeRequestDTO {
    @NotBlank(message = "Current password is required")
    private String currentPassword;

    @Size(min = 8, max = 32, message = "New password must be between 8 and 32 characters")
    private String newPassword;
}
