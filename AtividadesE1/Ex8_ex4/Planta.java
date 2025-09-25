public class Planta {
    String especie;
    String tipoAmbiente;
    int idade;

    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getTipoAmbiente() {
        return tipoAmbiente;
    }
    public void setTipoAmbiente(String tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void fazerFotossintese(){
        System.out.println("O objeto seria um coqueiro por exemplo.");
    }
}
