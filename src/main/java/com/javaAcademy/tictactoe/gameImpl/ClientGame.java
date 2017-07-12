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
	private int xDim;
	
    public ClientGame(String addressIP, int port) throws UnknownHostException, IOException {
		this.addressIP = addressIP;
		this.port = port;
    }
    
    public void startClientGame() throws UnknownHostException, IOException {
    	String key = "";
    	do {
			key = readDataFromServer();
			printMessage(key);
			if(!key.startsWith("empty") && !key.startsWith(" | ")) {
				writeDataToServer();
			}
		} while(!key.equals("epty.gameEnd") || !key.startsWith("empty.gameResult"));
    }
   
    
    private void writeDataToServer() throws UnknownHostException, IOException {
    	String input = s.nextLine();
    	socket = new Socket(addressIP, port);
    	bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bufferedWriter.write(input +"\n");
		bufferedWriter.flush();
		socket.close();
	}


	private String readDataFromServer() throws UnknownHostException, IOException {
    	socket = new Socket(addressIP, port);
    	reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = reader.readLine();
		String msg = "";
        while (line != null) {
			msg += line;
        	line = reader.readLine();
		}
		socket.close();
		return msg;
	}
	
	private void printMessage(String key) {
		String message;
		if(key.startsWith(" | ")) {
			printTable(key);
		} else {
			if(key.startsWith("empty.tableSize")) {
				String[] splitedArray = key.split(" ");
				xDim = Integer.parseInt(splitedArray[1]);
			} else {
				String[] splitedArray = key.split(" ");
				message = IOResolver.getIOResolverInstance().getMsgByKey(splitedArray[0]);
				for(String param: splitedArray) {
					if(!param.equals(splitedArray[0])) {
						message += " " + param;
					}
				}
				System.out.println(message);
			}
		}
	}


	void printTable(String key) {
		char[] array = key.toCharArray();
		Character separator = '|';
		int cnt = 0;
		int warunek = xDim+1;
		StringBuilder sB = new StringBuilder("  ");
		for(int i = 0; i < array.length; i++) {
			if(separator.equals(array[i])) {
				cnt++;
			}

			if(cnt%(warunek) == 0 && cnt != 0) {
				sB.append("\n\n   " + array[i]);
				cnt = 0;
				warunek = xDim;
			} else {
				sB.append(array[i]);
			}
		}
		System.out.println(sB.toString());
	}


	public static ClientGame startGame(String addressIP, int port) throws UnknownHostException, IOException {
		return new ClientGame(addressIP, port);
	}
}
