package com.orbitalert.api.dto;

import java.util.Map;

public class RegiaoHateoasDTO {

    private Long id;
    private String nome;
    private String cidade;
    private String nivelRisco;
    private Map<String, String> links;

    public RegiaoHateoasDTO(
            Long id,
            String nome,
            String cidade,
            String nivelRisco,
            Map<String, String> links
    ) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.nivelRisco = nivelRisco;
        this.links = links;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getNivelRisco() {
        return nivelRisco;
    }

    public Map<String, String> getLinks() {
        return links;
    }
}