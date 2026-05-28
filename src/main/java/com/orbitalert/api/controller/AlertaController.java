package com.orbitalert.api.controller;

import com.orbitalert.api.model.Alerta;
import com.orbitalert.api.service.AlertaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    private final AlertaService service;

    public AlertaController(AlertaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Alerta> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Alerta salvar(@RequestBody Alerta alerta) {
        return service.salvar(alerta);
    }
}