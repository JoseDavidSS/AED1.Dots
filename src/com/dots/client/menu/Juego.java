package com.dots.client.menu;

import com.dots.client.board.Tablero;
import com.dots.client.lists.dots.ListaVertices;
import com.dots.client.lists.dots.NodoVertices;
import com.dots.client.lists.figures.ListaFiguras;
import com.dots.client.lists.figures.NodoFiguras;
import com.dots.client.lists.lines.ListaLineas;
import com.dots.client.lists.lines.NodoLineas;
import com.dots.client.socket.Cliente;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

/**
 * Clase principal del cliente.
 */

public class Juego {

    int height = 350;
    int ejeX = 250;
    int ejeY = 50;
    public static int columnas_filas;
    public static boolean turno = false;
    public static String jugador = "";
    public TextField IP;
    public TextField Puerto;
    public AnchorPane paneBoard;
    public Button Comenzar;
    public static Juego juego = new Juego();
    public static Tablero tablero;

    @FXML

    /**
     * Método que cambia la escena gracias a una instancia que llama del Main.
     */
    public void correrTablero () throws IOException {
        Main.setScene("tableroFXML.fxml");
    }

    @FXML

    /**
     * Método que manda al server la plantilla elegida notificando la verificación del jugador corresponde recibida del server.
     */

