package com.orbitalert.api.dto;

public class RiscoResponseDTO {

    private String risco;

    private String mensagem;

    public RiscoResponseDTO(String risco, String mensagem) {
        this.risco = risco;
        this.mensagem = mensagem;
    }

    public String getRisco() {
        return risco;
    }

    public String getMensagem() {
        return mensagem;
    }
}