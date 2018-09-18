package com.dots.client.lists.board;

public class NodoCuadros {

    public NodoCuadros next;
    public NodoCuadros prev;
    private int estado;
    private int v1x;
    private int v1y;
    private int v2x;
    private int v2y;
    private int v3x;
    private int v3y;
    private int v4x;
    private int v4y;

    public NodoCuadros(int v1x, int v1y, int v2x, int v2y, int v3x, int v3y, int v4x, int v4y) {
        this.next = null;
        this.prev = null;
        this.estado = 0;
        this.v1x = v1x;
        this.v1y = v1y;
        this.v2x = v2x;
        this.v2y = v2y;
        this.v3x = v3x;
        this.v3y = v3y;
        this.v4x = v4x;
        this.v4y = v4y;
    }

    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getV1x() {
        return this.v1x;
    }

    public void setV1x(int v1x) {
        this.v1x = v1x;
    }

    public int getV1y() {
        return this.v1y;
    }

    public void setV1y(int v1y) {
        this.v1y = v1y;
    }

    public int getV2x() {
        return this.v2x;
    }

    public void setV2x(int v2x) {
        this.v2x = v2x;
    }

    public int getV2y() {
        return this.v2y;
    }

    public void setV2y(int v2y) {
        this.v2y = v2y;
    }

    public int getV3x() {
        return this.v3x;
    }

    public void setV3x(int v3x) {
        this.v3x = v3x;
    }

    public int getV3y() {
        return this.v3y;
    }

    public void setV3y(int v3y) {
        this.v3y = v3y;
    }

    public int getV4x() {
        return this.v4x;
    }

    public void setV4x(int v4x) {
        this.v4x = v4x;
    }

    public int getV4y() {
        return this.v4y;
    }

    public void setV4y(int v4y) {
        this.v4y = v4y;
    }
}
