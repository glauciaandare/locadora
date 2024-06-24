package com.locadora.model;

public class Categoria {
    private int cod_cat;
    private String nome;
    private double valor;

    public Categoria(double valor, String nome, int cod_cat) {
        this.valor = valor;
        this.nome = nome;
        this.cod_cat = cod_cat;
    }

    public Categoria() {
    }

    public int getCod_cat() {
        return cod_cat;
    }

    public void setCod_cat(int cod_cat) {
        this.cod_cat = cod_cat;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
