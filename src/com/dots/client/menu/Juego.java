package com.dots.client.menu;

import com.dots.server.lists.board.ListadeListasDeCuadros;
import com.dots.client.socket.Cliente;
import com.dots.client.board.Tablero;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.IOException;

public class Juego {

    double height = 350;
    int ejeX = 250;
    int ejeY = 50;
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
        Tablero t = Tablero.getInstance();
        if (t.getFilas_columnas() == 3 || t.getFilas_columnas() == 5 || t.getFilas_columnas() == 7) {
            System.out.println("No");
        } else {
            Cliente c = new Cliente();
            t.setFilas_columnas(3);
            c.enviarTablero(t);
            t = c.solicitarTablero();
            Tablero.setInstance(t);
            if (t.getJugador().equals("J1")){
                this.empezar3x3_2();
            } else {
                if (t.getFilas_columnas() == 5) {
                    this.empezar5x5_2();
                }else {
                    this.empezar7x7_2();
                }
            }
        }
    }

    public void empezar3x3_2(){
        double espacio = height / 3;
        int filas = 3;
        int columnas = 3;
        int contadorFila = 0;
        int contadorColumna = 0;
        this.metodoWhile(espacio, filas, columnas, contadorFila, contadorColumna);
    }

    @FXML
    /**
     * empezar5x5 es una función que determina las características que tendrá el tablero 5x5.
     */
    public void empezar5x5(){
        Tablero t = Tablero.getInstance();
        if (t.getFilas_columnas() == 3 || t.getFilas_columnas() == 5 || t.getFilas_columnas() == 7){
            System.out.println("No");
        }
        else {
            Cliente c = new Cliente();
            t.setFilas_columnas(5);
            c.enviarTablero(t);
            t = c.solicitarTablero();
            Tablero.setInstance(t);
            if (t.getJugador().equals("J1")){
                this.empezar5x5_2();
            } else {
                if (t.getFilas_columnas() == 3) {
                    this.empezar3x3_2();
                }else {
                    this.empezar7x7_2();
                }
            }
        }
    }

    public void empezar5x5_2(){
        double espacio = height / 5;
        int filas = 5;
        int columnas = 5;
        int contadorFila = 0;
        int contadorColumna = 0;
        this.metodoWhile(espacio, filas, columnas, contadorFila, contadorColumna);
    }

    @FXML
    /**
     * empezar7x7 es una función que determina las características que tendrá el tablero 7x7.
     */
    public void empezar7x7() {
        Tablero t = Tablero.getInstance();
        if (t.getFilas_columnas() == 3 || t.getFilas_columnas() == 5 || t.getFilas_columnas() == 7){
            System.out.println("No");
        }
        else {
            Cliente c = new Cliente();
            t.setFilas_columnas(7);
            c.enviarTablero(t);
            t = c.solicitarTablero();
            Tablero.setInstance(t);
            if (t.getJugador().equals("J1")){
                this.empezar7x7_2();
            } else {
                if (t.getFilas_columnas() == 5) {
                    this.empezar5x5_2();
                }else {
                    this.empezar3x3_2();
                }
            }
        }
    }

    public void empezar7x7_2(){
        double espacio = height / 7;
        int filas = 7;
        int columnas = 7;
        int contadorFila = 0;
        int contadorColumna = 0;
        this.metodoWhile(espacio, filas, columnas, contadorFila, contadorColumna);
    }

    @FXML
    /**
     * metodoWhile es una función iterativa que asigna las posiciones de cada botón al momento de instanciarlos.
     */
    public void metodoWhile(double espacio, int filas, int columnas, int contadorFila, int contadorColumna) {
        ListadeListasDeCuadros l = new ListadeListasDeCuadros();
        while (contadorFila < filas) {
            while (contadorColumna < columnas) {
                Boton boton = new Boton(ejeX, ejeY);
                paneBoard.getChildren().addAll(boton.getBoton());
                ejeX += espacio;
                contadorColumna++;
            }
            ejeY += espacio;
            ejeX = 250;
            contadorFila++;
            contadorColumna = 0;
        }
    }

    /**
     * la función recibir texto recibe el texto de los TextField y activa el botón de inicio para jugar.
     * @param event este parametro es el accionar del botón en el tab Sockets
     */
    public void recibirTexto (ActionEvent event){
        if (IP.getText() == null || IP.getText().trim().isEmpty() || Puerto.getText() == null || Puerto.getText().trim().isEmpty()){
            System.out.println("Ingrese valores correctos");
        }else{
            System.out.println(IP.getText()+" , "+ Puerto.getText());
        }
    }
}

