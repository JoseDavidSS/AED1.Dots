package com.dots.server.board;

public class Jugadores {

    private static Jugadores jugadores = new Jugadores();
    private boolean j1 = false;
    private boolean j2 = false;
    private int m = 0;

    public static Jugadores getInstance(){
        return jugadores;
    }

    public boolean getJ1() {
        return this.j1;
    }

    public void setJ1(boolean j1) {
        this.j1 = j1;
    }

    public boolean getJ2() {
        return this.j2;
    }

    public void setJ2(boolean j2) {
        this.j2 = j2;
    }

    public int getM() {
        return this.m;
    }

    public void setM(int m) {
        this.m = m;
    }

}
