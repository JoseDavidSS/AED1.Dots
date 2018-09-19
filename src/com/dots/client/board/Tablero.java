package com.dots.client.board;

public class Tablero {

    private int filas_columnas = 0;
    private static Tablero tablero = new Tablero();
    private String jugador = "";

    public static Tablero getInstance(){
        return tablero;
    }

    public static void setInstance(Tablero t){
        tablero = t;
    }

    public int getFilas_columnas() {
        return this.filas_columnas;
    }

    public void setFilas_columnas(int filas_columnas) {
        this.filas_columnas = filas_columnas;
    }

    public String getJugador() {
        return this.jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }
}

