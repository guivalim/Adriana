package org.example.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaInicialController {
    @FXML
    private Button bnt_TELAEX2;

    @FXML
    private Button bnt_telaCadastrados;

    @FXML
    private void abrirTelaCadastro(ActionEvent event) {
        try {
            // Caminho do seu arquivo FXML da tela de cadastro (a com as abas)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/TELAEX2.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void abrirTelaVerObjetos(ActionEvent event) {
        try {
            // Caminho do seu arquivo FXML da tela de cadastro (a com as abas)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/telaVerObjetos.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
