package com.chatapp.backend.service.dto.userCreate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequestDTO {
    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 32, message = "First name must be between 2 and 32 characters")
    private String firstname;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 32, message = "Last name must be between 2 and 32 characters")
    private String lastname;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 32, message = "New password must be between 8 and 32 characters")
    private String password;
}
