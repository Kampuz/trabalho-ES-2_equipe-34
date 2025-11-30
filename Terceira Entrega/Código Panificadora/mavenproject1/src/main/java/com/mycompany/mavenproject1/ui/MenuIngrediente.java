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

public class MenuIngrediente {

    private Stage stage;
    private ControladorGeral controladorGeral;
    private Menu menuPrincipal;
    private ListView<String> listViewIngredientes;

    public MenuIngrediente(Stage stage, ControladorGeral controladorGeral, Menu menuPrincipal) {
        this.stage = stage;
        this.controladorGeral = controladorGeral;
        this.menuPrincipal = menuPrincipal;
        this.listViewIngredientes = new ListView<>();
    }

    private void atualizarListaIngredientes() {
        ObservableList<String> observableIngredientes = FXCollections.observableArrayList(controladorGeral.getTodosNomesIngrediente());
        listViewIngredientes.setItems(observableIngredientes);  // Atualiza o conteúdo da ListView
    }

    public void mostrar() {

        Label labelTitulo = new Label("Panificadora - Gerenciar Ingredientes");
        labelTitulo.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-padding: 8px; "
                            + "-fx-text-fill: #ffffff; -fx-alignment: center;");
        Region linha = new Region();
        linha.setStyle("-fx-background-color: #ffffff; -fx-pref-height: 2px;");

