package com.javaAcademy.tictactoe.gameImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private int port;
	private ServerSocket serverSocket;
	
	public Server(int port) {
		this.port = port;
	}
	
	public String resolveConnection(String message) throws IOException {
		serverSocket = new ServerSocket(port);

        Socket socket = serverSocket.accept();
            
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
        bufferedWriter.write(message + " \n\n");
        bufferedWriter.flush();
            
        String line = bufferedReader.readLine();
        System.out.println("TO JEST ODEBRANE: " + line);
        
		return line;
	}
}
