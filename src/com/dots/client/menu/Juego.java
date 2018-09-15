package com.dots.client.menu;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Juego {

    double height = 350;
    double ejeX = 200;
    double ejeY = 50;
    @FXML
    private AnchorPane paneBoard;

    @FXML
    public void correrTablero () throws IOException {
        Main.setScene("tableroFXML.fxml");
    }

    @FXML
    public void empezar3x3() {

        double espacio = height / 3;
        int filas = 3;
        int columnas = 3;
        int contadorFila = 0;
        int contadorColumna = 0;
        metodoWhile(espacio, filas, columnas, contadorFila, contadorColumna);

    }

    @FXML
    public void empezar5x5() {

        double espacio = height / 5;
        int filas = 5;
        int columnas = 5;
        int contadorFila = 0;
        int contadorColumna = 0;
        metodoWhile(espacio, filas, columnas, contadorFila, contadorColumna);
    }

    @FXML
    public void empezar7x7() {

        double espacio = height / 7;
        int filas = 7;
        int columnas = 7;
        int contadorFila = 0;
        int contadorColumna = 0;
        metodoWhile(espacio, filas, columnas, contadorFila, contadorColumna);
    }

    @FXML
    public void metodoWhile(double espacio, int filas, int columnas, int contadorFila, int contadorColumna) {
        while (contadorFila < filas) {
            while (contadorColumna < columnas) {
                Boton boton = new Boton(ejeX, ejeY);
                paneBoard.getChildren().addAll(boton.getBoton());
                ejeX += espacio;
                contadorColumna++;
            }
            ejeY += espacio;
            ejeX = 200;
            contadorFila++;
            contadorColumna = 0;
        }
    }
}

