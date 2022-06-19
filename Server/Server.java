package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server{
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(12345);
        Socket servSocket = ss.accept();

        InputStreamReader isr = new InputStreamReader(servSocket.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(servSocket.getOutputStream());
        BufferedWriter bw = new BufferedWriter(osw);
        boolean isClosed = false;

        while(!isClosed){
            String msgFromClient = br.readLine();
            switch(msgFromClient){
                case "get-cookie":
                bw.write("cookie-text: " + cookie.getCookie()); 
                bw.newLine();               
                bw.flush();
                break;

                case "close":
                isClosed = true;
                bw.write("Closing connection. Goodbye");
                bw.flush();
                break;

                default: 
                bw.write("What are you saying?");
                bw.newLine();
                bw.flush();
            }
        }
        try{
            servSocket.close();
            
        }
        catch (IOException ex){
            System.out.println("Error closing connection");
        }


    }
}