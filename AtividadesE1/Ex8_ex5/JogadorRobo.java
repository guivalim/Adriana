public class JogadorRobo {
    int numeroSerie;
    int energia;
    String aparencia;

    public int getNumeroSerie() {
        return numeroSerie;
    }
    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    public int getEnergia() {
        return energia;
    }
    public void setEnergia(int energia) {
        this.energia = energia;
    }
    public String getAparencia() {
        return aparencia;
    }
    public void setAparencia(String aparencia) {
        this.aparencia = aparencia;
    }

    public void analisarJogada(){
        System.out.println("O objeto seria o roboCR por exemplo.");
    }
}
