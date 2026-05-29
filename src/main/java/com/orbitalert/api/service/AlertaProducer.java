package com.orbitalert.api.service;

import com.orbitalert.api.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class AlertaProducer {

    private final RabbitTemplate rabbitTemplate;

    public AlertaProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarMensagem(String mensagem) {

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.FILA_ALERTAS,
                mensagem
        );

        System.out.println("MENSAGEM ENVIADA: " + mensagem);
    }
}