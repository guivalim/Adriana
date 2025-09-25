public class JogadorHumano {
    int numeroCamisa;
    String habilidade;
    int idade;

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

    public void driblar(){
        System.out.println("O objeto seria o jogador Messi por exemplo.");
    }
}
