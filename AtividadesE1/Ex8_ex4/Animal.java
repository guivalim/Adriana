public class Animal {
    String especie;
    float peso;
    boolean voa;

    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public boolean isVoa() {
        return voa;
    }
    public void setVoa(boolean voa) {
        this.voa = voa;
    }

    public void cacar(){
        System.out.println("O objeto seria o urso por exemplo.");
    }
}
