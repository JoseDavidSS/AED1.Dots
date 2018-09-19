package com.dots.server.board;

public class Tablero {

    private int filas_columnas = 0;
    private static Tablero tablero = new Tablero();
    private String jugador = "";

    public static Tablero getInstance(){
        return tablero;
    }

    public int getFilas_columnas() {
        return this.filas_columnas;
    }

    public void setFilas_columnas(int filas_columnas) {
        this.filas_columnas = filas_columnas;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }
}

