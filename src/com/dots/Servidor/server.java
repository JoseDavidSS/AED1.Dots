package com.dots.Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public void start() throws IOException {
        ServerSocket server = new ServerSocket(10000);
        while (true) {
            Socket socket = server.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = reader.readLine();
            System.out.println(line);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("ok");
        }
    }

    public static void main(String[] args) throws IOException{
        server s1 = new server();
        s1.start();
    }
}
