package com.orbitalert.api.controller;

import com.orbitalert.api.service.AiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/ia")
    public String perguntar(
            @RequestParam String pergunta
    ) {
        return aiService.perguntar(pergunta);
    }
}