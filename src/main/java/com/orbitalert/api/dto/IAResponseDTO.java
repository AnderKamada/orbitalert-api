package com.orbitalert.api.dto;

public class IAResponseDTO {

    private String resposta;

    public IAResponseDTO(String resposta) {
        this.resposta = resposta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}