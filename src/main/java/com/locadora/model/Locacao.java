package com.locadora.model;

import java.util.Date;

public class Locacao {
    private int cad_loc;
    private Date data_loc;
    private double desconto;
    private double multa;
    private double sub_total;
    private int cod_cli;

    public Locacao(int cad_loc, Date data_loc, double desconto, double multa, double sub_total, int cod_cli) {
        this.cad_loc = cad_loc;
        this.data_loc = data_loc;
        this.desconto = desconto;
        this.multa = multa;
        this.sub_total = sub_total;
        this.cod_cli = cod_cli;
    }

    public Locacao() {
    }

    public int getCad_loc() {
        return cad_loc;
    }

    public void setCad_loc(int cad_loc) {
        this.cad_loc = cad_loc;
    }

    public Date getData_loc() {
        return data_loc;
    }

    public void setData_loc(Date data_loc) {
        this.data_loc = data_loc;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }

    public int getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(int cod_cli) {
        this.cod_cli = cod_cli;
    }
}
