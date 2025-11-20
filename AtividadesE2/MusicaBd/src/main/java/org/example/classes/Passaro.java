package org.example.classes;

public class Passaro {
    private String especie;
    private String cor;
    private float peso;
    private int id;

    public Passaro(String especie, String cor, float peso) {
        this.especie = especie;
        this.cor = cor;
        this.peso = peso;
    }

    public Passaro(int id,String especie, String cor, float peso) {
        this.id = id;
        this.especie = especie;
        this.cor = cor;
        this.peso = peso;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return especie;
    }
}
