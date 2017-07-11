package com.javaAcademy.tictactoe.network;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ServerSocketExample {
	
	static ServerSocket serverSocket;
	static Socket socket;
	static BufferedWriter bufferedWriter;
	static BufferedReader reader;
	
	public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(1978);

        socket = serverSocket.accept(); 
        writeData("Podaj mi imie: ");
        
        
        socket = serverSocket.accept(); 
        readData();
        socket.close();
        
        socket = serverSocket.accept(); 
        writeData("Podaj mi nazwisko: ");
        socket.close();
        
        socket = serverSocket.accept(); 
        readData();
        socket.close();
        
      /*  
        
        socket = serverSocket.accept(); 
        readData();
        writeData("Podaj mi nazwisko: ");
        readData();
        socket.close();*/
    }
	
	private static void refresh() throws IOException {
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line = reader.readLine();
		while (line != null){
			System.out.flush();
			line = reader.readLine();
		}
	}
	
	private static void readData() throws IOException {
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println("chce czytać");
        String line = reader.readLine();
		String msg = "";
        while (line != null) {
			msg += line;
        	line = reader.readLine();
		}
        System.out.println("cała wiadomość: " + msg);
	}

	static void writeData(String message) throws IOException {
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write(message +" \n");
		bufferedWriter.flush();
	}
	
	

}
/*
 * 
 * public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(12347);
       // while (true){
        for(int i = 0; i < 3 ; i++) {
            socket = serverSocket.accept();
            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            bufferedWriter.write("Podaj mi imie: " +" \n");
			bufferedWriter.flush();
            
            String line = bufferedReader.readLine();
            System.out.println("TO JEST ODEBRANE: " + line);
          //  while (!line.equals("")){
               // bufferedWriter.write("\nSever says: ");
               // bufferedWriter.write(line);
               // bufferedWriter.write("\n");
              //  bufferedWriter.flush();
              //  line = bufferedReader.readLine();
           // }
            
           // bufferedWriter.write("Koniec polaczenia.");
           // bufferedWriter.flush();
            socket.close();
        }
    }
 * 
 * */
