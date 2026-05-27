package com.orbitalert.api.controller;

import com.orbitalert.api.model.Regiao;
import com.orbitalert.api.service.RegiaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regioes")
public class RegiaoController {

    private final RegiaoService service;

    public RegiaoController(RegiaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Regiao> listar() {
        return service.listarTodas();
    }

    @PostMapping
    public Regiao salvar(@RequestBody Regiao regiao) {
        return service.salvar(regiao);
    }
}