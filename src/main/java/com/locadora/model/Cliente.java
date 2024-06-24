package com.locadora.model;

public class Cliente {
    private int cod_cli;
    private String cpf;
    private String nome;
    private String telefone;
    private int cod_prof;

    public Cliente(int cod_cli, String cpf, String nome, String telefone, int cod_prof) {
        this.cod_cli = cod_cli;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.cod_prof = cod_prof;
    }

    public Cliente() {
    }

    public int getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(int cod_cli) {
        this.cod_cli = cod_cli;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getCod_prof() {
        return cod_prof;
    }

    public void setCod_prof(int cod_prof) {
        this.cod_prof = cod_prof;
    }
}
