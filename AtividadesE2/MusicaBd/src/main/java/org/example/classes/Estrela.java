package org.example.classes;

public class Estrela {
    private String nome;
    private String cor;
    private double tamanho;
    private double distTerra;
    private int id;

    public Estrela(String nome, String cor, double tamanho, double distTerra) {
        this.nome = nome;
        this.cor = cor;
        this.tamanho = tamanho;
        this.distTerra = distTerra;
    }

    public Estrela(int id,String nome, String cor, double tamanho, double distTerra) {
        this.id = id;
        this.nome = nome;
        this.cor = cor;
        this.tamanho = tamanho;
        this.distTerra = distTerra;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getTamanho() {
        return tamanho;
    }
    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public double getDistTerra() {
        return distTerra;
    }
    public void setDistTerra(double distTerra) {
        this.distTerra = distTerra;
    }

    @Override
    public String toString() {
        return nome;
    }


}
