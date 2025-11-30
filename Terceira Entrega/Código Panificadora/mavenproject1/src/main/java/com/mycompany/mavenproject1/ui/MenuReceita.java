package com.mycompany.mavenproject1.ui;

import java.util.ArrayList;

import com.mycompany.mavenproject1.controlador.ControladorGeral;
import com.mycompany.mavenproject1.modelo.Receita;
import com.mycompany.mavenproject1.modelo.TipoPao;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuReceita {

    private Stage stage;
    private ControladorGeral controladorGeral;
    private Menu menuPrincipal;

    public MenuReceita(Stage stage, ControladorGeral controladorGeral, Menu menuPrincipal) {
        this.stage = stage;
        this.controladorGeral = controladorGeral;
        this.menuPrincipal = menuPrincipal;
    }

    public void mostrar() {
        Label labelTitulo = new Label("Panificadora - Gerenciar Receitas");
        labelTitulo.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-padding: 10px; "
                            + "-fx-text-fill: #ffffff; -fx-alignment: center;");
        Region linha = new Region();
        linha.setStyle("-fx-background-color: #ffffff; -fx-pref-height: 2px;");

        Button btnAdicionar = createStyledButton("Adicionar Tipos de Pães");
        btnAdicionar.setOnAction(e -> mostrarAdicionarTipoPao());

        Button btnRemover = createStyledButton("Remover Tipos de Pães");
        btnRemover.setOnAction(e -> mostrarRemoverTipo());

        Button btnMostrar = createStyledButton("Mostrar Receita de Pão");
        btnMostrar.setOnAction(e -> mostrarReceitaTipo());

        Button btnVoltar = createStyledButton("Voltar");
        btnVoltar.setOnAction(e -> menuPrincipal.mostrarMenuPrincipal());

        VBox leftLayout = new VBox(15, btnAdicionar, btnRemover, btnMostrar, btnVoltar);
        leftLayout.setAlignment(Pos.CENTER_LEFT);

        VBox rootLayout = new VBox(15, labelTitulo, linha, leftLayout);
        rootLayout.setAlignment(Pos.CENTER);
        rootLayout.setStyle("-fx-background-color: #B68F71; -fx-padding: 20px;");

        Scene scene = new Scene(rootLayout, 700, 350);
        stage.setScene(scene);
        stage.setTitle("Menu Receita de Pão");
        stage.show();
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                      + "-fx-pref-width: 200px; -fx-padding: 10px; -fx-border-radius: 10px; "
                      + "-fx-background-radius: 10px; -fx-border-color: transparent;");

        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #D0B29E; -fx-text-fill: #423327; "
                                                    + "-fx-font-size: 14px; -fx-pref-width: 200px; -fx-padding: 10px; "
                                                    + "-fx-border-radius: 10px; -fx-background-radius: 10px; "
                                                    + "-fx-border-color: transparent;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; "
                                                   + "-fx-font-size: 14px; -fx-pref-width: 200px; -fx-padding: 10px; "
                                                   + "-fx-border-radius: 10px; -fx-background-radius: 10px; "
                                                   + "-fx-border-color: transparent;"));
        return button;
    }

    private void mostrarAdicionarTipoPao() {
        Stage popup = new Stage();
        popup.setTitle("Adicionar Tipo de Pão");

        Label nomeLabel = new Label("Nome do Tipo de Pão:");
        TextField nomeField = new TextField();
        nomeField.setPromptText("Digite o nome do tipo de pão");

        Button btnProximo = createStyledButton("Próximo");
        btnProximo.setOnAction(e -> {
            String nomePao = nomeField.getText();
            if (nomePao.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Nome do tipo de pão é obrigatório!");
                alert.showAndWait();
            } else {
                popup.close();
                mostrarAdicionarIngredientes(nomePao, popup);
            }
        });

        VBox layout = new VBox(10, nomeLabel, nomeField, btnProximo);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 150);
        popup.setScene(scene);
        popup.show();
    }

    private void mostrarAdicionarIngredientes(String nomePao, Stage popupAnterior) {
        Stage popup = new Stage();
        popup.setTitle("Adicionar Ingredientes");

        Label adicionarLabel = new Label("Adicione os ingredientes:");

        ArrayList<String> ingredientesDisponiveis = controladorGeral.getTodosNomesIngrediente();
        ArrayList<String> ingredientesSelecionados = new ArrayList<>();
        ArrayList<Float> quantidadesSelecionadas = new ArrayList<>();

        ListView<String> listaIngredientes = new ListView<>();
        listaIngredientes.getItems().addAll(ingredientesDisponiveis);

        ListView<String> listaIngredientesAdicionados = new ListView<>();
        listaIngredientesAdicionados.setEditable(false);

        TextField quantidadeField = new TextField();
        quantidadeField.setPromptText("Quantidade");
        quantidadeField.setMaxWidth(100);

        Button btnAdicionarIngrediente = createStyledButton("Adicionar Ingrediente");
        btnAdicionarIngrediente.setOnAction(e -> {
            String ingredienteSelecionado = listaIngredientes.getSelectionModel().getSelectedItem();
            String quantidadeTexto = quantidadeField.getText();

            if (ingredienteSelecionado != null && !quantidadeTexto.isEmpty()) {
                try {
                    Float quantidade = Float.parseFloat(quantidadeTexto);
                    ingredientesSelecionados.add(ingredienteSelecionado);
                    quantidadesSelecionadas.add(quantidade);
                    listaIngredientesAdicionados.getItems().add(ingredienteSelecionado + " - " + quantidade + " kg");
                    quantidadeField.clear();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ingrediente Adicionado!");
                    alert.showAndWait();
                } catch (NumberFormatException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Quantidade inválida!");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Selecione um ingrediente e insira a quantidade.");
                alert.showAndWait();
            }
        });

        Button btnRemoverIngrediente = createStyledButton("Remover Ingrediente Selecionado");
        btnRemoverIngrediente.setOnAction(e -> {
            String ingredienteSelecionado = listaIngredientesAdicionados.getSelectionModel().getSelectedItem();

            if (ingredienteSelecionado != null) {
                int index = listaIngredientesAdicionados.getSelectionModel().getSelectedIndex();
                ingredientesSelecionados.remove(index);
                quantidadesSelecionadas.remove(index);
                listaIngredientesAdicionados.getItems().remove(index);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ingrediente removido!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Selecione um ingrediente para remover.");
                alert.showAndWait();
            }
        });

        Button btnProximo = createStyledButton("Próximo");
        btnProximo.setOnAction(e -> {
            if (ingredientesSelecionados.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Adicione ao menos um ingrediente.");
                alert.showAndWait();
            } else {
                popup.close();
                mostrarDefinirCUPETempo(nomePao, ingredientesSelecionados, quantidadesSelecionadas, popup);
            }
        });

        ScrollPane scrollIngredientes = new ScrollPane(listaIngredientes);
        scrollIngredientes.setFitToWidth(true);
        scrollIngredientes.setPrefHeight(200);

        ScrollPane scrollIngredientesAdicionados = new ScrollPane(listaIngredientesAdicionados);
        scrollIngredientesAdicionados.setFitToWidth(true);
        scrollIngredientesAdicionados.setPrefHeight(200);

        HBox hBox = new HBox(20, scrollIngredientes, scrollIngredientesAdicionados);
        VBox layout = new VBox(10, adicionarLabel, hBox, quantidadeField, btnAdicionarIngrediente, btnRemoverIngrediente, btnProximo);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 500, 400);
        popup.setScene(scene);
        popup.show();
    }

    private void mostrarDefinirCUPETempo(String nomePao, ArrayList<String> ingredientesSelecionados, ArrayList<Float> quantidadesSelecionadas, Stage popupAnterior) {
        Stage popup = new Stage();
        popup.setTitle("Definir CUP e Tempo Necessário");

        Label cupLabel = new Label("CUP:");
        TextField cupField = new TextField();
        cupField.setPromptText("CUP");

        Label tempoLabel = new Label("Tempo de preparo:");
        TextField tempoField = new TextField();
        tempoField.setPromptText("Tempo Necessário (minutos)");

        Button btnSalvar = createStyledButton("Salvar");
        btnSalvar.setOnAction(e -> {
            String cup = cupField.getText();
            String tempoTexto = tempoField.getText();

            if (cup.isEmpty() || tempoTexto.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "CUP e Tempo são obrigatórios!");
                alert.showAndWait();
            } else {
                try {
                    int tempo = Integer.parseInt(tempoTexto);
                    controladorGeral.adicionarTipoPao(nomePao, cup, tempoTexto, ingredientesSelecionados, quantidadesSelecionadas);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Tipo de Pão adicionado com sucesso!");
                    alert.showAndWait();
                    popup.close();
                } catch (NumberFormatException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Tempo inválido!");
                    alert.showAndWait();
                }
            }
        });

        VBox layout = new VBox(10, cupLabel, cupField, tempoLabel, tempoField, btnSalvar);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 200);
        popup.setScene(scene);
        popup.show();
    }

    private void mostrarRemoverTipo() {
        Stage popup = new Stage();
        popup.setTitle("Remover Tipo de Pão");

        Label removeLabel = new Label("Selecione o tipo de pão para remover:");

        ComboBox<String> tipoPaoComboBox = new ComboBox<>();
        ArrayList<TipoPao> tiposDePao = controladorGeral.getTodosTiposDePao();

        for (TipoPao tipoPao : tiposDePao) {
            tipoPaoComboBox.getItems().add(tipoPao.getNome());
        }

        if (tiposDePao.isEmpty()) {
            tipoPaoComboBox.getItems().add("Nenhum tipo de pão registrado");
            tipoPaoComboBox.setDisable(true);
        }

        Button btnRemover = createStyledButton("Remover");
        btnRemover.setOnAction(e -> {
            String tipoSelecionado = tipoPaoComboBox.getValue();

            if (tipoSelecionado == null || tipoSelecionado.isEmpty() || tipoSelecionado.equals("Nenhum tipo de pão registrado")) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Selecione um tipo de pão para remover.");
                alert.showAndWait();
            } else {
                try {
                    TipoPao tipoPaoSelecionado = controladorGeral.getTipoPaoPorNome(tipoSelecionado);
                    if (tipoPaoSelecionado != null) {
                        controladorGeral.removerTipoPao(tipoPaoSelecionado.getNome());
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Tipo removido com sucesso!");
                        alert.showAndWait();
                        popup.close();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Tipo de pão não encontrado.");
                        alert.showAndWait();
                    }
                } catch (Exception ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Ocorreu um erro inesperado.");
                    alert.showAndWait();
                }
            }
        });

        VBox layout = new VBox(10, removeLabel, tipoPaoComboBox, btnRemover);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 150);
        popup.setScene(scene);
        popup.show();
    }

    private void mostrarReceitaTipo() {
        Stage popup = new Stage();
        popup.setTitle("Mostrar Receita de Tipo de Pão");

        Label receitaLabel = new Label("Receita do Tipo de Pão:");

        ComboBox<String> tipoPaoComboBox = new ComboBox<>();
        ArrayList<TipoPao> tiposDePao = controladorGeral.getTodosTiposDePao();

        for (TipoPao tipoPao : tiposDePao) {
            tipoPaoComboBox.getItems().add(tipoPao.getNome());
        }

        if (tiposDePao.isEmpty()) {
            tipoPaoComboBox.getItems().add("Nenhum tipo de pão registrado");
            tipoPaoComboBox.setDisable(true);
        }

        TextArea resultadoArea = new TextArea();
        resultadoArea.setEditable(false);
        resultadoArea.setPrefRowCount(8);
        resultadoArea.setPrefWidth(250);

        Button btnBuscar = createStyledButton("Buscar");
        btnBuscar.setOnAction(e -> {
            String tipoSelecionado = tipoPaoComboBox.getValue();

            if (tipoSelecionado == null || tipoSelecionado.equals("Nenhum tipo de pão registrado")) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Selecione um tipo de pão!");
                alert.showAndWait();
                return;
            }

            var tipo = controladorGeral.getTipoPaoPorNome(tipoSelecionado);
            if (tipo == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Pão não encontrado!");
                alert.showAndWait();
                return;
            }

            Receita receita = tipo.getReceita();
            if (receita == null || receita.getIngredientes().isEmpty()) {
                resultadoArea.setText("Este pão não possui receita.");
                return;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Receita de ").append(tipo.getNome()).append(":\n\n");

            for (int i = 0; i < receita.getIngredientes().size(); i++) {
                var ing = receita.getIngredientes().get(i);
                float quantia = receita.getQuantiaIngredientes().get(i);
                sb.append("- ").append(ing.getNome())
                .append(": ").append(quantia).append(" kg\n");
            }

            resultadoArea.setText(sb.toString());
        });

        VBox layout = new VBox(10, receitaLabel, tipoPaoComboBox, btnBuscar, resultadoArea);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 350, 300);
        popup.setScene(scene);
        popup.show();
    }
}
