package com.javaAcademy.tictactoe.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import com.javaAcademy.tictactoe.helper.IOResolver;
import com.javaAcademy.tictactoe.model.GameArena;
import com.javaAcademy.tictactoe.model.Symbol;
import com.javaAcademy.tictactoe.model.Type;

public class NetworkPrinter implements Printer {

	private Type type;
	private int port;
	private String addressIP;
	private Socket socket;
	private ServerSocket server;
	private BufferedWriter bufferedWriter;
	private boolean isServer;
	
	public NetworkPrinter(String addressIP, int port) {
		this.addressIP = addressIP;
		this.port = port;
		this.isServer = false;
	}
	
	public NetworkPrinter(ServerSocket server, int port) {
		this.server = server;
		this.port = port;
		this.isServer = true;
	}
	
	private void setSocket() throws UnknownHostException, IOException {
		if(isServer) {
			socket = server.accept();
		} else {
			socket = new Socket(addressIP, port);
		}
	}
	
	@Override
	public void printMessage(String key) {
		try {
			String message = IOResolver.getIOResolverInstance().getMsgByKey(key);
			showMessage(message);
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
			String message = IOResolver.getIOResolverInstance().getMsgByKey(key);
			for(Object param: params) {
				message += " " + param;
			}
			showMessage(message);
		} catch (IOException e) {
			try {
				socket.close();
			} catch (IOException e1) {
				System.out.println("Problem with close socket.");
			}
		} 
	}
	
	private void showMessage(String message) throws IOException {
		System.out.println("Printer jest: " + type);
		if(type.equals(Type.SERVER)) {
			ConsolePrinter.printMessageSOutLn(message);
		} else if (type.equals(Type.CLIENT)){
			setSocket();
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write(message);
			bufferedWriter.flush();
			socket.close();
		} else { //BOTH
			ConsolePrinter.printMessageSOutLn(message);
			setSocket();
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufferedWriter.write(message);
			bufferedWriter.flush();
			socket.close();
		}
	}	
	
	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public void printArena(GameArena arena) {
		Symbol[][] playArena = arena.getArena();
		String message = "";
		for(int y = 1; y < arena.getYDimension(); y++) {
			message += "\n";
			for(int x = 1; x < arena.getXDimension(); x++) {
				message += "  |" +  printPoint(playArena[x][y]);
			}
		}
		try {
			showMessage(message);
		} catch (IOException e) {
			System.out.println("Connection refused!");
		}
	}
	
	String printPoint(Symbol point) {
		return point.toString();
	}
}
