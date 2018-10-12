package com.dots.client.menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase para iniciar la interfaz.
 */

public class Main extends Application {

    static Stage juego;

    /**
     *
     * @param scene_route es un argumento que entra al momento de ser llamado por el controller Juego y así definir cuál ventana mostrar.
     * @throws IOException se usa para verifica cuando hay errores
     */

    static void setScene(String scene_route) throws IOException {

        Parent root = FXMLLoader.load(Main.class.getResource(scene_route));
        Scene escena = new Scene(root);
        double width = juego.getWidth();
        double height = juego.getHeight();
        boolean fullscreen = juego.isFullScreen();
        juego.setScene(escena);

    }

    /**
     * main es el método que ejecuta la clase una vez que se inicializa.
     * @param args argumentos que son necesarios para inicializar y correr la clase.
     */

    public static void main(String[] args) {
        launch(args);
    }

    @Override

    /**
     * El método start se utiliza para definir con qué ventana se iniciará la interfaz.
     */

    public void start(Stage primaryStage) throws Exception{
        System.out.println("Hola1");
        Main.juego=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("juegoFXML.fxml"));
        primaryStage.setTitle("¡¡ DOTS !!");
        primaryStage.setScene(new Scene(root, 720, 480));
        primaryStage.show();
    }
}
