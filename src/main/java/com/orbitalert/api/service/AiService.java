package com.orbitalert.api.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final ChatClient chatClient;

    public AiService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String perguntar(String pergunta) {

        return chatClient.prompt()
                .user(pergunta)
                .call()
                .content();
    }
}