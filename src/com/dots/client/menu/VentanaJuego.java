package com.dots.client.menu;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class VentanaJuego extends Application implements EventHandler<ActionEvent> {

    Button boton3x3;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Title of Window");
        Label label1 = new Label("Tamaño de tablero");
        boton3x3 = new Button();
        boton3x3.setText("3x3");

        //This class will handle the button events
        boton3x3.setOnAction(this);

        VBox orden1 = new VBox(20);
        orden1.setLayoutX(100);
        orden1.setLayoutY(100);
        orden1.getChildren().addAll(label1, boton3x3);
        Scene scene = new Scene(orden1, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //When button is clicked, handle() gets called
    //Button click is an ActionEvent (also MouseEvents, TouchEvents, etc...)
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == boton3x3)
            System.out.println("Se crea tablero 3x3");
        else if (event.getSource() == boton3x3){

        }
    }

}
