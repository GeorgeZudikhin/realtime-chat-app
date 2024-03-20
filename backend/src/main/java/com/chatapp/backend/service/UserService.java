package com.chatapp.backend.service;

import com.chatapp.backend.exception.EmailAlreadyInUseException;
import com.chatapp.backend.model.User;
import com.chatapp.backend.repository.UserRepository;
import com.chatapp.backend.service.dto.passwordChange.PasswordChangeRequestDTO;
import com.chatapp.backend.service.dto.userUpdate.UserUpdateRequestDTO;
import com.chatapp.backend.service.dto.userUpdate.UserUpdateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserUpdateResponseDTO updateUserProfile(Integer id, UserUpdateRequestDTO userUpdateRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if(!user.getEmail().equals(userUpdateRequest.getEmail()) && userRepository.existsByEmail(userUpdateRequest.getEmail()))
            throw new EmailAlreadyInUseException("Email already in use");

        user.setFirstname(userUpdateRequest.getFirstname());
        user.setLastname(userUpdateRequest.getLastname());
        user.setEmail(userUpdateRequest.getEmail());

        userRepository.save(user);
        return UserUpdateResponseDTO.builder()
                .id(id)
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .build();
    }

    public void changeUserPassword(Integer id, PasswordChangeRequestDTO passwordChangeRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if(!passwordEncoder.matches(passwordChangeRequest.getCurrentPassword(), user.getPassword()))
            throw new IllegalArgumentException("Invalid current password");

        user.setPassword(passwordEncoder.encode(passwordChangeRequest.getNewPassword()));
        userRepository.save(user);
    }
}
