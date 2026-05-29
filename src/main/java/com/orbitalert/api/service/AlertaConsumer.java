package com.orbitalert.api.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class AlertaConsumer {

    @RabbitListener(queues = "fila.alertas")
    public void receberMensagem(String mensagem) {

        System.out.println(
                "ALERTA RECEBIDO: " + mensagem
        );
    }
}