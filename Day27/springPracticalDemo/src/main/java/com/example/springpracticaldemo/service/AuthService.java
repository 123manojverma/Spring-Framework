package com.example.springpracticaldemo.service;

import com.example.springpracticaldemo.dto.UserRegisterRequestDto;
import com.example.springpracticaldemo.dto.UserRegisterResponseDto;
import com.example.springpracticaldemo.entity.Role;
import com.example.springpracticaldemo.entity.User;
import com.example.springpracticaldemo.repository.RoleRepository;
import com.example.springpracticaldemo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserRegisterResponseDto register(UserRegisterRequestDto userRegisterRequestDto){
        User user=new User();
        user.setUsername(userRegisterRequestDto.getUsername());
        String encodedPassword= passwordEncoder.encode(userRegisterRequestDto.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);

        Role role=roleRepository.findByName("ROLE_USER").get();

        user.getRoles().add(role);

        userRepository.save(user);

        UserRegisterResponseDto responseDto=new UserRegisterResponseDto();
        responseDto.setUsername(userRegisterRequestDto.getUsername());
        responseDto.setMessage("User saved successfully");
        return responseDto;
    }

//    public Boolean login(UserRegisterRequestDto requestDto){
//        Optional<User> userOptional=userRepository.findByUsername(requestDto.getUsername());
//
//        User user=userOptional.get();
//        String encodedPassword=user.getPassword();
//
//        return passwordEncoder.matches(requestDto.getPassword(),encodedPassword);
//    }
}
