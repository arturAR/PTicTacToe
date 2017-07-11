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
		while(true) {
			socket = new Socket(addressIP, port);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = reader.readLine();
			String message = line;
			while (!line.equals("")) {
				line = reader.readLine();
				message += line;
			}
			System.out.println(message);

			System.out.println();
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String a = s.nextLine();
			bufferedWriter.write(a +" \n");
			bufferedWriter.flush();


			while (line != null){
				System.out.flush();
				line = reader.readLine();
			}
		}
    }
   
    
    public static ClientGame startGame(String addressIP, int port) throws UnknownHostException, IOException {
		return new ClientGame(addressIP, port);
	}
}
