package com.javaAcademy.tictactoe.helper.inputImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.javaAcademy.tictactoe.helper.UserInput;
import com.javaAcademy.tictactoe.model.Type;
import com.javaAcademy.tictactoe.network.Server;

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
			String message = "";
			System.out.println("Tworzę socket");
			Socket socket = serverSocket.accept();
			System.out.println("Stworzyłem socket");
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    
			System.out.println("Czytam linie:");
			String line = reader.readLine();
			System.out.println("MAM: " + line);
			message = line;
			while (!line.equals("")) {
				message += line;
				line = reader.readLine();
			}
			System.out.println("Klient podał: " + message);
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
