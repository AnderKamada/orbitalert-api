package com.orbitalert.api.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FILA_ALERTAS = "fila.alertas";

    @Bean
    public Queue filaAlertas() {

        System.out.println("CRIANDO FILA ALERTAS");

        return new Queue(FILA_ALERTAS, true);
    }
}