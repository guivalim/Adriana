public class MeioInformacao {
    String titulo;
    int quantPalavras;
    String corFonte;

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getQuantPalavras() {
        return quantPalavras;
    }
    public void setQuantPalavras(int quantPalavras) {
        this.quantPalavras = quantPalavras;
    }
    public String getCorFonte() {
        return corFonte;
    }
    public void setCorFonte(String corFonte) {
        this.corFonte = corFonte;
    }

    public void mostrarInformacao(){
        System.out.println("O objeto seria o jornal por exemplo.");
    }
}