        Button btnAdicionar = new Button("Adicionar Ingrediente");
        btnAdicionar.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                            + "-fx-pref-width: 200px; -fx-padding: 10px; -fx-border-radius: 10px; "
                            + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnAdicionar.setOnAction(e -> mostrarAdicionarIngrediente());
        btnAdicionar.setOnMouseEntered(e -> btnAdicionar.setStyle("-fx-background-color: #D0B6A4; -fx-text-fill: #423327; "
                                                              + "-fx-font-size: 14px; -fx-pref-width: 200px; "
                                                              + "-fx-padding: 10px; -fx-border-radius: 10px; "
                                                              + "-fx-background-radius: 10px; -fx-border-color: transparent;"));
        btnAdicionar.setOnMouseExited(e -> btnAdicionar.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; "
                                                                + "-fx-font-size: 14px; -fx-pref-width: 200px; "
                                                                + "-fx-padding: 10px; -fx-border-radius: 10px; "
                                                                + "-fx-background-radius: 10px; -fx-border-color: transparent;"));

        Button btnComprar = new Button("Comprar Ingrediente");
        btnComprar.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                           + "-fx-pref-width: 200px; -fx-padding: 10px; -fx-border-radius: 10px; "
                           + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnComprar.setOnAction(e -> mostrarComprarIngrediente());
        btnComprar.setOnMouseEntered(e -> btnComprar.setStyle("-fx-background-color: #D0B6A4; -fx-text-fill: #423327; "
                                                           + "-fx-font-size: 14px; -fx-pref-width: 200px; "
                                                           + "-fx-padding: 10px; -fx-border-radius: 10px; "
                                                           + "-fx-background-radius: 10px; -fx-border-color: transparent;"));
        btnComprar.setOnMouseExited(e -> btnComprar.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; "
                                                           + "-fx-font-size: 14px; -fx-pref-width: 200px; "
                                                           + "-fx-padding: 10px; -fx-border-radius: 10px; "
                                                           + "-fx-background-radius: 10px; -fx-border-color: transparent;"));

        Region espaco = new Region();
        espaco.setPrefHeight(38);

        Button btnVoltar = new Button("Voltar");
        btnVoltar.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                          + "-fx-pref-width: 200px; -fx-padding: 10px; -fx-border-radius: 10px; "
                          + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnVoltar.setOnAction(e -> menuPrincipal.mostrarMenuPrincipal());
        btnVoltar.setOnMouseEntered(e -> btnVoltar.setStyle("-fx-background-color: #D0B6A4; -fx-text-fill: #423327; "
                                                         + "-fx-font-size: 14px; -fx-pref-width: 200px; "
                                                         + "-fx-padding: 10px; -fx-border-radius: 10px; "
                                                         + "-fx-background-radius: 10px; -fx-border-color: transparent;"));
        btnVoltar.setOnMouseExited(e -> btnVoltar.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; "
                                                         + "-fx-font-size: 14px; -fx-pref-width: 200px; "
                                                         + "-fx-padding: 10px; -fx-border-radius: 10px; "
                                                         + "-fx-background-radius: 10px; -fx-border-color: transparent;"));

        listViewIngredientes.setPrefWidth(200);
        listViewIngredientes.setPrefHeight(180);
        listViewIngredientes.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327;");  // Definindo a cor do fundo e do texto

        listViewIngredientes.setCellFactory(listView -> {
            ListCell<String> cell = new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                        setText(item);
                        setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327;");  // Aplica o estilo de fundo e texto aos itens
                    } else {
                        setText(null);
                        setStyle("-fx-background-color: transparent;");  // Evita estilo para itens vazios
                    }
                }
            };
            return cell;
        });

        atualizarListaIngredientes();  // Atualiza a lista de ingredientes ao mostrar a tela se nao fica o mesmo

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(listViewIngredientes);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        VBox leftLayout = new VBox(15, btnAdicionar, btnComprar, espaco, btnVoltar);
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
        stage.setTitle("Menu Ingrediente");
        stage.show();
    }

    private void mostrarAdicionarIngrediente() {
        Stage popup = new Stage();
        popup.setTitle("Adicionar Ingrediente");

        Label nomeLabel = new Label("Nome");
        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome");

        Label cpqLabel = new Label("Custo Por Quilo");
        TextField cpqField = new TextField();
        cpqField.setPromptText("Custo Por Quilo");

        Label cupLabel = new Label("CUP");
        TextField cupField = new TextField();
        cupField.setPromptText("CUP");

        Button btnSalvar = new Button("Salvar");
        btnSalvar.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                          + "-fx-pref-width: 100px; -fx-padding: 10px; -fx-border-radius: 10px; "
                          + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnSalvar.setOnAction(e -> {
            try {
                controladorGeral.adicionarIngrediente(nomeField.getText(), cpqField.getText(), cupField.getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ingrediente adicionado!");
                alert.showAndWait();
                popup.close();
                atualizarListaIngredientes();  // Atualiza a lista após adicionar o ingrediente
            } catch (IllegalArgumentException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
                alert.showAndWait();
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Ocorreu um erro inesperado.");
                alert.showAndWait();
            }
        });

        VBox layout = new VBox(10, nomeLabel, nomeField, cpqLabel, cpqField, cupLabel, cupField, btnSalvar);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 300);
        popup.setScene(scene);
        popup.show();
    }

    private void mostrarComprarIngrediente() {
        Stage popup = new Stage();
        popup.setTitle("Comprar Ingrediente");

        ComboBox<String> comboBoxIngredientes = new ComboBox<>();
        ObservableList<String> ingredientesDisponiveis = FXCollections.observableArrayList(controladorGeral.getTodosNomesIngrediente());
        comboBoxIngredientes.setItems(ingredientesDisponiveis);
        comboBoxIngredientes.setPromptText("Escolha um Ingrediente");

        TextField quantiaField = new TextField();
        quantiaField.setPromptText("Quantidade");

        Button btnComprar = new Button("Comprar");
        btnComprar.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                           + "-fx-pref-width: 100px; -fx-padding: 10px; -fx-border-radius: 10px; "
                           + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnComprar.setOnAction(e -> {
            String nomeIngrediente = comboBoxIngredientes.getValue();  // Obtém o ingrediente selecionado
            String quantidade = quantiaField.getText();  // Obtém a quantidade

            if (nomeIngrediente == null || nomeIngrediente.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor, selecione um ingrediente.");
                alert.showAndWait();
                return;
            }

            try {
                controladorGeral.comprarIngrediente(nomeIngrediente, quantidade);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ingrediente comprado!");
                alert.showAndWait();
                popup.close();
                atualizarListaIngredientes();  // Atualiza a lista após comprar o ingrediente
            } catch (IllegalArgumentException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
                alert.showAndWait();
            }
        });

        VBox layout = new VBox(10, comboBoxIngredientes, quantiaField, btnComprar);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 200);
        popup.setScene(scene);
        popup.show();
    }
}
