package com.javaAcademy.tictactoe.helper.inputImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.javaAcademy.tictactoe.helper.UserInput;
import com.javaAcademy.tictactoe.model.Type;

public class NetworkUserInput implements UserInput{

	private Type type;
	private Scanner scanner = new Scanner(System.in);
	private ServerSocket serverSocket;
	
	public NetworkUserInput(ServerSocket serverSocket, Type type) {
		this.serverSocket = serverSocket;
		this.type = type;
	}

	public NetworkUserInput(Type type) {
		this.type = type;
	}

	@Override
	public String getUserInput() throws IOException {
		System.out.println("UserInput typ: " + type);
		if(type.equals(Type.CLIENT)) {
			Socket socket = serverSocket.accept();
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    
			String line = reader.readLine();
			String message = line;
			while (!line.equals("")) {
				message += line;
			}
			socket.close();
			return message;
		} else {
			return scanner.nextLine();
		}
	}
	
	public void setType(Type type) {
		this.type = type;
	}
}
