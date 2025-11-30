package com.mycompany.mavenproject1.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Menu {
    private MenuPadeiro menuPadeiro;
    private MenuIngrediente menuIngrediente;
    private MenuLote menuLote;
    private MenuReceita menuReceita;
    private Stage stage;

    public Menu(Stage stage) {
        this.stage = stage;
    }

    public void mostrarMenuPrincipal() {

        // Título
        Label labelTitulo = new Label("Panificadora - Menu Principal");
        labelTitulo.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-padding: 10px; "
                            + "-fx-text-fill: #ffffff; -fx-alignment: center;");
        Region linha = new Region();
        linha.setStyle("-fx-background-color: #ffffff; -fx-pref-height: 2px;");

        HBox hboxTitulo = new HBox(labelTitulo);
        hboxTitulo.setAlignment(Pos.CENTER); 

        // Botões
        Button btnPadeiro = new Button("Gerenciar Padeiros");
        btnPadeiro.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                            + "-fx-pref-width: 200px; -fx-padding: 10px; -fx-border-radius: 10px; "
                            + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnPadeiro.setOnAction(e -> menuPadeiro.mostrar());
        btnPadeiro.setOnMouseEntered(e -> btnPadeiro.setStyle("-fx-background-color: #D0B6A4; -fx-text-fill: #423327; "
                                                           + "-fx-font-size: 14px; -fx-pref-width: 200px; "
                                                           + "-fx-padding: 10px; -fx-border-radius: 10px; "
                                                           + "-fx-background-radius: 10px; -fx-border-color: transparent;"));
        btnPadeiro.setOnMouseExited(e -> btnPadeiro.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; "
                                                           + "-fx-font-size: 14px; -fx-pref-width: 200px; "
                                                           + "-fx-padding: 10px; -fx-border-radius: 10px; "
                                                           + "-fx-background-radius: 10px; -fx-border-color: transparent;"));

        Button btnIngredientes = new Button("Gerenciar Ingredientes");
        btnIngredientes.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                                 + "-fx-pref-width: 200px; -fx-padding: 10px; -fx-border-radius: 10px; "
                                 + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnIngredientes.setOnAction(e -> menuIngrediente.mostrar());
        btnIngredientes.setOnMouseEntered(e -> btnIngredientes.setStyle("-fx-background-color: #D0B6A4; -fx-text-fill: #423327; "
                                                                     + "-fx-font-size: 14px; -fx-pref-width: 200px; "
                                                                     + "-fx-padding: 10px; -fx-border-radius: 10px; "
                                                                     + "-fx-background-radius: 10px; -fx-border-color: transparent;"));
        btnIngredientes.setOnMouseExited(e -> btnIngredientes.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; "
                                                                     + "-fx-font-size: 14px; -fx-pref-width: 200px; "
                                                                     + "-fx-padding: 10px; -fx-border-radius: 10px; "
                                                                     + "-fx-background-radius: 10px; -fx-border-color: transparent;"));

        Button btnReceitas = new Button("Gerenciar Receitas");
        btnReceitas.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                             + "-fx-pref-width: 200px; -fx-padding: 10px; -fx-border-radius: 10px; "
                             + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnReceitas.setOnAction(e -> menuReceita.mostrar());
        btnReceitas.setOnMouseEntered(e -> btnReceitas.setStyle("-fx-background-color: #D0B6A4; -fx-text-fill: #423327; "
                                                             + "-fx-font-size: 14px; -fx-pref-width: 200px; "
                                                             + "-fx-padding: 10px; -fx-border-radius: 10px; "
                                                             + "-fx-background-radius: 10px; -fx-border-color: transparent;"));
        btnReceitas.setOnMouseExited(e -> btnReceitas.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; "
                                                             + "-fx-font-size: 14px; -fx-pref-width: 200px; "
                                                             + "-fx-padding: 10px; -fx-border-radius: 10px; "
                                                             + "-fx-background-radius: 10px; -fx-border-color: transparent;"));

        Button btnLotes = new Button("Gerenciar Lotes");
        btnLotes.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; -fx-font-size: 14px; "
                          + "-fx-pref-width: 200px; -fx-padding: 10px; -fx-border-radius: 10px; "
                          + "-fx-background-radius: 10px; -fx-border-color: transparent;");
        btnLotes.setOnAction(e -> menuLote.mostrar());
        btnLotes.setOnMouseEntered(e -> btnLotes.setStyle("-fx-background-color: #D0B6A4; -fx-text-fill: #423327; "
                                                        + "-fx-font-size: 14px; -fx-pref-width: 200px; "
                                                        + "-fx-padding: 10px; -fx-border-radius: 10px; "
                                                        + "-fx-background-radius: 10px; -fx-border-color: transparent;"));
        btnLotes.setOnMouseExited(e -> btnLotes.setStyle("-fx-background-color: #E2CDBE; -fx-text-fill: #423327; "
                                                        + "-fx-font-size: 14px; -fx-pref-width: 200px; "
                                                        + "-fx-padding: 10px; -fx-border-radius: 10px; "
                                                        + "-fx-background-radius: 10px; -fx-border-color: transparent;"));

        // Layout
        VBox root = new VBox(15, hboxTitulo, linha, btnPadeiro, btnIngredientes, btnReceitas, btnLotes);
        root.setAlignment(Pos.CENTER_LEFT);
        root.setStyle("-fx-background-color: #B68F71; -fx-padding: 20px;");

        Scene scene = new Scene(root, 700, 350);

        stage.setTitle("Panificadora - Menu Principal");
        stage.setScene(scene);
        stage.show();
    }

    public void setMenuPadeiro(MenuPadeiro menu) {
        this.menuPadeiro = menu;
    }

    public void setMenuIngrediente(MenuIngrediente menu) {
        this.menuIngrediente = menu;
    }

    public void setMenuLote(MenuLote menu) {
        this.menuLote = menu;
    }

    public void setMenuReceita(MenuReceita menu) {
        this.menuReceita = menu;
    }
}
