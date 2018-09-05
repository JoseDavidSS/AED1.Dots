package com.dots.client.menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaJuego extends Application {

    Stage juego;
    Scene Tablero;
    Scene ventana3x3;

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage stagePrimario){

        juego = stagePrimario;

        Label label1 = new Label("Tamaño de Tablero:");
        Button boton1 = new Button("3x3");
        boton1.setOnAction(e -> juego.setScene(ventana3x3));

        Button boton2 = new Button("5x5");
        boton1.setOnAction(e -> juego.setScene(ventana3x3));

        Button boton3 = new Button("7x7");
        boton1.setOnAction(e -> juego.setScene(ventana3x3));

        VBox orden1 = new VBox(20);
        orden1.getChildren().addAll(label1, boton1, boton2, boton3);

        Tablero = new Scene(orden1, 400, 400);

        Button boton5 = new Button("Volver");
        boton2.setOnAction(e -> juego.setScene(Tablero));

        HBox orden2 = new HBox(20);
        orden2.getChildren().addAll(boton5);
        ventana3x3 = new Scene(orden2, 400, 400);

        juego.setScene(Tablero);
        juego.setTitle("Dots");
        juego.show();

    }

}
