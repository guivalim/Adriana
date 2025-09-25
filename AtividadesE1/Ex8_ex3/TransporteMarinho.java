public class TransporteMarinho {
    String tipoEmbarcacao;
    float comprimento;
    String material;

    public String getTipoEmbarcacao() {
        return tipoEmbarcacao;
    }
    public void setTipoEmbarcacao(String tipoEmbarcacao) {
        this.tipoEmbarcacao = tipoEmbarcacao;
    }
    public float getComprimento() {
        return comprimento;
    }
    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }

    public void navegar(){
        System.out.println("O objeto seria o navio por exemplo.");
    }
}
