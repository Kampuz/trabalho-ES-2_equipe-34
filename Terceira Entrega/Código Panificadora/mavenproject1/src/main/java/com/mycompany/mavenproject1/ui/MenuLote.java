package com.mycompany.mavenproject1.ui;

import com.mycompany.mavenproject1.controlador.ControladorGeral;
import com.mycompany.mavenproject1.modelo.LotePao;

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

public class MenuLote {

    private Stage stage;
    private ControladorGeral controladorGeral;
    private Menu menuPrincipal;
    private ListView<LotePao> listViewLotes;

    public MenuLote(Stage stage, ControladorGeral controladorGeral, Menu menuPrincipal) {
        this.stage = stage;
        this.controladorGeral = controladorGeral;
        this.menuPrincipal = menuPrincipal;
        this.listViewLotes = new ListView<>();
    }

    public void mostrar() {

        Label labelTitulo = new Label("Panificadora - Gerenciar Lotes de Pão");
        labelTitulo.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-padding: 8px; "
                            + "-fx-text-fill: #ffffff; -fx-alignment: center;");
        Region linha = new Region();
        linha.setStyle("-fx-background-color: #ffffff; -fx-pref-height: 2px;");

        Button btnAdicionar = new Button("Adicionar Lote de Pão");
        btnAdicionar.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                            + "-fx-pref-width: 200px; -fx-padding: 10px; -fx-border-radius: 10px; "
                            + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnAdicionar.setOnAction(e -> mostrarFazerLote());
        btnAdicionar.setOnMouseEntered(e -> btnAdicionar.setStyle("-fx-background-color: #D0B6A4; -fx-text-fill: #423327; "
                                                              + "-fx-font-size: 14px; -fx-pref-width: 200px; "
                                                              + "-fx-padding: 10px; -fx-border-radius: 10px; "
                                                              + "-fx-background-radius: 10px; -fx-border-color: transparent;"));
        btnAdicionar.setOnMouseExited(e -> btnAdicionar.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; "
                                                                + "-fx-font-size: 14px; -fx-pref-width: 200px; "
                                                                + "-fx-padding: 10px; -fx-border-radius: 10px; "
                                                                + "-fx-background-radius: 10px; -fx-border-color: transparent;"));

        Button btnVender = new Button("Vender Lote de Pão");
        btnVender.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                           + "-fx-pref-width: 200px; -fx-padding: 10px; -fx-border-radius: 10px; "
                           + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnVender.setOnAction(e -> mostrarVenderLote());
        btnVender.setOnMouseEntered(e -> btnVender.setStyle("-fx-background-color: #D0B6A4; -fx-text-fill: #423327; "
                                                           + "-fx-font-size: 14px; -fx-pref-width: 200px; "
                                                           + "-fx-padding: 10px; -fx-border-radius: 10px; "
                                                           + "-fx-background-radius: 10px; -fx-border-color: transparent;"));
        btnVender.setOnMouseExited(e -> btnVender.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; "
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

        listViewLotes.setPrefWidth(200);
        listViewLotes.setPrefHeight(180);
        listViewLotes.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327;");  // Definindo a cor do fundo e do texto

        listViewLotes.setCellFactory(lv -> new ListCell<LotePao>() {
            @Override
            protected void updateItem(LotePao lote, boolean empty) {
                super.updateItem(lote, empty);
                if (empty || lote == null) {
                    setText(null);
                } else {
                    setText("Lote \"" + lote.getTipoPao().getNome() + "\" código " + lote.getCodigo());
                    setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327;");
                }
            }
        });

        ObservableList<LotePao> lotesDisponiveis = FXCollections.observableArrayList(controladorGeral.getTodosLotes());
        listViewLotes.setItems(lotesDisponiveis);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(listViewLotes);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        VBox leftLayout = new VBox(15, btnAdicionar, btnVender, espaco, btnVoltar);
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
        stage.setTitle("Menu Lote de Pão");
        stage.show();
    }

    private void mostrarFazerLote() {
        Stage popup = new Stage();
        popup.setTitle("Fazer Lote de Pão");

        ComboBox<String> comboBoxPao = new ComboBox<>();
        ObservableList<String> tiposPao = FXCollections.observableArrayList();
        controladorGeral.getTodosTiposDePao().forEach(tipoPao -> tiposPao.add(tipoPao.getNome()));

        Label paoLabel = new Label("Selecione o Tipo de Pão");
        comboBoxPao.setItems(tiposPao);

        Label padeiroLabel = new Label("Selecione o Padeiro");
        ComboBox<String> comboBoxPadeiro = new ComboBox<>();
        ObservableList<String> nomesPadeiros = FXCollections.observableArrayList(controladorGeral.getNomesPadeiros());
        comboBoxPadeiro.setItems(nomesPadeiros);

        TextField quilosField = new TextField();
        quilosField.setPromptText("Quilos Feitos");

        TextField consumoField = new TextField();
        consumoField.setPromptText("Consumo de Gás");

        Button btnSalvar = new Button("Salvar");
        btnSalvar.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                          + "-fx-pref-width: 100px; -fx-padding: 10px; -fx-border-radius: 10px; "
                          + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnSalvar.setOnAction(e -> {
            try {
                String tipoPaoSelecionado = comboBoxPao.getSelectionModel().getSelectedItem();
                String padeiroSelecionado = comboBoxPadeiro.getSelectionModel().getSelectedItem();

                if (tipoPaoSelecionado == null || padeiroSelecionado == null) {
                    throw new IllegalArgumentException("Selecione o tipo de pão e o padeiro!");
                }

                int codigoLote = controladorGeral.fazerLote(tipoPaoSelecionado, quilosField.getText(), padeiroSelecionado, consumoField.getText());

                ObservableList<LotePao> lotesDisponiveis = FXCollections.observableArrayList(controladorGeral.getTodosLotes());
                listViewLotes.setItems(lotesDisponiveis);

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Lote feito com sucesso! Código do Lote: " + codigoLote);
                alert.showAndWait();
                popup.close();
            } catch (IllegalArgumentException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Erro: " + ex.getMessage());
                alert.showAndWait();
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Ocorreu um erro inesperado: " + ex.getMessage());
                alert.showAndWait();
            }
        });

        VBox layout = new VBox(10, paoLabel, comboBoxPao, padeiroLabel, comboBoxPadeiro, quilosField, consumoField, btnSalvar);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 250);
        popup.setScene(scene);
        popup.show();
    }

    private void mostrarVenderLote() {
        Stage popup = new Stage();
        popup.setTitle("Vender Lote");

        Label codigoLabel = new Label("Escreva o código do lote");
        TextField codigoField = new TextField();
        codigoField.setPromptText("Código do Lote");

        Label precoLabel = new Label("Escreva o preço de venda");
        TextField precoField = new TextField();
        precoField.setPromptText("Preço");

        Button btnVender = new Button("Vender");
        btnVender.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                           + "-fx-pref-width: 100px; -fx-padding: 10px; -fx-border-radius: 10px; "
                           + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnVender.setOnAction(e -> {
            try {
                controladorGeral.venderLote(codigoField.getText(), precoField.getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Lote vendido!");
                alert.showAndWait();

                ObservableList<LotePao> lotesDisponiveis = FXCollections.observableArrayList(controladorGeral.getTodosLotes());
                listViewLotes.setItems(lotesDisponiveis);

                popup.close();
            } catch (IllegalArgumentException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Erro: " + ex.getMessage());
                alert.showAndWait();
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Ocorreu um erro inesperado: " + ex.getMessage());
                alert.showAndWait();
            }
        });

        VBox layout = new VBox(10, codigoLabel, codigoField, precoLabel, precoField, btnVender);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 200);
        popup.setScene(scene);
        popup.show();
    }
}
