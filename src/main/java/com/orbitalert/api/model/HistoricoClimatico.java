package com.orbitalert.api.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_historico_climatico")
public class HistoricoClimatico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double chuva;

    private Double umidade;

    private Double temperatura;

    private Boolean houveAlagamento;

    private LocalDate dataEvento;

    @ManyToOne
    @JoinColumn(name = "regiao_id")
    private Regiao regiao;

    public HistoricoClimatico() {
    }

    public HistoricoClimatico(Long id, Double chuva, Double umidade,
                              Double temperatura, Boolean houveAlagamento,
                              LocalDate dataEvento, Regiao regiao) {
        this.id = id;
        this.chuva = chuva;
        this.umidade = umidade;
        this.temperatura = temperatura;
        this.houveAlagamento = houveAlagamento;
        this.dataEvento = dataEvento;
        this.regiao = regiao;
    }

    public Long getId() {
        return id;
    }

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

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Boolean getHouveAlagamento() {
        return houveAlagamento;
    }

    public void setHouveAlagamento(Boolean houveAlagamento) {
        this.houveAlagamento = houveAlagamento;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }
}