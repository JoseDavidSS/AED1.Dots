package com.dots.client.menu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Tablero {
    double height = 350;
    double width = 350;
    private AnchorPane paneBoard;
    @FXML
    public void imprimir(){
        System.out.println("hola");
    }

    public void correrTablero3x3 () throws IOException {
        Main.setScene("tableroFXML");

        double espacio = height / 5;

        int filas = 5;
        int columnas = 5;
        int contadorFila = 0;
        int contadorColumna = 0;

        while (contadorFila <= filas){
            while (contadorColumna <= columnas){
                Button boton = new Button();



            }
        }

    }
    public void correrTablero5x5 () throws IOException {
        Main.setScene("tableroFXML");
    }
    public void correrTablero7x7 () throws IOException {
        Main.setScene("tableroFXML");

    }
}

