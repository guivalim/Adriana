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
import org.example.DAO.EstrelaDAO;
import org.example.DAO.PapelDAO;
import org.example.DAO.PassaroDAO;
import org.example.classes.Estrela;
import org.example.classes.Papel;
import org.example.classes.Passaro;

public class TelaController {


    @FXML
    private Button bnt_papel_salvar;

    @FXML
    private Button bnt_passaro_salvar;

    @FXML
    private Button bnt_salvar_estrela;

    @FXML
    private CheckBox cbx_desenhado;

    @FXML
    private TextField txf_estrela_cor;

    @FXML
    private TextField txf_estrela_distancia_terra;

    @FXML
    private TextField txf_estrela_nome;

    @FXML
    private TextField txf_estrela_tamanho;

    @FXML
    private TextField txf_papel_cor;

    @FXML
    private TextField txf_papel_tamanho;

    @FXML
    private TextField txf_passaro_cor;

    @FXML
    private TextField txf_passaro_especie;

    @FXML
    private TextField txf_passaro_peso;

    @FXML
    private Button voltar1;

    @FXML
    private Button voltar2;

    @FXML
    private Button voltar3;

    @FXML
    void salvarpapel(ActionEvent event) {
        try {
            // 1. Captura dos valores da tela
            String cor = txf_papel_cor.getText().trim();
            String tamanhoTexto = txf_papel_tamanho.getText().trim();
            boolean desenhado = cbx_desenhado.isSelected();

            // 2. Validação simples
            if (cor.isEmpty() || tamanhoTexto.isEmpty()) {
                Alerts.mostrarErro("Preencha os campos!");
                return;
            }

            int tamanho;
            try {
                tamanho = Integer.parseInt(tamanhoTexto);
            } catch (NumberFormatException e) {
                Alerts.mostrarErro("O campo tamanho deve conter valores numéricos.");
                return; // para a execução antes de salvar
            }

            // 3. Criação do objeto
            Papel papel = new Papel(cor, tamanho, desenhado);

            // 4. Inserção no banco
            PapelDAO dao = new PapelDAO();
            dao.inserir(papel);

            Alerts.mostrarSucesso("Papel salvo com sucesso!");

            // 5. Limpeza dos campos
            txf_papel_cor.clear();
            txf_papel_tamanho.clear();
            cbx_desenhado.setSelected(false);

        } catch (Exception e) {
            Alerts.mostrarErro("Erro ao salvar papel!");
            e.printStackTrace();
        }
    }

    @FXML
    void salvarestrela(ActionEvent event) {
        try {
            String nome = txf_estrela_nome.getText().trim();
            String cor = txf_estrela_cor.getText().trim();
            String distanciaTexto = txf_estrela_distancia_terra.getText().trim();
            String tamanhoTexto = txf_estrela_tamanho.getText().trim();

            if (nome.isEmpty() || cor.isEmpty() || distanciaTexto.isEmpty() || tamanhoTexto.isEmpty()) {
                Alerts.mostrarErro("Preencha os campos!");
                return;
            }

            double tamanho;
            double distTerra;
            try {
                tamanho = Double.parseDouble(tamanhoTexto);
                distTerra = Double.parseDouble(distanciaTexto);
            } catch (NumberFormatException e) {
                Alerts.mostrarErro("Os campos de tamanho e distância devem conter valores numéricos.");
                return; //
            }

            Estrela estrela = new Estrela(nome, cor, tamanho, distTerra);

            EstrelaDAO dao = new EstrelaDAO();
            dao.inserir(estrela);

            Alerts.mostrarSucesso("Estrela salvo com sucesso!");

            txf_estrela_nome.clear();
            txf_estrela_cor.clear();
            txf_estrela_tamanho.clear();
            txf_estrela_distancia_terra.clear();

        } catch (Exception e) {
            Alerts.mostrarErro("Erro ao salvar estrela!");
            e.printStackTrace();
        }


    }



    @FXML
    void salvarpassaro(ActionEvent event) {
        try {
            String especie = txf_passaro_especie.getText().trim();
            String cor = txf_passaro_cor.getText().trim();
            String pesoTexto = txf_passaro_peso.getText().trim();

            if (especie.isEmpty() || cor.isEmpty() || pesoTexto.isEmpty()) {
                Alerts.mostrarErro("Preencha todos os campos!");
                return;
            }

            float peso;
            try {
                peso = Float.parseFloat(pesoTexto);
            } catch (NumberFormatException e) {
                Alerts.mostrarErro("O campo 'Peso' deve conter apenas números (use ponto para decimais).");
                return;
            }

            Passaro passaro = new Passaro(especie, cor, peso);

            PassaroDAO dao = new PassaroDAO();
            dao.inserir(passaro);

            Alerts.mostrarSucesso("Pássaro salvo com sucesso!");

            txf_passaro_especie.clear();
            txf_passaro_cor.clear();
            txf_passaro_peso.clear();

        } catch (Exception e) {
            Alerts.mostrarErro("Erro ao salvar o pássaro!");
            e.printStackTrace();
        }
    }

    @FXML
    void voltarTelaInicial(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/TelaInicial.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
