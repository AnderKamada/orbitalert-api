package com.orbitalert.api.controller;

import com.orbitalert.api.model.HistoricoClimatico;
import com.orbitalert.api.service.HistoricoClimaticoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historicos")
public class HistoricoClimaticoController {

    private final HistoricoClimaticoService service;

    public HistoricoClimaticoController(HistoricoClimaticoService service) {
        this.service = service;
    }

    @GetMapping
    public List<HistoricoClimatico> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public HistoricoClimatico salvar(@RequestBody HistoricoClimatico historico) {
        return service.salvar(historico);
    }
}