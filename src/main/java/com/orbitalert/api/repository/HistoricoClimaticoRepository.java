package com.orbitalert.api.repository;

import com.orbitalert.api.model.HistoricoClimatico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoClimaticoRepository
        extends JpaRepository<HistoricoClimatico, Long> {
}