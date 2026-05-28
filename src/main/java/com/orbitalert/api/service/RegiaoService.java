package com.orbitalert.api.service;

import org.springframework.cache.annotation.Cacheable;
import com.orbitalert.api.model.Regiao;
import com.orbitalert.api.repository.RegiaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegiaoService {

    private final RegiaoRepository repository;

    public RegiaoService(RegiaoRepository repository) {
        this.repository = repository;
    }

    @Cacheable("regioes")
    public List<Regiao> listarTodas() {
        return repository.findAll();
    }

    public Regiao salvar(Regiao regiao) {
        return repository.save(regiao);
    }
}