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
        Scanner scan;
        BufferedReader input;
        PrintWriter output;
        String response, answer;
        boolean HearAnother = true;

        String serverAddress = "localhost";
        int port = 9999;

        Socket s = new Socket(serverAddress, port);

        output = new PrintWriter(s.getOutputStream(), true);

        input =
            new BufferedReader(new InputStreamReader(s.getInputStream()));

        scan = new Scanner(System.in);

        System.out.println("Do you want to hear a knock knock joke? y/n");
        response = scan.nextLine();
        if(response.equals("n")){
            HearAnother = false;    
        }

        while(HearAnother){
            if(response.equals("n")){
                HearAnother = false;    
                break;
            }
            answer = input.readLine();
            System.out.println(answer);

            System.out.println("who's there");
            output.println("who's there");

            answer = input.readLine();
            System.out.println(answer);
            answer = answer + " who";

            System.out.println(answer);
            output.println(response);

            answer = input.readLine();
            System.out.println(answer);

            System.out.println("Do you want to hear another knock knock joke? y/n");
            response = scan.nextLine();
        }

        System.exit(0);
    }
}
