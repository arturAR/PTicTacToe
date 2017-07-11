package com.javaAcademy.tictactoe.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket serverSocket;
	
	public Server(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	
	public String resolveConnection(String message) throws IOException {
		String returnMessage = "";
        Socket socket = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write(message);
        String line = bufferedReader.readLine();
        returnMessage += line;
        System.out.println("TO JEST ODEBRANE: " + line);
        while (!line.equals("")){
            bufferedWriter.flush();
            line = bufferedReader.readLine();
            returnMessage += line;
            System.out.println("TO JEST ODEBRANE: " + line+".");
        }
            
        bufferedWriter.write("Koniec polaczenia.");
        bufferedWriter.flush();
        socket.close();
        
		return returnMessage;
	}
}
