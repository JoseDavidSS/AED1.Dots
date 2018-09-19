package com.dots.client.menu;

import com.dots.client.board.Tablero;
import com.dots.client.lists.figures.ListaFiguras;
import com.dots.client.lists.figures.NodoFiguras;
import com.dots.client.lists.lines.ListaLineas;
import com.dots.client.lists.lines.NodoLineas;
import com.dots.client.socket.Cliente;
import com.dots.server.lists.board.ListadeListasDeCuadros;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.io.IOException;

public class Juego {

    int height = 350;
    int ejeX = 250;
    int ejeY = 50;
    public TextField IP;
    public TextField Puerto;
    public AnchorPane paneBoard;
    public Button Comenzar;
    public static Juego juego = new Juego();

    public AnchorPane getPaneBoard() {
        return paneBoard;
    }

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
        Cliente c1 = new Cliente();
        Tablero t = new Tablero();
        t.setFilas_columnas(3);
        //c1.enviarNum(t);

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
        Cliente c1 = new Cliente();
        Tablero t = new Tablero();
        t.setFilas_columnas(5);
        //c1.enviarNum(t);

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
        Cliente c1 = new Cliente();
        Tablero t = new Tablero();
        t.setFilas_columnas(7);
        //c1.enviarNum(t);

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
        ListadeListasDeCuadros l = new ListadeListasDeCuadros();
        while (contadorFila < filas) {
            while (contadorColumna < columnas) {
                Juego.juego.paneBoard = paneBoard;
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

    public void dibujarLineas () {
        ListaLineas l1 = ListaLineas.getInstance();
        NodoLineas tmp = l1.head;
        while (tmp != null) {
            int InicioEjeX = tmp.getPosxi();
            int InicioEjeY = tmp.getPosyi();
            int FinalEjeX = tmp.getPosxf();
            int FinalEjeY = tmp.getPosyf();
            Line linea = new Line(InicioEjeX, InicioEjeY, FinalEjeX, FinalEjeY);
            paneBoard.getChildren().addAll(linea);
            tmp = tmp.next;
        }
    }

    public void dibujarCuadros () {
        ListaFiguras l1 = ListaFiguras.getInstance();
        NodoFiguras tmp = l1.head;
        while (tmp != null) {
            int EjeX = tmp.getV1x();
            int EjeY = tmp.getV1y();
            int ancho = (tmp.getV2x() - EjeX);
            System.out.println(ancho);
            Rectangle rect = new Rectangle(EjeX, EjeY, 200, 200);
            paneBoard.getChildren().addAll(rect);
            tmp = tmp.next;
        }
    }
}

