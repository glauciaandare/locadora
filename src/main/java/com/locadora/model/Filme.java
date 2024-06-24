package com.locadora.model;

public class Filme {
    private int cod_filme;
    private String titulo_original;
    private String titulo;
    private int quantidade;
    private int cod_cat;
    private int cod_gen;

    public Filme(int cod_filme, String titulo_original, String titulo, int quantidade, int cod_cat, int cod_gen) {
        this.cod_filme = cod_filme;
        this.titulo_original = titulo_original;
        this.titulo = titulo;
        this.quantidade = quantidade;
        this.cod_cat = cod_cat;
        this.cod_gen = cod_gen;
    }

    public Filme() {
    }

    public int getCod_filme() {
        return cod_filme;
    }

    public void setCod_filme(int cod_filme) {
        this.cod_filme = cod_filme;
    }

    public String getTitulo_original() {
        return titulo_original;
    }

    public void setTitulo_original(String titulo_original) {
        this.titulo_original = titulo_original;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCod_cat() {
        return cod_cat;
    }

    public void setCod_cat(int cod_cat) {
        this.cod_cat = cod_cat;
    }

    public int getCod_gen() {
        return cod_gen;
    }

    public void setCod_gen(int cod_gen) {
        this.cod_gen = cod_gen;
    }
}
