package com.dots.server.board;

/**
 * Clase que almacena los jugadores conectados, maneja los turnos y el tamaño de la plantilla de juego.
 */

public class Jugadores {

    private static Jugadores jugadores = new Jugadores();
    private boolean j1 = false;
    private boolean j2 = false;
    private boolean t1 = false;
    private boolean t2 = true;
    private int m = 0;
    private boolean fin = false;
    private int puntaje1 = 0;
    private int puntaje2 = 0;

    /**
     * Singletom de la clase.
     * @return instancia de la clase.
     */

    public static Jugadores getInstance(){
        return jugadores;
    }

    public static void setInstance(Jugadores jugador){
        jugadores = jugador;
    }

    /**
     * Método para comprobar si ya se conectó el primer jugador.
     * @return boolean indicando si se conectó o no.
     */

    public boolean getJ1() {
        return this.j1;
    }

    /**
     * Método para modificar si se conectó el primer jugador.
     * @param j1 boolean con el nuevo estado.
     */

    public void setJ1(boolean j1) {
        this.j1 = j1;
    }

    /**
     * Método para comprobar si ya se conectó el segundo jugador.
     * @return boolean indicando si se conectó o no.
     */

    public boolean getJ2() {
        return this.j2;
    }

    /**
     * Método para modificar si se conectó el segundo jugador.
     * @param j2 boolean con el nuevo estado.
     */

    public void setJ2(boolean j2) {
        this.j2 = j2;
    }

    /**
     * Método para obtener el tamaño de la plantilla de juego.
     * @return entero con el tamaño de la plantilla.
     */

    public int getM() {
        return this.m;
    }

    /**
     * Método para modificar el tamaño de la plantilla de juego.
     * @param m entero con el nuevo tamaño.
     */

    public void setM(int m) {
        this.m = m;
    }

    /**
     * Método para comprobar el estado de turno de jugador uno.
     * @return booolean indicando si es su turno o no.
     */

    public boolean isT1() {
        return this.t1;
    }

    /**
     * Método para modificar el estado de turno del jugador uno.
     * @param t1 boolean con el nuevo estado de turno.
     */

    public void setT1(boolean t1) {
        this.t1 = t1;
    }

    /**
     * Método para comprobar el estado de turno de jugador dos.
     * @return booolean indicando si es su turno o no.
     */

    public boolean isT2() {
        return this.t2;
    }

    /**
     * Método para modificar el estado de turno del jugador dos.
     * @param t2 boolean con el nuevo estado de turno.
     */

    public void setT2(boolean t2) {
        this.t2 = t2;
    }

    /**
     * Método para obtener si el juego acabó.
     * @return un boolean con el estado del juego.
     */

    public boolean isFin() {
        return this.fin;
    }

    /**
     * Método para cambiar el estado del juego.
     * @param fin boolean que almacena si acabó o no el juego.
     */

    public void setFin(boolean fin) {
        this.fin = fin;
    }

    /**
     * Método para obtener el puntaje del jugador 1.
     * @return entero que almacena la cantidad de puntos del jugador 1.
     */

    public int getPuntaje1() {
        return puntaje1;
    }

    /**
     * Método para modificar el puntaje del jugador 1.
     * @param puntaje1 entero con la nueva cantidad de puntos del jugador 1.
     */

    public void setPuntaje1(int puntaje1) {
        this.puntaje1 = puntaje1;
    }

    /**
     * Método para obtener el puntaje del jugador 2.
     * @return entero que almacena la cantidad de puntos del jugador 2.
     */

    public int getPuntaje2() {
        return puntaje2;
    }

    /**
     * Método para modificar el puntaje del jugador 2.
     * @param puntaje2 entero con la nueva cantidad de puntos del jugador 2.
     */

    public void setPuntaje2(int puntaje2) {
        this.puntaje2 = puntaje2;
    }
}
