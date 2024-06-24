package com.locadora.model;

public class Endereco {
    private int cod_end;
    private String logradouro;
    private String tipo_log;
    private String complemento;
    private String cidade;
    private char uf;
    private String cep;
    private String numero;
    private String bairro;

    public Endereco(int cod_end, String logradouro, String tipo_log, String complemento, String cidade, char uf, String cep, String numero, String bairro) {
        this.cod_end = cod_end;
        this.logradouro = logradouro;
        this.tipo_log = tipo_log;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
    }

    public Endereco() {
    }

    public int getCod_end() {
        return cod_end;
    }

    public void setCod_end(int cod_end) {
        this.cod_end = cod_end;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getTipo_log() {
        return tipo_log;
    }

    public void setTipo_log(String tipo_log) {
        this.tipo_log = tipo_log;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public char getUf() {
        return uf;
    }

    public void setUf(char uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
