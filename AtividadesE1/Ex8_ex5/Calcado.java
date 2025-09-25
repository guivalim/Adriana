public class Calcado {
    String modelo;
    String marca;
    String cor;

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

    public void calcar(){
        System.out.println("O objeto seria uma chuteira por exemplo.");
    }
}
