package com.example.springpracticaldemo.controller;

import com.example.springpracticaldemo.dto.UserRegisterRequestDto;
import com.example.springpracticaldemo.dto.UserRegisterResponseDto;
import com.example.springpracticaldemo.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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


    @GetMapping("/hello")
    public String sayHello(Authentication authentication){
        return "Hello, you are logged in as : "+authentication.getName();
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto>register(@RequestBody UserRegisterRequestDto userRegisterRequestDto){
        UserRegisterResponseDto userRegisterResponseDto= authService.register(userRegisterRequestDto);

        return ResponseEntity.ok(userRegisterResponseDto);
    }

//    @PostMapping("/login")
//    public ResponseEntity<Boolean>login(@RequestBody UserRegisterRequestDto userRegisterRequestDto){
//        Boolean loggedIn= authService.login(userRegisterRequestDto);
//
//        return ResponseEntity.ok(loggedIn);
//    }

    @GetMapping("/token")
    public CsrfToken getToken(CsrfToken csrfToken){
        return csrfToken;
    }
}
