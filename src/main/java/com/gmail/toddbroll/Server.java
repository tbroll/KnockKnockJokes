package com.gmail.toddbroll;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.lang.Math;

public class Server {

    public static void main(String [] args) throws IOException{
        String[] result;
        String input;
        BufferedReader in;
        PrintWriter out;
        int port = 9999;

        ServerSocket listener = new ServerSocket(port);
        System.out.println("Server is listening on " + port);

        try {
            while (true) {
                Socket socket = listener.accept();
                try {

                    in = 
                        new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    out =
                        new PrintWriter(socket.getOutputStream(),true);

                    while(true){
                    result = KnockKnock.getJoke();
                    out.println("knock knock");
                    input = in.readLine();
                    out.println(result[0]);
                    input = in.readLine();
                    out.println(result[1]);
                    }
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
class KnockKnock {

   private static final String[] KKJokesP1 = 
   {"turnip", "cows go", "little old lad", "nana", "etch"};

   private static final String[] KKJokesP2 = 
   {"turnip the heat, it's cold in here", "Silly you, cows go moo", 
     "I didn't know you could yodel", "nana your business", "bless you"};

   public static String[] getJoke(){
        String[] joke = new String[2];
        double in = Math.random() * (KKJokesP1.length-1);
        int index =(int)Math.round(in);
        joke[0] = KKJokesP1[index];
        joke[1] = KKJokesP2[index];
       return joke; 
   }
}
