package com.orbitalert.api.controller;

import com.orbitalert.api.model.Alerta;
import com.orbitalert.api.service.AlertaProducer;
import com.orbitalert.api.service.AlertaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    private final AlertaService service;
    private final AlertaProducer producer;

    public AlertaController(
            AlertaService service,
            AlertaProducer producer
    ) {

        this.service = service;
        this.producer = producer;
    }

    @GetMapping
    public List<Alerta> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Alerta salvar(@RequestBody Alerta alerta) {
        return service.salvar(alerta);
    }
    @PostMapping("/teste")
    public String enviarTeste() {

        producer.enviarMensagem(
                "Risco alto detectado na regiao de teste"
        );

        return "Mensagem enviada";
    }
}