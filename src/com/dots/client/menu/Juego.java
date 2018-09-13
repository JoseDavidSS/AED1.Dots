package com.dots.client.menu;

import javafx.fxml.FXML;

import java.io.IOException;

public class Juego {
    @FXML
    public void imprimir(){
        System.out.println("hola");
    }

    public void correrTablero () throws IOException {
        Main.setScene("tableroFXML.fxml");
    }
}

