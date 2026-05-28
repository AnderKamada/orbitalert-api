package com.orbitalert.api.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_alerta")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    private String nivel;

    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "regiao_id")
    private Regiao regiao;

    public Alerta() {
    }

    public Alerta(Long id, String mensagem, String nivel,
                  LocalDateTime dataCriacao, Regiao regiao) {
        this.id = id;
        this.mensagem = mensagem;
        this.nivel = nivel;
        this.dataCriacao = dataCriacao;
        this.regiao = regiao;
    }

    public Long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }
}