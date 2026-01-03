package az.edu.itbrains.Aptekk.services;

import az.edu.itbrains.Aptekk.dtos.response.UserDTO.RegisterDTO;
import az.edu.itbrains.Aptekk.models.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);
    User registerUser(RegisterDTO registerDTO);
    boolean existsByEmail(String email);
    void updateUserRole(Long userId, String newRoleName);
    User findByEmail(String email);

}
