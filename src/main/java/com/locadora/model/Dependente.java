package com.locadora.model;

public class Dependente {
    private int cod_cli;
    private int cod_dep;
    private String parentesco;

    public Dependente(int cod_cli, int cod_dep, String parentesco) {
        this.cod_cli = cod_cli;
        this.cod_dep = cod_dep;
        this.parentesco = parentesco;
    }

    public Dependente() {
    }

    public int getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(int cod_cli) {
        this.cod_cli = cod_cli;
    }

    public int getCod_dep() {
        return cod_dep;
    }

    public void setCod_dep(int cod_dep) {
        this.cod_dep = cod_dep;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
}
