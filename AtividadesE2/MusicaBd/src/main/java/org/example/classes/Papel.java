package org.example.classes;

public class Papel {
    private String cor;
    private int tamanho;
    private boolean desenhado;
    private int id;

    public Papel(String cor, int tamanho, boolean desenhado) {
        this.cor = cor;
        this.tamanho = tamanho;
        this.desenhado = desenhado;
    }
    public Papel(int id, String cor, int tamanho, boolean desenhado) {
        this.id = id;
        this.cor = cor;
        this.tamanho = tamanho;
        this.desenhado = desenhado;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    public boolean isDesenhado() {
        return desenhado;
    }
    public void setDesenhado(boolean desenhado) {
        this.desenhado = desenhado;
    }

    @Override
    public String toString() {
        return cor;
    }


}
