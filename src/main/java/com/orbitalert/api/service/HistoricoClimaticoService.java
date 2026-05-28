package com.orbitalert.api.service;

import com.orbitalert.api.model.HistoricoClimatico;
import com.orbitalert.api.repository.HistoricoClimaticoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoClimaticoService {

    private final HistoricoClimaticoRepository repository;

    public HistoricoClimaticoService(HistoricoClimaticoRepository repository) {
        this.repository = repository;
    }

    public List<HistoricoClimatico> listarTodos() {
        return repository.findAll();
    }

    public HistoricoClimatico salvar(HistoricoClimatico historico) {
        return repository.save(historico);
    }
}