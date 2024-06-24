package com.locadora.model;

public class Profissao {
    private int cod_prof;
    private String nome;

    public Profissao(String nome, int cod_prof) {
        this.nome = nome;
        this.cod_prof = cod_prof;
    }

    public Profissao() {
    }

    public int getCod_prof() {
        return cod_prof;
    }

    public void setCod_prof(int cod_prof) {
        this.cod_prof = cod_prof;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
