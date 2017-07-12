package com.javaAcademy.tictactoe.view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.javaAcademy.tictactoe.helper.IOResolver;
import com.javaAcademy.tictactoe.model.GameArena;
import com.javaAcademy.tictactoe.model.Symbol;
import com.javaAcademy.tictactoe.model.Type;

public class NetworkPrinter implements Printer {

	private Type type;
	int port;
	String addressIP;
	private Socket socket;
	private ServerSocket server;
	private BufferedWriter bufferedWriter;
	
	public NetworkPrinter(String addressIP, int port) {
		this.addressIP = addressIP;
		this.port = port;
	}
	
	public NetworkPrinter(ServerSocket server, int port) {
		this.server = server;
		this.port = port;
	}
	
	@Override
	public void printMessage(String key) {
		try {
			showMessage(key);
		} catch (IOException e) {
			try {
				socket.close();
			} catch (IOException e1) {
				System.out.println("Problem with close socket.");
			}
		} 
	}

	@Override
	public void showMessageWithParam(String key, Object[] params) {
		try {
			showMessage(key, params);
		} catch (IOException e) {
			try {
				socket.close();
			} catch (IOException e1) {
				System.out.println("Problem with close socket.");
			}
		} 
	}
	
	private void showMessage(String key, Object ...params) throws IOException {
		if(type.equals(Type.SERVER)) {
			String message = IOResolver.getIOResolverInstance().getMsgByKey(key);
			for(Object param: params) {
				message += " " + param;
			}
			ConsolePrinter.printMessageSOutLn(message);
		} else if (type.equals(Type.CLIENT)){
			writeData(key, params);
		} else { //BOTH
			String message = IOResolver.getIOResolverInstance().getMsgByKey(key);
			for(Object param: params) {
				message += " " + param;
			}
			ConsolePrinter.printMessageSOutLn(message);
			writeData(key, params);
		}
	}	
	
	void writeData(String message, Object ...params) throws IOException {
		socket = server.accept(); 
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write(message +" \n");
        for(Object param: params) {
        	bufferedWriter.write(param +" \n");
		}
		bufferedWriter.flush();
		socket.close();
	}
	
	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public void printArena(GameArena arena) {
		Symbol[][] playArena = arena.getArena();
		String message = "";
		for(int y = 1; y < arena.getYDimension(); y++) {
			message += "\r\n";
			for(int x = 1; x < arena.getXDimension(); x++) {
				message += " | " +  printPoint(playArena[x][y]);
			}
		}
		try {
			type = Type.BOTH;
			ConsolePrinter.printMessageSOutLn(message);
			writeData(message);
		} catch (IOException e) {
			System.out.println("Connection refused!");
		}
	}
	
	String printPoint(Symbol point) {
		return point.toString();
	}
}
