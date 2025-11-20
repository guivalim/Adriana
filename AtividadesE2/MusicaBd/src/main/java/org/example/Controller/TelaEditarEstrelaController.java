package org.example.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.Alerts;
import org.example.DAO.EstrelaDAO;
import org.example.classes.Estrela;

public class TelaEditarEstrelaController {

    @FXML
    private Button bnt_estrela_salvarEstrelaEditado;

    @FXML
    private TextField txf_estrela_cor;

    @FXML
    private TextField txf_estrela_distancia;

    @FXML
    private TextField txf_estrela_nome;

    @FXML
    private TextField txf_estrela_tamanho;

    @FXML
    private Button voltaredit;

    private Estrela estrelaAtual;

    public void receberEstrela(Estrela estrela){

        estrelaAtual = estrela;

        txf_estrela_nome.setText(estrela.getNome());
        txf_estrela_cor.setText(estrela.getCor());
        txf_estrela_tamanho.setText(String.valueOf(estrela.getTamanho()));
        txf_estrela_distancia.setText(String.valueOf(estrela.getDistTerra()));

    }

    @FXML
    void salvarEstrelaEditado(ActionEvent event) {

        String novoNome = txf_estrela_nome.getText();
        String novaCor = txf_estrela_cor.getText();
        String novoTamanhoTexto = txf_estrela_tamanho.getText();
        String novaDistanciaTexto = txf_estrela_distancia.getText();

        if(novoNome.isEmpty() || novaCor.isEmpty() || novoTamanhoTexto.isEmpty() || novaDistanciaTexto.isEmpty()){
            Alerts.mostrarErro("Preencha todos os campos!");
            return;
        }

        double novoTamanho;
        double novaDistancia;

        try {
            novoTamanho = Double.parseDouble(novoTamanhoTexto);
            novaDistancia = Double.parseDouble(novaDistanciaTexto);
        } catch (NumberFormatException e) {
            Alerts.mostrarErro("Os campos de tamanaho e distância, devem conter valores numéricos.");
            return;
        }


        estrelaAtual.setNome(novoNome);
        estrelaAtual.setCor(novaCor);
        estrelaAtual.setTamanho(novoTamanho);
        estrelaAtual.setDistTerra(novaDistancia);


        EstrelaDAO dao = new EstrelaDAO();
        dao.atualizar(estrelaAtual);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/telaVerObjetos.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void voltarTelaAnteriorEdit(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/telaVerObjetos.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

