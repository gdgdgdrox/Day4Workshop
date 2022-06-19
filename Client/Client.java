package Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket clientSocket = new Socket("localhost", 12345);

        InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter osr = new OutputStreamWriter(clientSocket.getOutputStream());
        BufferedWriter bw = new BufferedWriter(osr);
        Scanner scan = new Scanner(System.in);

        while(true){
            String msgToSend = scan.nextLine();
            bw.write(msgToSend);
            bw.newLine();   
            bw.flush(); 
            System.out.println(br.readLine());

            if(msgToSend.equalsIgnoreCase("close"))
                break;         
        }
            bw.close();
            osr.close();
            br.close();
            isr.close();
            clientSocket.close();       


        
    }
    
}
