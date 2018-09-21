package com.dots.server.socket;

import com.dots.server.board.Jugadores;
import com.dots.server.board.Tablero;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server extends Thread{

    public static void main(String[] args) {
        Server servidor = new Server();
        servidor.start();
    }

    /**
     * El servidor envia la informacion(Tablero) a cada jugador que esté activo
     * @param t tablero (Estado del juego)
     */

    public void iniciarT(Tablero t) {
        while (true) {
            try {
                ServerSocket servidor = new ServerSocket(10000);
                Socket cliente = servidor.accept();
                PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
                String tSerializada = new Gson().toJson(t);
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
     * El servidor abre un hilo que tiene como función recibir la información enviada por el cliente despues
     * de cada turno. Guarda en la cola a cada jugador activo.
     */

    @Override
    public void run(){
        while (true){
            try{
                ServerSocket servidor = new ServerSocket(10001);
                Socket cliente = servidor.accept();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                Jugadores J = Jugadores.getInstance();
                if (!J.getJ1()){
                    String tRecibida = entrada.readLine();
                    cliente.close();
                    servidor.close();
                    Tablero t = new Gson().fromJson(tRecibida, Tablero.class);
                    J.setM(t.getFilas_columnas());
                    t.setJugador("J1");
                    this.iniciarT(t);
                    J.setJ1(true);
                }if (!J.getJ2()){
                    String tRecibida = entrada.readLine();
                    cliente.close();
                    servidor.close();
                    Tablero t = new Gson().fromJson(tRecibida, Tablero.class);
                    t.setJugador("J2");
                    t.setFilas_columnas(J.getM());
                    this.iniciarT(t);
                    J.setJ2(true);
                    //ListadeListasDeCuadros L1 =  ListadeListasDeCuadros.getInstance();
                    //L1.anadirElemento(J.getM()-1,250,50);
                }
                String tRecibida = entrada.readLine();
                Tablero t = new Gson().fromJson(tRecibida, Tablero.class);
                cliente.close();
                servidor.close();
                if (t.getJugador().equals("")){
                    this.iniciarT(t);
                    System.out.println("Se intentó conectar otro jugador, debe esperar");
                }else{
                    if (t.getJugador().equals("J1")){
                        if (J.isT1()) {
                            System.out.println("Hola1");
                            t.setMiTurno(true);
                            this.iniciarT(t);
                        }else{
                            System.out.println("Hola2");
                            t.setMiTurno(false);
                            this.iniciarT(t);
                        }
                    }else{
                        if (J.isT2()){
                            System.out.println("Hola3");
                            t.setMiTurno(true);
                            this.iniciarT(t);
                        }else{
                            System.out.println("Hola4");
                            t.setMiTurno(false);
                            this.iniciarT(t);
                        }
                    }
                }
            }catch (IOException a){
                System.out.println("Error recibiendo datos desde el servidor");
            }
        }
    }
}