    public void empezar3x3() {
        Tablero t = Tablero.getInstance();
        if (t.getFilas_columnas() == 3 || t.getFilas_columnas() == 5 || t.getFilas_columnas() == 7) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText("Error");
            alert.setContentText("ya se encuentra jugando");
            alert.showAndWait();
        } else {
            Cliente c = new Cliente();
            t.setFilas_columnas(3);
            boolean a = c.enviarTablero(t);
            if (a){
                t = c.solicitarTablero();
                Tablero.setInstance(t);
                tablero = t;
            }
            if (t.getJugador().equals("J1") || (t.getJugador().equals("J2") && t.getFilas_columnas() == 3)){
                if (t.getJugador().equals("J2")){
                    t.setMiTurno(true);
                }
                this.empezar3x3_2();
            }
            else if (t.getJugador().equals("")){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Aviso");
                alert.setHeaderText("Se produjo un error conectando con el servidor");
                alert.setContentText("intente de nuevo.");
                alert.showAndWait();
                Tablero.getInstance().setFilas_columnas(0);
                tablero = Tablero.getInstance();
            }
            else if (t.getJugador().equals("Cola")){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Aviso");
                alert.setHeaderText("En Cola");
                alert.setContentText("soy el" + Integer.toString(t.getPuntaje()));
                alert.showAndWait();
                Tablero.getInstance().setFilas_columnas(0);
                tablero = Tablero.getInstance();
            }
            else {
                t.setMiTurno(true);
                Tablero.setInstance(t);
                if (t.getFilas_columnas() == 5) {
                    this.empezar5x5_2();
                }else {
                    this.empezar7x7_2();
                }
            }
        }
    }

    /**
     * Método que determina las características que tendrá el tablero 3x3.
     */

    public void empezar3x3_2(){
        columnas_filas = 3;
        int espacio = height / 3;
        int filas = 3;
        int columnas = 3;
        int contadorFila = 0;
        int contadorColumna = 0;
        this.metodoWhile(espacio, filas, columnas, contadorFila, contadorColumna);
    }

    @FXML

    /**
     * Método que manda al server la plantilla elegida notificando la verificación del jugador corresponde recibida del server.
     */

    public void empezar5x5(){
        Tablero t = Tablero.getInstance();
        if (t.getFilas_columnas() == 3 || t.getFilas_columnas() == 5 || t.getFilas_columnas() == 7){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText("Error");
            alert.setContentText("ya se encuentra jugando");
            alert.showAndWait();
        }
        else {
            Cliente c = new Cliente();
            t.setFilas_columnas(5);
            boolean a = c.enviarTablero(t);
            if (a){
                t = c.solicitarTablero();
                Tablero.setInstance(t);
                tablero = t;
            }
            if (t.getJugador().equals("J1") || (t.getJugador().equals("J2") && t.getFilas_columnas() == 5)){
                if (t.getJugador().equals("J2")){
                    t.setMiTurno(true);
                }
                this.empezar5x5_2();
            }
            else if (t.getJugador().equals("")){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Aviso");
                alert.setHeaderText("Se produjo un error conectando con el servidor");
                alert.setContentText("intente de nuevo.");
                alert.showAndWait();
                Tablero.getInstance().setFilas_columnas(0);
                tablero = Tablero.getInstance();
            }
            else if (t.getJugador().equals("Cola")){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Aviso");
                alert.setHeaderText("En Cola");
                alert.setContentText("soy el" + Integer.toString(t.getPuntaje()));
                alert.showAndWait();
                Tablero.getInstance().setFilas_columnas(0);
                tablero = Tablero.getInstance();
            }
            else {
                t.setMiTurno(true);
                Tablero.setInstance(t);
                if (t.getFilas_columnas() == 3) {
                    this.empezar3x3_2();
                }else {
                    this.empezar7x7_2();
                }
            }
        }
    }

    /**
     * Método que determina las características que tendrá el tablero 5x5.
     */

    public void empezar5x5_2(){
        columnas_filas = 5;
        int espacio = height / 5;
        int filas = 5;
        int columnas = 5;
        int contadorFila = 0;
        int contadorColumna = 0;
        this.metodoWhile(espacio, filas, columnas, contadorFila, contadorColumna);
    }

    @FXML

    /**
     * Método que manda al server la plantilla elegida notificando la verificación del jugador corresponde recibida del server.
     */

    public void empezar7x7() {
        Tablero t = Tablero.getInstance();
        if (t.getFilas_columnas() == 3 || t.getFilas_columnas() == 5 || t.getFilas_columnas() == 7){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText("Error");
            alert.setContentText("ya se encuentra jugando");
            alert.showAndWait();
        }
        else {
            Cliente c = new Cliente();
            t.setFilas_columnas(7);
            boolean a = c.enviarTablero(t);
            if (a){
                t = c.solicitarTablero();
                Tablero.setInstance(t);
                tablero = t;
            }
            if (t.getJugador().equals("J1") || (t.getJugador().equals("J2") && t.getFilas_columnas() == 7)){
                if (t.getJugador().equals("J2")){
                    t.setMiTurno(true);
                }
                this.empezar7x7_2();
            }
            else if (t.getJugador().equals("")){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Aviso");
                alert.setHeaderText("Se produjo un error conectando con el servidor");
                alert.setContentText("intente de nuevo.");
                alert.showAndWait();
                Tablero.getInstance().setFilas_columnas(0);
                tablero = Tablero.getInstance();
            }
            else if (t.getJugador().equals("Cola")){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Aviso");
                alert.setHeaderText("En Cola");
                alert.setContentText("soy el" + Integer.toString(t.getPuntaje()));
                alert.showAndWait();
                Tablero.getInstance().setFilas_columnas(0);
                tablero = Tablero.getInstance();
            }
            else{
                t.setMiTurno(true);
                Tablero.setInstance(t);
                if (t.getFilas_columnas() == 5) {
                    this.empezar5x5_2();
                }else {
                    this.empezar3x3_2();
                }
            }
        }
    }

    /**
     * Método que determina las características que tendrá el tablero 7x7.
     */

    public void empezar7x7_2(){
        columnas_filas = 7;
        int espacio = height / 7;
        int filas = 7;
        int columnas = 7;
        int contadorFila = 0;
        int contadorColumna = 0;
        this.metodoWhile(espacio, filas, columnas, contadorFila, contadorColumna);
    }

    @FXML

    /**
     * Método iterativa que asigna las posiciones de cada botón al momento de instanciarlos.
     */

    public void metodoWhile(int espacio, int filas, int columnas, int contadorFila, int contadorColumna) {
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
        Turno t = new Turno();
        t.start();
    }

    /**
     * Método recibe el texto de los TextField y activa el botón de inicio para jugar.
     * @param event este parametro es el accionar del botón en el tab Sockets.
     */

    public void recibirTexto (ActionEvent event){
        if (IP.getText() == null || IP.getText().trim().isEmpty() || Puerto.getText() == null || Puerto.getText().trim().isEmpty()){
            System.out.println("Ingrese valores correctos");
        }else{
            System.out.println(IP.getText()+" , "+ Puerto.getText());
        }
    }

    /**
     * Método que se ejecuta una vez se manda la información de cliente a cliente para dibujar las líneas hechas.
     */
    public void dibujarLineas () {
        ListaLineas l1 = ListaLineas.getInstance();
        if (l1.getLargo() != 0){
            NodoLineas tmp = l1.head;
            while (tmp != null) {
                int InicioEjeX = tmp.getPosxi();
                int InicioEjeY = tmp.getPosyi();
                int FinalEjeX = tmp.getPosxf();
                int FinalEjeY = tmp.getPosyf();
                Line linea = new Line(InicioEjeX + 5, InicioEjeY + 5, FinalEjeX + 5, FinalEjeY + 5);
                paneBoard.getChildren().addAll(linea);
                tmp = tmp.next;
            }
        }else{
            System.out.println("Lista vacia");
        }
    }

    /**
     * Método que se ejecuta al presionar un segundo botón del tablero para dibujar una línea.
     */
    public void dibujarLinea () {
        ListaVertices l1 = ListaVertices.getInstance();
        NodoVertices tmp = l1.head;
        NodoVertices tmp2 = tmp.next;
        Line linea = new Line(tmp.getPosx() + 5, tmp.getPosy() + 5, tmp2.getPosx() + 5, tmp2.getPosy() + 5);
        paneBoard.getChildren().addAll(linea);
    }

    /**
     * Método que se ejecuta una vez se manda la información de cliente a cliente para dibujar las figuras ya hechas.
     */
    public void dibujarFiguras () {
        ListaFiguras lF = ListaFiguras.getInstance();
        lF.imprimirLista();
        if (lF.getLargo() != 0){
            System.out.println(lF.getLargo());
            NodoFiguras tmp = lF.head;
            while (tmp != null){
                if (tmp.getV4x() == 0 && tmp.getV4y() == 0){
                    double x1 = tmp.getV1x();
                    double y1 = tmp.getV1y();
                    double x2 = tmp.getV2x();
                    double y2 = tmp.getV2y();
                    double x3 = tmp.getV3x();
                    double y3 = tmp.getV3y();
                    Polygon triangulo = new Polygon(x1+5, y1+5, x2+5, y2+5, x3+5, y3+5);
                    paneBoard.getChildren().addAll(triangulo);
                    tmp = tmp.next;
                }
                else{
                    int ancho = (tmp.getV2x() - tmp.getV1x());
                    Rectangle rect = new Rectangle(tmp.getV1x()+5, tmp.getV1y()+5, ancho, ancho);
                    paneBoard.getChildren().addAll(rect);
                    tmp = tmp.next;
                }
            }
        }else{
            System.out.println("Lista vacia");
        }
    }

    public void dibujar(){
        this.dibujarLineas();
        this.dibujarFiguras();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText("MI TURNO");
        alert.setContentText("Dibuja una linea");
        alert.showAndWait();
    }

    public void dibujarNT(){
        this.dibujarLineas();
        this.dibujarFiguras();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText("El otro jugador");
        alert.setContentText("no ha terminado su turno.");
        alert.showAndWait();
    }


    public void finJuego() {
        this.dibujarLineas();
        this.dibujarFiguras();
        System.out.println(tablero.getJugador() + " con: " + tablero.getPuntaje());
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText(tablero.getJugador());
        alert.setContentText("Con: " + Integer.toString(tablero.getPuntaje()));
        alert.showAndWait();
        System.out.println("FIN");
        try{
            turno = false;
            jugador = "";
            Tablero.reinicio();
            tablero = Tablero.getInstance();
            this.correrTablero();
        }catch (IOException e){
            System.out.println("Hubo un error :(");
            Platform.exit();
        }
    }
}

