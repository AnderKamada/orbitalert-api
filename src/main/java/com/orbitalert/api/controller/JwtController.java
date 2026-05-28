package com.orbitalert.api.controller;

import com.orbitalert.api.security.JwtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jwt")
public class JwtController {

    private final JwtService jwtService;

    public JwtController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/validar")
    public String validar(
            @RequestHeader("Authorization") String authHeader
    ) {

        String token = authHeader.replace("Bearer ", "");

        if (jwtService.validarToken(token)) {

            String email =
                    jwtService.extrairEmail(token);

            return "Token válido para: " + email;
        }

        return "Token inválido";
    }
}