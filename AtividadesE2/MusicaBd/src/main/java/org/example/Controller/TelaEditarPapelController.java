package org.example.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.Alerts;
import org.example.DAO.PapelDAO;
import org.example.classes.Papel;

public class TelaEditarPapelController {

    @FXML
    private Button bnt_papel_salvarEditado;

    @FXML
    private CheckBox cbx_desenhado;

    @FXML
    private TextField txf_papel_cor;

    @FXML
    private TextField txf_papel_tamanho;

    @FXML
    private Button voltaredit;

    private Papel papelAtual;

    // Método chamado pela tela anterior
    public void receberPapel(Papel papel) {
        this.papelAtual = papel;

        // Preenche os campos com os dados atuais
        txf_papel_cor.setText(papel.getCor());
        txf_papel_tamanho.setText(String.valueOf(papel.getTamanho()));
        cbx_desenhado.setSelected(papel.isDesenhado());
    }

    @FXML
    void salvarpapelEditado(ActionEvent event) {

        try {
        // 1) pegar novos dados da interface
        String novaCor = txf_papel_cor.getText();
        String novoTamanhoTexto = txf_papel_tamanho.getText();
        boolean novoDesenhado = cbx_desenhado.isSelected();

        if(novaCor.isEmpty() || novoTamanhoTexto.isEmpty()) {
            Alerts.mostrarErro("Preencha todos os campos!");
            return;
        }

        int novoTamanho;

        try {
            novoTamanho = Integer.parseInt(novoTamanhoTexto);
        } catch (NumberFormatException e) {
            Alerts.mostrarErro("O campo tamanaho, deve conter números.");
            return;
        }



        // 2) atualizar o objeto atual
        papelAtual.setCor(novaCor);
        papelAtual.setTamanho(novoTamanho);
        papelAtual.setDesenhado(novoDesenhado);

        // 3) atualiza no banco
        PapelDAO dao = new PapelDAO();
        dao.atualizar(papelAtual);

        Alerts.mostrarSucesso("Papel atualizado com sucesso!");

        // 4) voltar para tela anterior
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