package Server;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class cookie {
    
    public static String getCookie(){
        File cookieFile = new File("C:/Users/evilz/Desktop/VTTP/Lectures/Day 4/client_server_attempt2/Server/cookie_file.txt");
        try (Scanner scan = new Scanner(cookieFile)) {
            ArrayList<String> cookieList = new ArrayList<>(); 
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                cookieList.add(line);
            }
            scan.close();
            Random rand = new Random();
            int sizeOfCookieList = cookieList.size();
            String randomCookieLine = cookieList.get(rand.nextInt(sizeOfCookieList));
            return randomCookieLine;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            
        }
        return null;
    }
}

