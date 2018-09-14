package com.dots.sockets.pruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientPruebas {

    public static void main(String[] args) throws IOException{
        InetAddress address = InetAddress.getByName("127.0.0.1");
        Socket client = new Socket(address, 50099);
        ObjectMapper mapper = new ObjectMapper();
        DatosLineaC l1 = new DatosLineaC(1,1,2,2);
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        out.print(4);
        out.println();
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String linea = in.readLine();
        System.out.println("El server mando: " + linea);
        System.out.println(mapper.writeValueAsString(l1));
        out.print(mapper.writeValueAsString(l1));
        out.println();

    }

}
