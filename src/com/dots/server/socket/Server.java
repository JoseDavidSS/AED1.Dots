package com.dots.server.socket;

import com.dots.server.board.Jugadores;
import com.dots.server.board.Tablero;
import com.dots.server.lists.board.ListadeListasDeCuadros;
import com.dots.server.lists.dots.ListaVertices;
import com.dots.server.lists.figures.ListaFiguras;
import com.dots.server.lists.lines.ListaLineas;
import com.gilecode.yagson.YaGson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase que se encarga de manejar la lógica del juego.
 */

public class Server extends Thread{

    public static void main(String[] args) {
        Server servidor = new Server();
        servidor.start();
    }

    /**
     * Método que envia la informacion(Tablero) al jugador que esté activo.
     * @param t tablero (Estado del juego).
     */

    public void enviarTablero(Tablero t) {
        while (true) {
            try {
                YaGson mapper = new YaGson();
                ServerSocket servidor = new ServerSocket(10000);
                Socket cliente = servidor.accept();
                PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
                String tSerializada = mapper.toJson(t, Tablero.class);
                salida.println(tSerializada);
                cliente.close();
                servidor.close();
                break;
            } catch (IOException a) {
                System.out.println("Error enviando datos desde el servidor");
            }
        }
    }

    /**
     * Método que envia la lista de vertices al jugador que esté activo.
     * @param lista lista de vertices a enviar.
     */

    public void enviarListaVertices(ListaVertices lista) {
        while (true) {
            try {
                YaGson mapper = new YaGson();
                ServerSocket servidor = new ServerSocket(10000);
                Socket cliente = servidor.accept();
                PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
                String listaSerializada = mapper.toJson(lista, ListaVertices.class);
                salida.println(listaSerializada);
                cliente.close();
                servidor.close();
                break;
            } catch (IOException a) {
                System.out.println("Error enviando datos desde el servidor");
            }
        }
    }

    /**
     * Método que envia la lista de figuras al jugador que esté activo.
     * @param lista lista de figuras a enviar.
     */

    public void enviarListaFiguras(ListaFiguras lista) {
        while (true) {
            try {
                YaGson mapper = new YaGson();
                ServerSocket servidor = new ServerSocket(10000);
                Socket cliente = servidor.accept();
                PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
                String listaSerializada = mapper.toJson(lista, ListaFiguras.class);
                salida.println(listaSerializada);
                cliente.close();
                servidor.close();
                break;
            } catch (IOException a) {
                System.out.println("Error enviando datos desde el servidor");
            }
        }
    }

    /**
     * Método que envia la lista de lineas al jugador que esté activo.
     * @param lista lista de lineas a enviar.
     */

