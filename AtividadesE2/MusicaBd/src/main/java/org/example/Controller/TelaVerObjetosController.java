package org.example.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.example.DAO.EstrelaDAO;
import org.example.DAO.PapelDAO;
import org.example.DAO.PassaroDAO;
import org.example.classes.Estrela;
import org.example.classes.Papel;
import org.example.classes.Passaro;

public class TelaVerObjetosController {

    @FXML
    private ListView<Estrela> listEstrela;

    @FXML
    private ListView<Papel> listPapel;

    @FXML
    private ListView<Passaro> listPassaro;

    @FXML
    private Button voltar1;

    @FXML
    private Button voltar2;

    @FXML
    private Button voltar3;

    @FXML
    public void initialize() {
        carregarListas();
        configurarCliques();
    }

    private void carregarListas() {
        try {
            PapelDAO papelDAO = new PapelDAO();
            PassaroDAO passaroDAO = new PassaroDAO();
            EstrelaDAO estrelaDAO = new EstrelaDAO();

            listPapel.getItems().setAll(papelDAO.listarTodos());
            listPassaro.getItems().setAll(passaroDAO.listarTodos());
            listEstrela.getItems().setAll(estrelaDAO.listarTodos());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar listas!");
        }
    }

    private void configurarCliques() {
        listPapel.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                Papel selecionado = listPapel.getSelectionModel().getSelectedItem();
                if (selecionado != null) {
                    try {
                        // Carrega o FXML da tela de detalhes
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/telaobjetoEspefico.fxml"));
                        Parent root = loader.load();

                        // Obtém o controller da tela de detalhes e passa o objeto
                        TelaVerObjetoEspecificoController controller = loader.getController();
                        controller.receberObjeto(selecionado);

                        // Troca a cena no stage atual
                        Stage stage = (Stage) listPapel.getScene().getWindow();
                        stage.setScene(new Scene(root));


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        listPassaro.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                Passaro selecionado = listPassaro.getSelectionModel().getSelectedItem();
                if (selecionado != null) {
                    try {
                        // Carrega o FXML da tela de detalhes
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/telaobjetoEspefico.fxml"));
                        Parent root = loader.load();

                        // Obtém o controller da tela de detalhes e passa o objeto
                        TelaVerObjetoEspecificoController controller = loader.getController();
                        controller.receberObjeto(selecionado);

                        // Troca a cena no stage atual
                        Stage stage = (Stage) listPassaro.getScene().getWindow();
                        stage.setScene(new Scene(root));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        listEstrela.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                Estrela selecionado = listEstrela.getSelectionModel().getSelectedItem();
                if (selecionado != null) {
                    try {
                        // Carrega o FXML da tela de detalhes
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/telaobjetoEspefico.fxml"));
                        Parent root = loader.load();

                        // Obtém o controller da tela de detalhes e passa o objeto
                        TelaVerObjetoEspecificoController controller = loader.getController();
                        controller.receberObjeto(selecionado);

                        // Troca a cena no stage atual
                        Stage stage = (Stage) listEstrela.getScene().getWindow();
                        stage.setScene(new Scene(root));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

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
