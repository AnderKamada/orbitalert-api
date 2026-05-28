package com.orbitalert.api.service;

import com.orbitalert.api.dto.LoginRequestDTO;
import com.orbitalert.api.dto.TokenResponseDTO;
import com.orbitalert.api.model.Usuario;
import com.orbitalert.api.repository.UsuarioRepository;
import com.orbitalert.api.security.JwtService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository repository;
    private final JwtService jwtService;

    public AuthService(
            UsuarioRepository repository,
            JwtService jwtService
    ) {

        this.repository = repository;
        this.jwtService = jwtService;
    }

    public Usuario registrar(Usuario usuario) {
        return repository.save(usuario);
    }

    public TokenResponseDTO login(LoginRequestDTO request) {

        Usuario usuario = repository.findByEmail(request.getEmail())
                .orElseThrow();

        if (!usuario.getSenha().equals(request.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        String token = jwtService.gerarToken(usuario.getEmail());

        return new TokenResponseDTO(token);
    }
}