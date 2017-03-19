package com.gmail.toddbroll;

import java.net.ServerSocket;
import java.net.Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Text;

import java.lang.Math;

public class Server {

    public static void main(String [] args) throws IOException{
        String[] result;
        String input;
        BufferedReader in;
        PrintWriter out;
        String xmldoc;
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
                        result = KnockKnockFactory.getJoke();
                        xmldoc = KnockKnockFactory.buildXML(result);
                        out.println(xmldoc);
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
