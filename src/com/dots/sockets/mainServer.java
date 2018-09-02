package com.dots.sockets;

import java.io.IOException;

public class mainServer {

    public static void main(String[] args) {
        Server s1 = new Server();
        try {
            s1.start();
        } catch (IOException e) {
            System.out.println("Mae se despicho la vara");
        }
    }
}
