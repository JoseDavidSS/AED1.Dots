package com.dots.client.menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    static Stage juego;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.juego=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("juegoFXML.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 720, 480));
        primaryStage.show();
    }

    static void setScene(String scene_route) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource(scene_route));
        Scene escena = new Scene(root);
        /**double width = juego.getWidth();
        double height = juego.getHeight();
        boolean fullscreen = juego.isFullScreen();**/
        juego.setScene(escena);
/**
        if (fullscreen) juego.setFullScreen(true);
        else{
            juego.setWidth(width);
            juego.setHeight(height);
        }
 */
    }



    public static void main(String[] args) {
        launch(args);
    }
}
