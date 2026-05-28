package com.orbitalert.api.controller;

import com.orbitalert.api.dto.RiscoRequestDTO;
import com.orbitalert.api.dto.RiscoResponseDTO;
import com.orbitalert.api.service.RiscoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/risco")
public class RiscoController {

    private final RiscoService service;

    public RiscoController(RiscoService service) {
        this.service = service;
    }

    @PostMapping("/analisar")
    public RiscoResponseDTO analisar(
            @RequestBody RiscoRequestDTO request) {

        return service.analisar(request);
    }
}