    public void enviarListaLineas(ListaLineas lista){
        while (true) {
            try {
                YaGson mapper = new YaGson();
                ServerSocket servidor = new ServerSocket(10000);
                Socket cliente = servidor.accept();
                PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
                System.out.println(lista.getLargo());
                String listaSerializada = mapper.toJson(lista, ListaLineas.class);
                salida.println(listaSerializada);
                cliente.close();
                servidor.close();
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void solicitarListaVertices(){
        while (true){
            try {
                YaGson mapper = new YaGson();
                ServerSocket servidor = new ServerSocket(10002);
                Socket cliente = servidor.accept();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                String lVertices = entrada.readLine();
                ListaVertices l = mapper.fromJson(lVertices, ListaVertices.class);
                ListaVertices.setInstance(l);
                cliente.close();
                servidor.close();
                break;
            }catch (IOException a){
                System.out.println("Error");
            }
        }
    }
    /**
     * Método del servidor que abre un hilo que tiene como función recibir la información enviada por el cliente despues
     * de cada turno. Guarda en la cola a cada jugador activo.
     */

    @Override
    public void run(){
        while (true){
            try{
                YaGson mapper = new YaGson();
                ServerSocket servidor = new ServerSocket(10001);
                Socket cliente = servidor.accept();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                Jugadores J = Jugadores.getInstance();
                String tRecibida = entrada.readLine();
                Tablero t = mapper.fromJson(tRecibida, Tablero.class);
                if (!J.getJ1()){
                    cliente.close();
                    servidor.close();
                    J.setM(t.getFilas_columnas());
                    t.setJugador("J1");
                    this.enviarTablero(t);
                    J.setJ1(true);
                }else if (!J.getJ2() && t.getJugador().equals("")){
                    cliente.close();
                    servidor.close();
                    t.setJugador("J2");
                    t.setFilas_columnas(J.getM());
                    this.enviarTablero(t);
                    J.setJ2(true);
                    this.enviarListaLineas(ListaLineas.getInstance());
                    this.enviarListaFiguras(ListaFiguras.getInstance());
                    ListadeListasDeCuadros L1 =  ListadeListasDeCuadros.getInstance();
                    L1.anadirElemento(J.getM());
                    this.solicitarListaVertices();
                    ListaVertices l = ListaVertices.getInstance();
                    while (!l.isValido()){
                        l = ListaVertices.getInstance();
                        l.ordenar2();
                        this.enviarListaVertices(l);
                        if (!l.isValido()){
                            this.solicitarListaVertices();
                        }
                        else{
                            break;
                        }
                    }
                    this.enviarListaFiguras(ListaFiguras.getInstance());
                    J.setT2(false);
                    J.setT1(true);
                }else if (t.getJugador().equals("")){
                    cliente.close();
                    servidor.close();
                    this.enviarTablero(t);
                    System.out.println("Se intentó conectar otro jugador, debe esperar");
                }else{
                    cliente.close();
                    servidor.close();
                    if (t.getJugador().equals("J1")){
                        if (J.isT1()) {
                            System.out.println("Hola1");
                            t.setMiTurno(true);
                            t.setJugador("J1");
                            this.enviarTablero(t);
                            this.enviarListaLineas(ListaLineas.getInstance());
                            this.enviarListaFiguras(ListaFiguras.getInstance());
                            this.solicitarListaVertices();
                            ListaVertices l = ListaVertices.getInstance();
                            while (!l.isValido()){
                                l = ListaVertices.getInstance();
                                l.ordenar2();
                                this.enviarListaVertices(l);
                                if (!l.isValido()){
                                    this.solicitarListaVertices();
                                }
                                else{
                                    break;
                                }
                            }
                            this.enviarListaFiguras(ListaFiguras.getInstance());
                            J.setT1(false);
                            J.setT2(true);
                        }else{
                            System.out.println("Hola2");
                            t.setMiTurno(false);
                            t.setJugador("J1");
                            this.enviarTablero(t);
                        }
                    }else{
                        if (J.isT2()){
                            System.out.println("Hola3");
                            t.setMiTurno(true);
                            t.setJugador("J2");
                            this.enviarTablero(t);
                            System.out.println("Wey");
                            this.enviarListaLineas(ListaLineas.getInstance());
                            System.out.println("Weye");
                            this.enviarListaFiguras(ListaFiguras.getInstance());
                            System.out.println("Weys");
                            this.solicitarListaVertices();
                            ListaVertices l = ListaVertices.getInstance();
                            while (!l.isValido()){
                                l = ListaVertices.getInstance();
                                l.ordenar2();
                                this.enviarListaVertices(l);
                                if (!l.isValido()){
                                    this.solicitarListaVertices();
                                }
                                else{
                                    break;
                                }
                            }
                            this.enviarListaFiguras(ListaFiguras.getInstance());
                            J.setT2(false);
                            J.setT1(true);
                        }else{
                            System.out.println("Hola4");
                            t.setMiTurno(false);
                            t.setJugador("J2");
                            this.enviarTablero(t);
                        }
                    }
                }
            }catch (IOException a){
                System.out.println("Error recibiendo datos desde el servidor");
            }
        }
    }
}

