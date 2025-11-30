package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.catalogo.CatalogoIngrediente;
import com.mycompany.mavenproject1.catalogo.CatalogoLotePao;
import com.mycompany.mavenproject1.catalogo.CatalogoPadeiro;
import com.mycompany.mavenproject1.catalogo.CatalogoTipoPao;
import com.mycompany.mavenproject1.controlador.ControladorGeral;
import com.mycompany.mavenproject1.controlador.ControladorIngrediente;
import com.mycompany.mavenproject1.controlador.ControladorLotePao;
import com.mycompany.mavenproject1.controlador.ControladorPadeiro;
import com.mycompany.mavenproject1.controlador.ControladorTipoPao;
import com.mycompany.mavenproject1.modelo.Gas;
import com.mycompany.mavenproject1.modelo.Registro;
import com.mycompany.mavenproject1.ui.Menu;
import com.mycompany.mavenproject1.ui.MenuIngrediente;
import com.mycompany.mavenproject1.ui.MenuLote;
import com.mycompany.mavenproject1.ui.MenuPadeiro;
import com.mycompany.mavenproject1.ui.MenuReceita;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    
    @Override
    public void start(Stage stage) {
        
        CatalogoPadeiro catalogoPadeiro = new CatalogoPadeiro();
        CatalogoLotePao catalogoLotePao = new CatalogoLotePao();
        CatalogoTipoPao catalogoTipoPao = new CatalogoTipoPao();
        CatalogoIngrediente catalogoIngrediente = new CatalogoIngrediente();
        
        ControladorPadeiro controladorPadeiro = new ControladorPadeiro(catalogoPadeiro);
        ControladorLotePao controladorLotePao = new ControladorLotePao(catalogoLotePao);
        ControladorTipoPao controladorTipoPao = new ControladorTipoPao(catalogoTipoPao);
        ControladorIngrediente controladorIngrediente = new ControladorIngrediente(catalogoIngrediente);
        Gas gas = new Gas(20, 2, 200); 
        Registro registro = new Registro(0, 0);


        ControladorGeral controladorGeral = new ControladorGeral(controladorPadeiro, controladorLotePao, controladorTipoPao, controladorIngrediente, gas, registro);        
        Menu menuPrincipal = new Menu(stage);
        
        MenuPadeiro menuPadeiro = new MenuPadeiro(stage, controladorGeral, menuPrincipal);
        MenuIngrediente menuIngrediente = new MenuIngrediente(stage, controladorGeral, menuPrincipal);
        MenuReceita menuReceita = new MenuReceita(stage, controladorGeral, menuPrincipal);
        MenuLote menuLote = new MenuLote(stage, controladorGeral, menuPrincipal);

        
        menuPrincipal.setMenuPadeiro(menuPadeiro);
        menuPrincipal.setMenuIngrediente(menuIngrediente);
        menuPrincipal.setMenuReceita(menuReceita);
        menuPrincipal.setMenuLote(menuLote);
        
        menuPrincipal.mostrarMenuPrincipal();
    }


    public static void main(String[] args) {
        launch();
    }

}