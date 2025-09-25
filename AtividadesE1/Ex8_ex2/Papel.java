public class Papel {
    String cor;
    int tamanho;
    boolean desenhado;

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

    public void desenhar(){
        System.out.println("O objeto seria a folhaQualquer por exemplo.");

    }
}
