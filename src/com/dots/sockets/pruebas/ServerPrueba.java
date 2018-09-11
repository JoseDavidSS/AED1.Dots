package com.dots.sockets.pruebas;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ServerPrueba {

    public static void main(String[] args) throws IOException{
        ServerSocket socket = new ServerSocket(50099);
        ObjectMapper mapper = new ObjectMapper();
        while(true){
            Socket incoming = socket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
            try{
                String lineaOriginal = in.readLine();
                System.out.println("El cliente mando: " + lineaOriginal);
                PrintWriter out = new PrintWriter(incoming.getOutputStream(), true);
                out.println("xd");
                out.println();
                String json = in.readLine();
                System.out.println(json);
                DatosLineaS l1 = mapper.readValue(json, DatosLineaS.class);
                System.out.println(l1.getPosxi() + l1.getPosxf());
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }

}
