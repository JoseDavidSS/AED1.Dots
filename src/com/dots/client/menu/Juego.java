package com.dots.client.menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Juego {

    double height = 350;
    double ejeX = 200;
    double ejeY = 50;
    public TextField IP;
    public TextField Puerto;
    public AnchorPane paneBoard;
    public Button Comenzar;


    @FXML
    /**
     * correrTablero es una función que cambia la escena gracias a una instancia que llama del Main.
     */
    public void correrTablero () throws IOException {
        Main.setScene("tableroFXML.fxml");
    }

    @FXML
    /**
     * empezar3x3 es una función que determina las características que tendrá el tablero 3x3.
     */
    public void empezar3x3() {

        double espacio = height / 3;
        int filas = 3;
        int columnas = 3;
        int contadorFila = 0;
        int contadorColumna = 0;
        metodoWhile(espacio, filas, columnas, contadorFila, contadorColumna);

    }

    @FXML
    /**
     * empezar5x5 es una función que determina las características que tendrá el tablero 5x5.
     */
    public void empezar5x5() {

        double espacio = height / 5;
        int filas = 5;
        int columnas = 5;
        int contadorFila = 0;
        int contadorColumna = 0;
        metodoWhile(espacio, filas, columnas, contadorFila, contadorColumna);
    }

    @FXML
    /**
     * empezar7x7 es una función que determina las características que tendrá el tablero 7x7.
     */
    public void empezar7x7() {

        double espacio = height / 7;
        int filas = 7;
        int columnas = 7;
        int contadorFila = 0;
        int contadorColumna = 0;
        metodoWhile(espacio, filas, columnas, contadorFila, contadorColumna);
    }

    @FXML
    /**
     * metodoWhile es una función iterativa que asigna las posiciones de cada botón al momento de instanciarlos.
     */
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

    /**
     * la función recibir texto recibe el texto de los TextField y activa el botón de inicio para jugar.
     * @param event este parametro es el accionar del botón en el tab Sockets
     */
    public void recibirTexto (ActionEvent event){
        Comenzar.setDisable(false);
        System.out.println(IP.getText()+" , "+ Puerto.getText());
    }
}

