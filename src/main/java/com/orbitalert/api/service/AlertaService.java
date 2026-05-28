package com.orbitalert.api.service;

import com.orbitalert.api.model.Alerta;
import com.orbitalert.api.repository.AlertaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaService {

    private final AlertaRepository repository;

    public AlertaService(AlertaRepository repository) {
        this.repository = repository;
    }

    public List<Alerta> listarTodos() {
        return repository.findAll();
    }

    public Alerta salvar(Alerta alerta) {
        return repository.save(alerta);
    }
}