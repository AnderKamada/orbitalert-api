package com.orbitalert.api.controller;

import com.orbitalert.api.dto.LoginRequestDTO;
import com.orbitalert.api.dto.TokenResponseDTO;
import com.orbitalert.api.model.Usuario;
import com.orbitalert.api.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public Usuario registrar(@RequestBody Usuario usuario) {
        return service.registrar(usuario);
    }

    @PostMapping("/login")
    public TokenResponseDTO login(
            @RequestBody LoginRequestDTO request
    ) {

        return service.login(request);
    }
}