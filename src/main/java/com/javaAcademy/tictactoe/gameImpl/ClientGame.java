package com.javaAcademy.tictactoe.gameImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.javaAcademy.tictactoe.Game;
import com.javaAcademy.tictactoe.helper.IOResolver;

public class ClientGame implements Game {
	
	private Scanner s = new Scanner(System.in);
	IOResolver ioResolver = IOResolver.getIOResolverInstance();
	private Socket socket;
	private BufferedReader reader;
	private BufferedWriter bufferedWriter;
	private String addressIP; 
	private int port;
	
    public ClientGame(String addressIP, int port) throws UnknownHostException, IOException {
		this.addressIP = addressIP;
		this.port = port;
    	while(true) {
			readDataFromServer();
			writeDataToServer();
		}
    }
   
    
    private void writeDataToServer() throws UnknownHostException, IOException {
    	System.out.println("Pisze");
    	String input = s.nextLine();
    	socket = new Socket(addressIP, port);
    	bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bufferedWriter.write(input +" \n");
		bufferedWriter.flush();
		socket.close();
	}


	private void readDataFromServer() throws UnknownHostException, IOException {
		System.out.println("Czytam");
    	socket = new Socket(addressIP, port);
    	reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = reader.readLine();
		String msg = "";
        while (line != null) {
			msg += line;
        	line = reader.readLine();
		}
		socket.close();
		System.out.println(msg);
	}


	public static ClientGame startGame(String addressIP, int port) throws UnknownHostException, IOException {
		return new ClientGame(addressIP, port);
	}
}
