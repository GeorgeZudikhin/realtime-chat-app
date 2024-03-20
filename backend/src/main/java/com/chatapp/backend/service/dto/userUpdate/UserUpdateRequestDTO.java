package com.chatapp.backend.service.dto.userUpdate;

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
public class UserUpdateRequestDTO {
    @NotBlank
    @Size(min = 2, max = 32, message = "First name must be between 2 and 32 characters")
    private String firstname;

    @NotBlank
    @Size(min = 2, max = 32, message = "Last name must be between 2 and 32 characters")
    private String lastname;

    @NotBlank
    @Email(message = "Email should be valid")
    private String email;
}
