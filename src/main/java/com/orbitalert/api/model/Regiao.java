package com.orbitalert.api.model;

import jakarta.persistence.*;

    @Entity
    @Table(name = "tb_regiao")
    public class Regiao {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;

        private String cidade;

        private String nivelRisco;

        public Regiao() {
        }

        public Regiao(Long id, String nome, String cidade, String nivelRisco) {
            this.id = id;
            this.nome = nome;
            this.cidade = cidade;
            this.nivelRisco = nivelRisco;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public String getNivelRisco() {
            return nivelRisco;
        }

        public void setNivelRisco(String nivelRisco) {
            this.nivelRisco = nivelRisco;
        }
    }
