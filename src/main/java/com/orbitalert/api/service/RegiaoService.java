package com.orbitalert.api.service;

import com.orbitalert.api.model.Regiao;
import com.orbitalert.api.repository.RegiaoRepository;
import org.springframework.cache.annotation.Cacheable;
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

    public Regiao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Região não encontrada"));
    }

    public Regiao atualizar(Long id, Regiao novaRegiao) {

        Regiao regiao = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Região não encontrada"));

        regiao.setNome(novaRegiao.getNome());
        regiao.setCidade(novaRegiao.getCidade());
        regiao.setNivelRisco(novaRegiao.getNivelRisco());

        return repository.save(regiao);
    }

    public void deletar(Long id) {

        Regiao regiao = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Região não encontrada"));

        repository.delete(regiao);
    }
}