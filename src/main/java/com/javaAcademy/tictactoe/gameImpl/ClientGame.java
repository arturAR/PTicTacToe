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
	
    public ClientGame(String addressIP, int port) {
    	String line = "start";
    	Socket socket = null;
		do {
			try {
				socket = new Socket(addressIP, port);
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			    line = reader.readLine();
				
				BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			    String a = s.nextLine();
			    bufferedWriter.write(a);
			    
			    bufferedWriter.flush();
			    socket.close();
			} catch (UnknownHostException e) {
				try {
					socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} catch (IOException e) {
				try {
					socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} while (!line.equals(ioResolver.getMsgByKey("epty.gameEnd")) || !line.equals(ioResolver.getMsgByKey("empty.matchResult.head")));
    }
    
    public static ClientGame startGame(String addressIP, int port) {
		return new ClientGame(addressIP, port);
	}
}
