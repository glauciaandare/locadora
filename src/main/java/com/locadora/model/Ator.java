package com.locadora.model;

public class Ator {
    private int cod_ator;
    private String nome;

    public Ator(int cod_ator, String nome) {
        this.cod_ator = cod_ator;
        this.nome = nome;
    }

    public Ator() {
    }

    public int getCod_ator() {
        return cod_ator;
    }

    public void setCod_ator(int cod_ator) {
        this.cod_ator = cod_ator;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
