package com.example.springpracticaldemo.controller;

import com.example.springpracticaldemo.dto.UserRegisterRequestDto;
import com.example.springpracticaldemo.dto.UserRegisterResponseDto;
import com.example.springpracticaldemo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @GetMapping("/hello")
    public String sayHello(){
        System.out.println(passwordEncoder.encode("secret123"));
        System.out.println(passwordEncoder.encode("secret123"));

        System.out.println(passwordEncoder.matches("secret123","$2a$10$/vSrhyWr1fQJC2Xpotk7..FzDZMxwoSi4Ld7vtzIqn0luDWauxX4O"));
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto>register(@RequestBody UserRegisterRequestDto userRegisterRequestDto){
        UserRegisterResponseDto userRegisterResponseDto= authService.register(userRegisterRequestDto);

        return ResponseEntity.ok(userRegisterResponseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean>login(@RequestBody UserRegisterRequestDto userRegisterRequestDto){
        Boolean loggedIn= authService.login(userRegisterRequestDto);

        return ResponseEntity.ok(loggedIn);
    }

    @GetMapping("/token")
    public CsrfToken getToken(CsrfToken csrfToken){
        return csrfToken;
    }
}
