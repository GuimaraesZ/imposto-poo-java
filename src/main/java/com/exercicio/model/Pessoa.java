package com.exercicio.model;

public abstract class Pessoa {
    protected String nome;
    protected double rendaAnual;

    public Pessoa(String nome, double rendaAnual) {
        this.nome = nome;
        this.rendaAnual = rendaAnual;
    }
    public Pessoa() {
    }

    public double getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }

    public double imposto() {
        return 0.0;
    }

    public String getNome() {
        return nome;
    }
}
