package com.dots.client.board;

/**
 * Clase que almacena los datos del jugador actual
 */

public class Tablero {

    private int filas_columnas = 0;
    private static Tablero tablero = new Tablero();
    private String jugador = "";
    private Boolean miTurno = false;

    /**
     * Método Singleton.
     * @return instancia de esta clase.
     */

    public static Tablero getInstance(){
        return tablero;
    }

    /**
     * Método para modificar el Singleton.
     * @param t instancia modificada.
     */

    public static void setInstance(Tablero t){
        tablero = t;
    }

    /**
     * Método para conseguir las filas y columnas de los vértices.
     * @return entero con la cantidad de filas y columnas.
     */

    public int getFilas_columnas() {
        return this.filas_columnas;
    }

    /**
     * Método para modificar las filas y columnas.
     * @param filas_columnas nuevo número de filas y columnas.
     */

    public void setFilas_columnas(int filas_columnas) {
        this.filas_columnas = filas_columnas;
    }

    /**
     * Método para obtener el número de jugador asignado por el server
     * @return una string con el jugador
     */

    public String getJugador() {
        return this.jugador;
    }

    /**
     * Método para asignar el jugador al juego.
     * @param jugador el nuevo jugador.
     */

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    /**
     * Método para obtener el estado del turno del jugador
     * @return un boolean indicando si es el turno del jugador
     */

    public Boolean getMiTurno() {
        return miTurno;
    }

    /**
     * Método para asignar el nuevo turno al jugador.
     * @param miTurno boolean con el nuevo estado del turno del jugador.
     */

    public void setMiTurno(Boolean miTurno) {
        this.miTurno = miTurno;
    }

}

