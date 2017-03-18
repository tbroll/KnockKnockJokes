package com.gmail.toddbroll;

import java.util.Scanner;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException{

        String serverAddress = "localhost";
        int port = 9999;

        Socket s = new Socket(serverAddress, port);

        Scanner scan = new Scanner(System.in);

        System.out.println("What color do you want to choose today?");
        String color = scan.nextLine();

        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        pw.println(color);

        BufferedReader input =
            new BufferedReader(new InputStreamReader(s.getInputStream()));

        String answer = input.readLine();
        System.out.println(answer);

        System.exit(0);
    }
}
