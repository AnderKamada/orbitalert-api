package com.orbitalert.api.dto;

public class RiscoRequestDTO {

    private Double chuva;

    private Double umidade;

    private Long regiaoId;

    public Double getChuva() {
        return chuva;
    }

    public void setChuva(Double chuva) {
        this.chuva = chuva;
    }

    public Double getUmidade() {
        return umidade;
    }

    public void setUmidade(Double umidade) {
        this.umidade = umidade;
    }

    public Long getRegiaoId() {
        return regiaoId;
    }

    public void setRegiaoId(Long regiaoId) {
        this.regiaoId = regiaoId;
    }
}