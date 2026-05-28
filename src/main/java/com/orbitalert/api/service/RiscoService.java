package com.orbitalert.api.service;

import com.orbitalert.api.dto.RiscoRequestDTO;
import com.orbitalert.api.dto.RiscoResponseDTO;
import com.orbitalert.api.model.Alerta;
import com.orbitalert.api.model.HistoricoClimatico;
import com.orbitalert.api.model.Regiao;
import com.orbitalert.api.repository.AlertaRepository;
import com.orbitalert.api.repository.HistoricoClimaticoRepository;
import com.orbitalert.api.repository.RegiaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RiscoService {

    private final HistoricoClimaticoRepository repository;
    private final AlertaRepository alertaRepository;
    private final RegiaoRepository regiaoRepository;

    public RiscoService(
            HistoricoClimaticoRepository repository,
            AlertaRepository alertaRepository,
            RegiaoRepository regiaoRepository
    ) {

        this.repository = repository;
        this.alertaRepository = alertaRepository;
        this.regiaoRepository = regiaoRepository;
    }

    public RiscoResponseDTO analisar(RiscoRequestDTO request) {

        List<HistoricoClimatico> historicos = repository.findAll();

        boolean possuiHistoricoAlagamento = historicos.stream()
                .anyMatch(h ->
                        h.getRegiao().getId().equals(request.getRegiaoId())
                                && Boolean.TRUE.equals(h.getHouveAlagamento())
                );

        if (request.getChuva() >= 80
                && request.getUmidade() >= 85
                && possuiHistoricoAlagamento) {

            Regiao regiao = regiaoRepository
                    .findById(request.getRegiaoId())
                    .orElseThrow();

            Alerta alerta = new Alerta();

            alerta.setMensagem(
                    "Possível enchente na região nas próximas horas."
            );

            alerta.setNivel("ALTO");

            alerta.setDataCriacao(LocalDateTime.now());

            alerta.setRegiao(regiao);

            alertaRepository.save(alerta);

            return new RiscoResponseDTO(
                    "ALTO",
                    "Possível enchente na região nas próximas horas."
            );
        }

        return new RiscoResponseDTO(
                "BAIXO",
                "Sem risco elevado de enchente."
        );
    }
}