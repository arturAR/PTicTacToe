package com.javaAcademy.tictactoe.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket serverSocket;
	
	public void createServer() {
		try {
			serverSocket = new ServerSocket(1978);
			while (true){
				Socket socket = serverSocket.accept();
				 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
