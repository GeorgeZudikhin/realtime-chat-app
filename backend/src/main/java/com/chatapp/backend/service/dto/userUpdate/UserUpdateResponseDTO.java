package com.chatapp.backend.service.dto.userUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateResponseDTO {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
}