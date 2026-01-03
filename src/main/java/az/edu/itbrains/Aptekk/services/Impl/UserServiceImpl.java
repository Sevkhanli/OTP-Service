package az.edu.itbrains.Aptekk.services.Impl;

import az.edu.itbrains.Aptekk.dtos.response.UserDTO.RegisterDTO;
import az.edu.itbrains.Aptekk.models.Role;
import az.edu.itbrains.Aptekk.models.User;
import az.edu.itbrains.Aptekk.repository.RoleRepository;
import az.edu.itbrains.Aptekk.repository.UserRepository;
import az.edu.itbrains.Aptekk.services.SendService.OtpService;
import az.edu.itbrains.Aptekk.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final OtpService otpService;
    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User registerUser(RegisterDTO registerDTO) {
        if (userRepository.findByEmail(registerDTO.getEmail()) != null) {
            throw new RuntimeException("Bu email (" + registerDTO.getEmail() + ") artıq sistemdə mövcuddur.");
        }

        User user = modelMapper.map(registerDTO, User.class);

        String encodedPassword = passwordEncoder.encode(registerDTO.getPassword());
        user.setPassword(encodedPassword);

        Role userRole = roleRepository.findByName("ROLE_USER");
        if (userRole == null) {
            userRole = roleRepository.findByName("MÜŞTƏRİ");
        }

        if (userRole == null) {
            throw new RuntimeException("Default rol (MÜŞTƏRİ/ROLE_USER) tapılmadı.");
        }
        user.getRoles().add(userRole);

        User savedUser = userRepository.save(user);

        otpService.generateAndSendOtp(savedUser.getEmail());

        return savedUser;
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email) != null;
    }

    @Override
    @Transactional
    public void updateUserRole(Long userId, String newRoleName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("İstifadəçi tapılmadı: ID=" + userId));

        Role newRole = roleRepository.findByName(newRoleName);
        if (newRole == null) {
            throw new RuntimeException("Rol tapılmadı: Ad=" + newRoleName);
        }

        user.getRoles().clear();
        user.getRoles().add(newRole);

        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
