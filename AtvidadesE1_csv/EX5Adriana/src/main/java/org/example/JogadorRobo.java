package org.example;

import java.io.IOException;

public class JogadorRobo {
    private int numeroSerie;
    private int energia;
    private String aparencia;

    public JogadorRobo(int numeroSerie, int energia, String aparencia) {
        this.numeroSerie = numeroSerie;
        this.energia = energia;
        this.aparencia = aparencia;
    }
    public int getNumeroSerie() {
        return numeroSerie;
    }
    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    public int getEnergia() {
        return energia;
    }
    public void setEnergia(int energia) {
        this.energia = energia;
    }
    public String getAparencia() {
        return aparencia;
    }
    public void setAparencia(String aparencia) {
        this.aparencia = aparencia;
    }
    public void salvar() {
        try {
            CSVUtils.salvar(
                    "jogadoresRobo.csv",
                    "N.SÉRIE,ENERGIA,APARENCIA",
                    this.numeroSerie + "," + this.energia + "," + this.aparencia
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

