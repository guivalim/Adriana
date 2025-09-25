public class Construcao {
    String cor;
    float andares;
    String localizacao;

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public float getAndares() {
        return andares;
    }
    public void setAndares(float andares) {
        this.andares = andares;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void abrigar(){
        System.out.println("O objeto seria um predio X por exemplo.");
    }
}
