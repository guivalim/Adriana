package org.example;

import java.io.*;

public class Calcado {
    private String modelo;
    private String marca;
    private String cor;

    public Calcado(String modelo, String marca, String cor) {
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void salvar() {
        try {
            CSVUtils.salvar(
                    "calcados.csv",
                    "MODELO,MARCA,COR",
                    this.modelo + "," + this.marca + "," + this.cor
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}
