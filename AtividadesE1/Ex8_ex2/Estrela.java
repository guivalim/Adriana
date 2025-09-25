public class Estrela {
    String nome;
    String cor;
    double tamanho;
    double distTerra;

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

    public void clarearTerra(){
        System.out.println("Objeto seria o sol por exemplo.");

    };
}
