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
	
	Scanner s = new Scanner(System.in);
	IOResolver ioResolver = IOResolver.getIOResolverInstance();
	private Socket socket;
	
    public ClientGame(String addressIP, int port) throws UnknownHostException, IOException {
    	//String line = "start";
    	while(true) {
			Socket socket = new Socket(addressIP, port);
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = reader.readLine();
			while (line != null){
				System.out.println(line);
				System.out.flush();
				line = reader.readLine();
			}
			
			String a = s.nextLine();
			bufferedWriter.write(a +" \n\n");
			System.out.println("Napisałem: " + a);
			bufferedWriter.flush();
			System.out.println("Poszło!");
		}
    	/*
		do {
			try{
				line = doSocket(addressIP, port);
			} catch (UnknownHostException e) {
				try {
					socket.close();
				} catch (IOException e1) {
					System.err.println("Error in closing socket");
				}
			} catch (Exception e) {
				try {
					socket.close();
				} catch (IOException e1) {
					System.err.println("Error in closing socket");
				}
			}
		} while (!line.equals(ioResolver.getMsgByKey("epty.gameEnd")) || !line.equals(ioResolver.getMsgByKey("empty.matchResult.head")));
    */
    }
    
    private String doSocket(String addressIP, int port) throws UnknownHostException, IOException{
		socket = new Socket(addressIP, port);
				
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line = reader.readLine();
		
		System.out.println(line);
		String a = s.nextLine();		
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bufferedWriter.write(a +"\n\n");
		System.out.println("napisałem i próbuje wysyłać: " + a);	    
		bufferedWriter.flush();
		System.out.println("poszło!");
		return line;
    }
    
    public static ClientGame startGame(String addressIP, int port) throws UnknownHostException, IOException {
		return new ClientGame(addressIP, port);
	}
}
