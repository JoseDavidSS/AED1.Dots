package com.dots.client.menu;

/**
 * Pruebas, cambio entre 2 ventanas
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MenuPrincipal extends Application {

    Stage menu;
    Scene ventanaPrincipal;
    Scene ventanaSecundaria;

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage stagePrimario){

        menu = stagePrimario;

        Label label1 = new Label("Prueba");
        Button boton1 = new Button("Cambiar escena");
        boton1.setOnAction(e -> menu.setScene(ventanaSecundaria));

        HBox orden1 = new HBox(20);
        orden1.getChildren().addAll(label1, boton1);

        ventanaPrincipal = new Scene(orden1, 200, 200);

        Button boton2 = new Button("Cambiar escena a la otra");
        boton2.setOnAction(e -> menu.setScene(ventanaPrincipal));

        StackPane orden2 = new StackPane();
        orden2.getChildren().addAll(boton2);
        ventanaSecundaria = new Scene(orden2, 400, 400);

        menu.setScene(ventanaPrincipal);
        menu.setTitle("HOLA");
        menu.show();

    }

}
