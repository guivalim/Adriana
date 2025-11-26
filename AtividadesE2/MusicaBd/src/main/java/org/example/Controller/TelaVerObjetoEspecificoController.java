    package org.example.Controller;

    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.stage.Stage;
    import org.example.Alerts;
    import org.example.DAO.EstrelaDAO;
    import org.example.DAO.PapelDAO;
    import org.example.DAO.PassaroDAO;
    import org.example.classes.Estrela;
    import org.example.classes.Papel;
    import org.example.classes.Passaro;


    public class TelaVerObjetoEspecificoController {

        @FXML
        private Button bnt_editar_objeto;

        @FXML
        private Button bnt_excluir_objeto;

        @FXML
        private Label info1;

        @FXML
        private Label info2;

        @FXML
        private Label info3;

        @FXML
        private Label info4;

        @FXML
        private Label titulo;

        @FXML
        private Button voltarTelaObjeto;

        private Object objetoAtual;

        @FXML
        void editarObjeto(ActionEvent event) {
            try {
                if (objetoAtual == null) return;

                if (objetoAtual instanceof Papel) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/telaEditarPapel.fxml"));
                    Parent root = loader.load();

                    // pega o controller da tela de edição
                    TelaEditarPapelController editarCtrl = loader.getController();

                    // passa o objeto original (não reconstrói a partir de labels)
                    editarCtrl.receberPapel((Papel) objetoAtual);

                    // troca a cena no mesmo stage
                    Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(root));
                }

                if (objetoAtual instanceof Passaro) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/telaEditarPassaro.fxml"));
                    Parent root = loader.load();

                    TelaEditarPassaroController editarCtrl = loader.getController();
                    editarCtrl.receberPassaro((Passaro) objetoAtual);

                    Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(root));
                }
                if (objetoAtual instanceof Estrela) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/telaEditarEstrela.fxml"));
                    Parent root = loader.load();

                    // pega o controller da tela de edição
                    TelaEditarEstrelaController editarCtrl = loader.getController();

                    // passa o objeto original (não reconstrói a partir de labels)
                    editarCtrl.receberEstrela((Estrela) objetoAtual);

                    // troca a cena no mesmo stage
                    Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(root));
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // helper
        private String safe(String s) { return s == null ? "" : s; }

        @FXML
        void excluirObjeto(ActionEvent event) {
            try {
                if (objetoAtual == null) return;

                boolean confirmar = Alerts.mostrarConfirmacao("Tem certeza que deseja excluir este item?");
                if (!confirmar) return;

                if (objetoAtual instanceof Papel) {
                    Papel papel = (Papel) objetoAtual;

                    PapelDAO dao = new PapelDAO();
                    dao.deletar(papel);
                }

                else if (objetoAtual instanceof Passaro) {
                    Passaro passaro = (Passaro) objetoAtual;
                    PassaroDAO dao = new PassaroDAO();
                    dao.deletar(passaro);
                }

                else if (objetoAtual instanceof Estrela) {
                    Estrela estrela = (Estrela) objetoAtual;
                    EstrelaDAO dao = new EstrelaDAO();
                    dao.deletar(estrela);
                }

                Alerts.mostrarSucesso("Objeto excluído com sucesso!");


                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/TelaVerObjetos.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));

            } catch (Exception e) {
                e.printStackTrace();
                Alerts.mostrarErro("Erro ao excluir objeto!");
            }
        }

        public void receberObjeto(Object objeto) {
            this.objetoAtual = objeto;
            if (objeto instanceof Papel) {
                Papel papel = (Papel) objeto;
                titulo.setText("Papel");
                info1.setText("Cor: " + papel.getCor());
                info2.setText("Tamanho: " + papel.getTamanho());
                info3.setText("É desenhado? " + (papel.isDesenhado() ? "Sim" : "Não"));
                info4.setVisible(false);
            }
            else if (objeto instanceof Passaro) {
                Passaro passaro = (Passaro) objeto;
                titulo.setText("Pássaro");
                info1.setText("Espécie: " + passaro.getEspecie());
                info2.setText("Cor: " + passaro.getCor());
                info3.setText("Peso: " + passaro.getPeso() + " k");
                info4.setVisible(false);
            }
            else if (objeto instanceof Estrela) {
                Estrela estrela = (Estrela) objeto;
                titulo.setText("Estrela");
                info1.setText("Nome: " + estrela.getNome());
                info2.setText("Cor: " + estrela.getCor());
                info3.setText("Tamanho: " + estrela.getTamanho() + " Km");
                info4.setText("Distância da Terra: " + estrela.getDistTerra() + " Ly");

            }
        }

        @FXML
        void voltarTelaAnterior(ActionEvent event) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/TelaVerObjetos.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



    }

