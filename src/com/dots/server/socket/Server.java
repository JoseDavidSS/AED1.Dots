package com.dots.server.socket;

import com.dots.server.board.Jugadores;
import com.dots.server.board.Tablero;
import com.dots.server.lists.board.ListadeListasDeCuadros;
import com.dots.server.lists.dots.ListaVertices;
import com.dots.server.lists.figures.ListaFiguras;
import com.dots.server.lists.lines.ListaLineas;
import com.dots.server.lists.tail.ListaDeCola;
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
                System.out.println(tRecibida);
                Tablero t = mapper.fromJson(tRecibida, Tablero.class);
                if (t.getJugador().equals("Cola")){
                    cliente.close();
                    servidor.close();
                    if (t.getPuntaje() == 1 && !J.getJ1()){
                        ListaDeCola.getInstance().eliminar(1);
                        t.setPuntaje(0);
                        t.setJugador("");
                        this.enviarTablero(t);
                    }
                    else if (t.getPuntaje() == 2 && !J.getJ2() && J.getJ1()){
                        ListaDeCola.getInstance().eliminar(2);
                        t.setPuntaje(0);
                        t.setJugador("");
                        this.enviarTablero(t);
                    }
                    else{
                        if (!J.getJ1() || !J.getJ2()){
                            int a = t.getPuntaje();
                            if (ListaDeCola.getInstance().buscar(a)){
                                t.setPuntaje(0);
                                t.setJugador("");
                                this.enviarTablero(t);
                            }
                            else{
                                t.setJugador("Cola");
                                this.enviarTablero(t);
                            }
                        }
                        else{
                            t.setJugador("Cola");
                            this.enviarTablero(t);
                        }
                    }
                }
                else if (J.isFin1()){
                    cliente.close();
                    servidor.close();
                    if (t.getJugador().equals("J1")){
                        if (J.getPuntaje1() > J.getPuntaje2()){
                            t.setJugador("Gane");
                        }
                        if (J.getPuntaje1() < J.getPuntaje2()){
                            t.setJugador("Perdi");
                        }
                        if (J.getPuntaje1() == J.getPuntaje2()){
                            t.setJugador("Empate");
                        }
                        t.setPuntaje(J.getPuntaje1());
                    }
                    if (t.getJugador().equals("J2")){
                        if (J.getPuntaje1() < J.getPuntaje2()){
                            t.setJugador("Gane");
                        }
                        if (J.getPuntaje1() > J.getPuntaje2()){
                            t.setJugador("Perdi");
                        }
                        if (J.getPuntaje1() == J.getPuntaje2()){
                            t.setJugador("Empate");
                        }
                        t.setPuntaje(J.getPuntaje2());
                    }
                    t.setMiTurno(false);
                    t.setFin(true);
                    this.enviarTablero(t);
                    this.enviarListaLineas(ListaLineas.getInstance());
                    this.enviarListaFiguras(ListaFiguras.getInstance());
                    if (J.isFin2()){
                        Jugadores.reinicio();
                        ListadeListasDeCuadros.reinicio();
                        ListaFiguras.reinicio();
                        ListaLineas.reinicio();
                        System.out.println("Listo para un nuevo juego");
                    }
                    else{
                        J.setFin2(true);
                    }
                }
                else if (!J.getJ1()){
                    cliente.close();
                    servidor.close();
                    J.setM(t.getFilas_columnas());
                    t.setJugador("J1");
                    this.enviarTablero(t);
                    J.setJ1(true);
                }
                else if (!J.getJ2() && t.getJugador().equals("")){
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
                }
                else if (t.getJugador().equals("")){
                    cliente.close();
                    servidor.close();
                    ListaDeCola.getInstance().anadirElemento();
                    t.setPuntaje(ListaDeCola.getInstance().getLargo());
                    t.setJugador("Cola");
                    this.enviarTablero(t);
                    System.out.println("Se intentó conectar otro jugador, se insertó en la cola");
                }
                else{
                    cliente.close();
                    servidor.close();
                    if (t.getJugador().equals("J1")){
                        if (J.isT1()) {
                            t.setMiTurno(true);
                            t.setJugador("J1");
                            t.setPuntaje(J.getPuntaje1());
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
                            ListaLineas.getInstance().comprobarAdyacentes(t);
                            this.enviarListaFiguras(ListaFiguras.getInstance());
                            ListadeListasDeCuadros.getInstance().imprimirLista();
                            if (ListaLineas.getInstance().isUltLinea()){
                                if (ListadeListasDeCuadros.getInstance().verificar()){
                                    J.setT1(false);
                                    J.setT2(false);
                                    J.setFin1(true);
                                }
                                else{
                                    J.setT1(true);
                                    J.setT2(false);
                                }
                            }
                            else{
                                if (ListadeListasDeCuadros.getInstance().verificar()){
                                    J.setT1(false);
                                    J.setT2(false);
                                    J.setFin1(true);
                                }
                                else{
                                    J.setT1(false);
                                    J.setT2(true);
                                }
                            }
                        }
                        else{
                            t.setMiTurno(false);
                            t.setJugador("J1");
                            this.enviarTablero(t);
                            this.enviarListaLineas(ListaLineas.getInstance());
                            this.enviarListaFiguras(ListaFiguras.getInstance());
                        }
                    }
                    else{
                        if (J.isT2()){
                            t.setMiTurno(true);
                            t.setJugador("J2");
                            t.setPuntaje(J.getPuntaje2());
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
                            ListaLineas.getInstance().comprobarAdyacentes(t);
                            this.enviarListaFiguras(ListaFiguras.getInstance());
                            ListadeListasDeCuadros.getInstance().imprimirLista();
                            if (ListaLineas.getInstance().isUltLinea()){
                                if (ListadeListasDeCuadros.getInstance().verificar()){
                                    J.setT1(false);
                                    J.setT2(false);
                                    J.setFin1(true);
                                }
                                else{
                                    J.setT1(false);
                                    J.setT2(true);
                                }
                            }
                            else{
                                if (ListadeListasDeCuadros.getInstance().verificar()){
                                    J.setT1(false);
                                    J.setT2(false);
                                    J.setFin1(true);
                                }
                                else{
                                    J.setT1(true);
                                    J.setT2(false);
                                }
                            }
                        }
                        else{
                            t.setMiTurno(false);
                            t.setJugador("J2");
                            this.enviarTablero(t);
                            this.enviarListaLineas(ListaLineas.getInstance());
                            this.enviarListaFiguras(ListaFiguras.getInstance());
                        }
                    }
                }
            }catch (IOException a){
                System.out.println("Error recibiendo datos desde el servidor");
            }
        }
    }
}

