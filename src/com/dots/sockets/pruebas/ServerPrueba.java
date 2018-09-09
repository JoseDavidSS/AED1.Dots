package com.dots.sockets.pruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPrueba {

    public static void main(String[] args) throws IOException{
        ServerSocket socket = new ServerSocket(50099);
        while(true){
            Socket incoming = socket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
            try{
                String lineaOriginal = reader.readLine();
                System.out.println(lineaOriginal);
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }

}
