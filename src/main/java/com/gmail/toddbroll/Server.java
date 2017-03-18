package com.gmail.toddbroll;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
public class Server {

    private static String selectColor(String color){
        return "The color you chose is " + color;
    }
    public static void main(String [] args) throws IOException{
        String result;
        String input;
        int port = 9999;

        ServerSocket listener = new ServerSocket(port);
        System.out.println("Server is listening on " + port);

        try {
            while (true) {
                Socket socket = listener.accept();
                try {

                    BufferedReader bf = 
                        new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    PrintWriter out =
                        new PrintWriter(socket.getOutputStream(),true);

                    input = bf.readLine();
                    result = selectColor(input);
                    out.println(result);
                } finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
    }
}
