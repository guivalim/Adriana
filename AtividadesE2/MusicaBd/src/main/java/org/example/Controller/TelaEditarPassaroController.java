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
import org.example.DAO.PassaroDAO;
import org.example.classes.Passaro;


public class TelaEditarPassaroController {

    @FXML
    private Button bnt_salvarPassaroEditado;

    @FXML
    private TextField txf_passaro_cor;

    @FXML
    private TextField txf_passaro_especie;

    @FXML
    private TextField txf_passaro_peso;

    private Passaro passaroAtual;

    @FXML
    private Button voltaredit;

    public void receberPassaro(Passaro passaro){

        this.passaroAtual = passaro;

        txf_passaro_especie.setText(passaro.getEspecie());
        txf_passaro_cor.setText(passaro.getCor());
        txf_passaro_peso.setText(String.valueOf(passaro.getPeso()));
    }

    @FXML
    void salvarpassaroEditado(ActionEvent event) {

        String novaEspecie = txf_passaro_especie.getText();
        String novoPesoTexto = txf_passaro_peso.getText();
        String novaCor = txf_passaro_cor.getText();

        if(novaEspecie.isEmpty() || novoPesoTexto.isEmpty() || novaCor.isEmpty()){
            Alerts.mostrarErro("Preencha todos os campos!");
            return;
        }

        float novoPeso;

        try {
            novoPeso = Float.parseFloat(novoPesoTexto);
        } catch (NumberFormatException e) {
            Alerts.mostrarErro("O campo peso, deve conter números.");
            return;
        }

        passaroAtual.setEspecie(novaEspecie);
        passaroAtual.setCor(novaCor);
        passaroAtual.setPeso(novoPeso);

        PassaroDAO dao = new PassaroDAO();
        dao.atualizar(passaroAtual);

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