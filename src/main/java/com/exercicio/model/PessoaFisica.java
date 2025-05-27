package com.exercicio.model;

public class PessoaFisica extends Pessoa {


    private double gastoSaude;

    public PessoaFisica(){
      super();  
    }

    public PessoaFisica(String nome, double rendaAnual, double gastoSaude) {
        super(nome, rendaAnual);
        this.gastoSaude = gastoSaude;
    }

    public double getGastoSaude() {
        return gastoSaude;
    }

    public void setGastoSaude(double gastoSaude) {
        this.gastoSaude = gastoSaude;
    }

    @Override
    public double imposto() {
        double imposto = 0.0;
        if (rendaAnual < 20000.0) {
            imposto = rendaAnual * 0.15 - (gastoSaude * 0.5);
        } else {
            imposto = rendaAnual * 0.25 - (gastoSaude * 0.5);
        }
        return imposto > 0 ? imposto : 0.0;
    }




}