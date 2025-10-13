package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static java.io.FileDescriptor.in;

public class telaController {

    @FXML
    private Button bnt_calcado_salvar;

    @FXML
    private Button bnt_jogadorHumano_salvar;

    @FXML
    private Button bnt_jogadorRobo_salvar;

    @FXML
    private TextField txf_calcado_cor;

    @FXML
    private TextField txf_calcado_marca;

    @FXML
    private TextField txf_calcado_modelo;

    @FXML
    private TextField txf_jogadorHumano_habilidade;

    @FXML
    private TextField txf_jogadorHumano_idade;

    @FXML
    private TextField txf_jogadorHumano_nCamisa;

    @FXML
    private TextField txf_jogadorRobo_aparencia;

    @FXML
    private TextField txf_jogadorRobo_energia;

    @FXML
    private TextField txf_jogadorRobo_nSerie;

    @FXML
    void salvarCalcado(ActionEvent event) {

        String modelo = txf_calcado_modelo.getText();
        String marca = txf_calcado_marca.getText();
        String cor = txf_calcado_cor.getText();

        if (modelo.isEmpty() || marca.isEmpty() || cor.isEmpty()) {
            Alerts.mostrarAviso("Preencha todos os campos!");
            return;
        }
        Calcado calcado = new Calcado(modelo, marca, cor);
        calcado.salvar();

        Alerts.mostrarSucesso("Salvo com sucesso!");

        txf_calcado_modelo.clear();
        txf_calcado_marca.clear();
        txf_calcado_cor.clear();


    }

    @FXML
    void salvarJogadorHumano(ActionEvent event) {

        String numeroCamisaStr = txf_jogadorHumano_nCamisa.getText();
        String habilidade = txf_jogadorHumano_habilidade.getText();
        String idadeStr =  txf_jogadorHumano_idade.getText();

        if (numeroCamisaStr.isEmpty() || habilidade.isEmpty() || idadeStr.isEmpty()) {
            Alerts.mostrarAviso("Preencha todos os campos!");
            return;
        }

        int numeroCamisa = Integer.parseInt(numeroCamisaStr);
        int idade = Integer.parseInt(idadeStr);

        JogadorHumano jogadorHumano = new JogadorHumano(numeroCamisa, habilidade, idade);
        jogadorHumano.salvar();

        Alerts.mostrarSucesso("Salvo com sucesso!");

        txf_jogadorHumano_nCamisa.clear();
        txf_jogadorHumano_idade.clear();
        txf_jogadorHumano_habilidade.clear();


    }

    @FXML
    void salvarJogadorRobo(ActionEvent event) {

     String numeroSerieStr = txf_jogadorRobo_nSerie.getText();
     String energiaStr = txf_jogadorRobo_energia.getText();
     String aparencia = txf_jogadorRobo_aparencia.getText();

     if (numeroSerieStr.isEmpty() || energiaStr.isEmpty() || aparencia.isEmpty()) {
         Alerts.mostrarAviso("Preencha todos os campos!");
         return;
     }

     int numeroSerie;
     int energia;
     try{
         numeroSerie = Integer.parseInt(numeroSerieStr);
         energia = Integer.parseInt(energiaStr);

     } catch (NumberFormatException e) {
        Alerts.mostrarErro("Preencha os campos com dados válidos!");
        return;
     }

     JogadorRobo jogadorRobo = new JogadorRobo(numeroSerie, energia, aparencia);
     jogadorRobo.salvar();

     Alerts.mostrarSucesso("Salvo com sucesso!");

     txf_jogadorRobo_nSerie.clear();
     txf_jogadorRobo_aparencia.clear();
     txf_jogadorRobo_energia.clear();

    }

}
