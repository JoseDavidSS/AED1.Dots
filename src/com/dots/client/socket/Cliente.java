package com.dots.client.socket;

import com.dots.client.board.Tablero;
import com.dots.client.lists.dots.ListaVertices;
import com.dots.client.lists.figures.ListaFiguras;
import com.dots.client.lists.lines.ListaLineas;
import com.gilecode.yagson.YaGson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Clase para conectarse con el server, manda y recibe JSONs.
 */

public class Cliente extends Thread{

    /**
     * Constructor de la clase.
     */

    public Cliente(){
    }

    /**
     * Método que solicita el estado del juego al servidor(Tablero).
     * @return el tablero recibido por el server.
     */

    public Tablero solicitarTablero(){
        try{
            YaGson mapper = new YaGson();
            Socket conexionServer = new Socket("127.0.0.1",10000);
            BufferedReader entradaDatos = new BufferedReader(new InputStreamReader(conexionServer.getInputStream()));
            String tserial = entradaDatos.readLine();
            System.out.println(tserial);
            Tablero tablero = mapper.fromJson(tserial, Tablero.class);
            conexionServer.close();
            return tablero;
        } catch (IOException a){
            System.out.println("Error recibiendo datos");
        }
        return null;
    }

    /**
     *  Método que después de terminado el turno, el jugador envia al servidor el tablero modificado.
     *  @param tablero Tablero modificado.
     */

    public void enviarTablero(Tablero tablero) {
        try {
            YaGson mapper = new YaGson();
            Socket conexionServer = new Socket("127.0.0.1", 10001);
            PrintWriter salida = new PrintWriter(conexionServer.getOutputStream(), true);
            String tableroSerial = mapper.toJson(tablero, Tablero.class);
            System.out.println(tableroSerial);
            salida.println(tableroSerial);
            conexionServer.close();
        } catch (IOException a) {
            System.out.println("Error enviando datos");
        }
    }

    /**
     * Método que solicita la lista de lineas al servidor.
     * @return la lista de lineas modificada.
     */

    public ListaLineas solicitarListaLineas(){
        try{
            YaGson mapper = new YaGson();
            Socket conexionServer = new Socket("127.0.0.1",10000);
            BufferedReader entradaDatos = new BufferedReader(new InputStreamReader(conexionServer.getInputStream()));
            String lserial = entradaDatos.readLine();
            System.out.println(lserial);
            ListaLineas lista = mapper.fromJson(lserial, ListaLineas.class);
            conexionServer.close();
            return lista;
        } catch (IOException a){
            System.out.println("Error recibiendo datos 1");
        }
        return null;
    }

    /**
     * Método que envía la lista de lineas al servidor.
     * @param lista lista de lineas a enviar.
     */

    public void enviarListaLineas(ListaLineas lista) {
        try {
            YaGson mapper = new YaGson();
            Socket conexionServer = new Socket("127.0.0.1", 10001);
            PrintWriter salida = new PrintWriter(conexionServer.getOutputStream(), true);
            String listaSerial = mapper.toJson(lista, ListaLineas.class);
            System.out.println(listaSerial);
            salida.println(listaSerial);
            conexionServer.close();
        } catch (IOException a) {
            System.out.println("Error enviando datos");
        }
    }

    /**
     * Método que solicita la lista de vertices al servidor.
     * @return la lista de vertices modificada.
     */

    public ListaVertices solicitarListaVertices(){
        try{
            YaGson mapper = new YaGson();
            Socket conexionServer = new Socket("127.0.0.1",10000);
            BufferedReader entradaDatos = new BufferedReader(new InputStreamReader(conexionServer.getInputStream()));
            String lserial = entradaDatos.readLine();
            System.out.println(lserial);
            ListaVertices lista = mapper.fromJson(lserial, ListaVertices.class);
            conexionServer.close();
            return lista;
        } catch (IOException a){
            System.out.println("Error recibiendo datos");
        }
        return null;
    }

    /**
     * Método que envía la lista de vertices al servidor.
     * @param lista lista de vertices a enviar.
     */

    public void enviarListaVertices(ListaVertices lista) {
        try {
            YaGson mapper = new YaGson();
            Socket conexionServer = new Socket("127.0.0.1", 10002);
            PrintWriter salida = new PrintWriter(conexionServer.getOutputStream(), true);
            String listaSerial = mapper.toJson(lista, ListaVertices.class);
            System.out.println(listaSerial);
            salida.println(listaSerial);
            conexionServer.close();
        } catch (IOException a) {
            System.out.println("Error enviando datos");
        }
    }

    /**
     * Método que solicita la lista de figuras al servidor.
     * @return lista de figuras modificada.
     */

    public ListaFiguras solicitarListaFiguras(){
        try{
            YaGson mapper = new YaGson();
            Socket conexionServer = new Socket("127.0.0.1",10000);
            BufferedReader entradaDatos = new BufferedReader(new InputStreamReader(conexionServer.getInputStream()));
            String lserial = entradaDatos.readLine();
            System.out.println(lserial);
            ListaFiguras lista = mapper.fromJson(lserial, ListaFiguras.class);
            conexionServer.close();
            return lista;
        } catch (IOException a){
            System.out.println("Error recibiendo datos");
        }
        return null;
    }

    /**
     * Método que envía la lista de vertices al servidor.
     * @param lista lista de vertices a enviar.
     */

    public void enviarListaFiguras(ListaFiguras lista) {
        try {
            YaGson mapper = new YaGson();
            Socket conexionServer = new Socket("127.0.0.1", 10001);
            PrintWriter salida = new PrintWriter(conexionServer.getOutputStream(), true);
            String listaSerial = mapper.toJson(lista);
            System.out.println(listaSerial);
            salida.println(listaSerial);
            conexionServer.close();
        } catch (IOException a) {
            System.out.println("Error enviando datos");
        }
    }

}

