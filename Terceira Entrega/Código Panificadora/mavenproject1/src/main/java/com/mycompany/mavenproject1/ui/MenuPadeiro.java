package com.mycompany.mavenproject1.ui;

import com.mycompany.mavenproject1.controlador.ControladorGeral;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuPadeiro {

    private Stage stage;
    private ControladorGeral controladorGeral;
    private Menu menuPrincipal;
    private ListView<String> listViewPadeiros;

    public MenuPadeiro(Stage stage, ControladorGeral controladorGeral, Menu menuPrincipal) {
        this.stage = stage;
        this.controladorGeral = controladorGeral;
        this.menuPrincipal = menuPrincipal;
        this.listViewPadeiros = new ListView<>();
    }

    private void atualizarListaPadeiros() {
        ObservableList<String> observablePadeiros = FXCollections.observableArrayList(controladorGeral.getNomesPadeiros());
        listViewPadeiros.setItems(observablePadeiros);  // Atualiza o conteúdo da ListView
    }

    public void mostrar() {

        Label labelTitulo = new Label("Panificadora - Gerenciar Padeiros");
        labelTitulo.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-padding: 10px; "
                            + "-fx-text-fill: #ffffff; -fx-alignment: center;");
        Region linha = new Region();
        linha.setStyle("-fx-background-color: #ffffff; -fx-pref-height: 2px;");

        Button btnAdicionar = new Button("Adicionar Padeiro");
        btnAdicionar.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                            + "-fx-pref-width: 200px; -fx-padding: 10px; -fx-border-radius: 10px; "
                            + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnAdicionar.setOnAction(e -> mostrarAdicionarPadeiro());
        btnAdicionar.setOnMouseEntered(e -> btnAdicionar.setStyle("-fx-background-color: #D0B6A4; -fx-text-fill: #423327; "
                                                              + "-fx-font-size: 14px; -fx-pref-width: 200px; "
                                                              + "-fx-padding: 10px; -fx-border-radius: 10px; "
                                                              + "-fx-background-radius: 10px; -fx-border-color: transparent;"));
        btnAdicionar.setOnMouseExited(e -> btnAdicionar.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; "
                                                                + "-fx-font-size: 14px; -fx-pref-width: 200px; "
                                                                + "-fx-padding: 10px; -fx-border-radius: 10px; "
                                                                + "-fx-background-radius: 10px; -fx-border-color: transparent;"));

        Button btnAtualizar = new Button("Atualizar Salário");
        btnAtualizar.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                            + "-fx-pref-width: 200px; -fx-padding: 10px; -fx-border-radius: 10px; "
                            + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnAtualizar.setOnAction(e -> mostrarAtualizarPadeiro());

        Button btnRemover = new Button("Remover Padeiro");
        btnRemover.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                           + "-fx-pref-width: 200px; -fx-padding: 10px; -fx-border-radius: 10px; "
                           + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnRemover.setOnAction(e -> mostrarRemoverPadeiro());

        Button btnVoltar = new Button("Voltar");
        btnVoltar.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                          + "-fx-pref-width: 200px; -fx-padding: 10px; -fx-border-radius: 10px; "
                          + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnVoltar.setOnAction(e -> menuPrincipal.mostrarMenuPrincipal());

        listViewPadeiros.setPrefWidth(200);
        listViewPadeiros.setPrefHeight(180);
        listViewPadeiros.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327;");  // Definindo a cor do fundo e do texto

        listViewPadeiros.setCellFactory(listView -> {
            ListCell<String> cell = new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                        setText(item);
                        setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327;");  // Aplica o estilo de fundo e texto aos itens
                    } else {
                        setText(null);
                        setStyle("-fx-background-color: transparent;");
                    }
                }
            };
            return cell;
        });

        atualizarListaPadeiros();  // Atualiza a lista de padeiros ao mostrar a tela

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(listViewPadeiros);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        VBox leftLayout = new VBox(15, btnAdicionar, btnAtualizar, btnRemover, btnVoltar);
        leftLayout.setAlignment(Pos.CENTER_LEFT);

        VBox rightLayout = new VBox(10, scrollPane);
        rightLayout.setAlignment(Pos.CENTER);

        HBox root = new HBox(10, leftLayout, rightLayout);
        root.setSpacing(250);

        VBox rootLayout = new VBox(15, labelTitulo, linha, root);
        rootLayout.setAlignment(Pos.CENTER);
        rootLayout.setStyle("-fx-background-color: #B68F71; -fx-padding: 20px;");

        Scene scene = new Scene(rootLayout, 700, 350);
        stage.setScene(scene);
        stage.setTitle("Menu Padeiro");
        stage.show();
    }

    private void mostrarAdicionarPadeiro() {
        Stage popup = new Stage();
        popup.setTitle("Adicionar Padeiro");

        Label nomeLabel = new Label("Nome");
        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome");

        Label cpfLabel = new Label("CPF");
        TextField cpfField = new TextField();
        cpfField.setPromptText("CPF");

        Label salarioLabel = new Label("Salário");
        TextField salarioField = new TextField();
        salarioField.setPromptText("Salário");

        Button btnSalvar = new Button("Salvar");
        btnSalvar.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                          + "-fx-pref-width: 100px; -fx-padding: 10px; -fx-border-radius: 10px; "
                          + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnSalvar.setOnAction(e -> {
            try {
                controladorGeral.adicionarPadeiro(nomeField.getText(), cpfField.getText(), salarioField.getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Padeiro adicionado!");
                alert.showAndWait();
                popup.close();
                atualizarListaPadeiros();  // Atualiza a lista após adicionar
            } catch (IllegalArgumentException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
                alert.showAndWait();
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Ocorreu um erro inesperado.");
                alert.showAndWait();
            }
        });

        VBox layout = new VBox(10, nomeLabel, nomeField, cpfLabel, cpfField, salarioLabel, salarioField, btnSalvar);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 300);
        popup.setScene(scene);
        popup.show();
    }

    private void mostrarAtualizarPadeiro() {
        Stage popup = new Stage();
        popup.setTitle("Atualizar Salário");

        Label selecionarPadeiroLabel = new Label("Selecione o Padeiro");
        ComboBox<String> comboBoxPadeiros = new ComboBox<>();
        ObservableList<String> observablePadeiros = FXCollections.observableArrayList(controladorGeral.getNomesPadeiros());
        comboBoxPadeiros.setItems(observablePadeiros);

        Label salarioLabel = new Label("Novo Salário");
        TextField novoSalario = new TextField();
        novoSalario.setPromptText("Novo Salário");

        Button btnAtualizar = new Button("Atualizar");
        btnAtualizar.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                           + "-fx-pref-width: 100px; -fx-padding: 10px; -fx-border-radius: 10px; "
                           + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnAtualizar.setOnAction(e -> {
            try {
                String selecionado = comboBoxPadeiros.getValue();  // Obtém o padeiro selecionado
                controladorGeral.atualizarSalario(selecionado, novoSalario.getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Salário atualizado com sucesso!");
                alert.showAndWait();
                popup.close();
                atualizarListaPadeiros();  // Atualiza a lista após a atualização
            } catch (IllegalArgumentException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
                alert.showAndWait();
            }
        });

        VBox layout = new VBox(10, selecionarPadeiroLabel, comboBoxPadeiros, salarioLabel, novoSalario, btnAtualizar);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 300);
        popup.setScene(scene);
        popup.show();
    }

    private void mostrarRemoverPadeiro() {
        Stage popup = new Stage();
        popup.setTitle("Remover Padeiro");

        ComboBox<String> comboBoxPadeiros = new ComboBox<>();
        ObservableList<String> observablePadeiros = FXCollections.observableArrayList(controladorGeral.getNomesPadeiros());
        comboBoxPadeiros.setItems(observablePadeiros);

        Button btnRemover = new Button("Remover");
        btnRemover.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                           + "-fx-pref-width: 100px; -fx-padding: 10px; -fx-border-radius: 10px; "
                           + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnRemover.setOnAction(e -> {
            try {
                String selecionado = comboBoxPadeiros.getValue();  // Obtém o padeiro selecionado
                controladorGeral.removePadeiro(selecionado);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Padeiro removido!");
                alert.showAndWait();
                popup.close();
                atualizarListaPadeiros();  // Atualiza a lista após remover
            } catch (IllegalArgumentException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
                alert.showAndWait();
            }
        });

        VBox layout = new VBox(10, comboBoxPadeiros, btnRemover);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 150);
        popup.setScene(scene);
        popup.show();
    }
}
