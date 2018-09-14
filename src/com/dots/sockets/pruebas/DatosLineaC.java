package com.dots.sockets.pruebas;

import com.dots.sockets.conexion.Cliente;

public class DatosLineaC {

    private int posxi;
    private int posyi;
    private int posxf;
    private int posyf;

    public DatosLineaC(int posxi, int posyi, int posxf, int posyf) {
        this.posxi = posxi;
        this.posyi = posyi;
        this.posxf = posxf;
        this.posyf = posyf;
    }

    public int getPosxi() {
        return this.posxi;
    }

    public int getPosyi() {
        return this.posyi;
    }

    public int getPosxf() {
        return this.posxf;
    }

    public int getPosyf() {
        return this.posyf;
    }


}
