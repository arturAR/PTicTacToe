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
	private Socket socket;
	
	public NetworkUserInput(ServerSocket serverSocket, Type type) {
		this.serverSocket = serverSocket;
		this.type = type;
	}

	public NetworkUserInput(Type type) {
		this.type = type;
	}

	@Override
	public String getUserInput() throws IOException {
		if(type.equals(Type.CLIENT)) {
	        String msg = readData();
			return msg;
		} else {
			return scanner.nextLine();
		}
	}
	
	private String readData() throws IOException {
		System.out.println("Server czyta");
		socket = serverSocket.accept(); 
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = reader.readLine();
        System.out.println("Czytałem: " + line);
		String msg = "";
        while (line != null) {
			msg += line;
        	line = reader.readLine();
		}
        socket.close();
        System.out.println("cała wiadomość: " + msg);
        return msg;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
}
