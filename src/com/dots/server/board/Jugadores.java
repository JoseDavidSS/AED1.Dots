package com.dots.server.board;

public class Jugadores {

    private static Jugadores jugadores = new Jugadores();
    private String j1 = "";
    private String j2 = "";
    private int m = 0;

    public static Jugadores getInstance(){
        return jugadores;
    }

    public String getJ1() {
        return this.j1;
    }

    public void setJ1(String j1) {
        this.j1 = j1;
    }

    public String getJ2() {
        return this.j2;
    }

    public void setJ2(String j2) {
        this.j2 = j2;
    }

    public int getM() {
        return this.m;
    }

    public void setM(int m) {
        this.m = m;
    }

}
