package org.example;

import java.io.IOException;

public class JogadorHumano {
    private int numeroCamisa;
    private String habilidade;
    private int idade;

    public  JogadorHumano(int numeroCamisa, String habilidade, int idade) {
        this.numeroCamisa = numeroCamisa;
        this.habilidade = habilidade;
        this.idade = idade;
    }

    public int getNumeroCamisa() {
        return numeroCamisa;
    }
    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }
    public String getHabilidade() {
        return habilidade;
    }
    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void salvar() {
        try {
            CSVUtils.salvar(
                    "jogadoresHumanos.csv",
                    "N.CAMISA,HABILIDADE,IDADE",
                    this.numeroCamisa + "," + this.habilidade + "," + this.idade
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
