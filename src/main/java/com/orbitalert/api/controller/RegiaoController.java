package com.orbitalert.api.controller;

import com.orbitalert.api.dto.RegiaoHateoasDTO;
import com.orbitalert.api.model.Regiao;
import com.orbitalert.api.service.RegiaoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/{id}")
    public RegiaoHateoasDTO buscarPorId(@PathVariable Long id) {

        Regiao regiao = service.buscarPorId(id);

        return new RegiaoHateoasDTO(
                regiao.getId(),
                regiao.getNome(),
                regiao.getCidade(),
                regiao.getNivelRisco(),
                Map.of(
                        "self", "/regioes/" + id,
                        "todas-regioes", "/regioes"
                )
        );
    }

    @PutMapping("/{id}")
    public Regiao atualizar(
            @PathVariable Long id,
            @RequestBody Regiao regiao
    ) {
        return service.atualizar(id, regiao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "OrbitalAlert API Online";
    }
}