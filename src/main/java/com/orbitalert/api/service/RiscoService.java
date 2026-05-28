package com.orbitalert.api.service;

import com.orbitalert.api.dto.RiscoRequestDTO;
import com.orbitalert.api.dto.RiscoResponseDTO;
import com.orbitalert.api.model.HistoricoClimatico;
import com.orbitalert.api.repository.HistoricoClimaticoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiscoService {

    private final HistoricoClimaticoRepository repository;

    public RiscoService(HistoricoClimaticoRepository repository) {
        this.repository = repository;
    }

    public RiscoResponseDTO analisar(RiscoRequestDTO request) {

        List<HistoricoClimatico> historicos = repository.findAll();

        boolean possuiHistoricoAlagamento = historicos.stream()
                .anyMatch(h -> h.getRegiao().getId().equals(request.getRegiaoId())
                        && Boolean.TRUE.equals(h.getHouveAlagamento()));

        if (request.getChuva() >= 80
                && request.getUmidade() >= 85
                && possuiHistoricoAlagamento) {

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