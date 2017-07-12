package com.javaAcademy.tictactoe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Scanner;

import com.javaAcademy.tictactoe.gameImpl.ClientGame;
import com.javaAcademy.tictactoe.io.IOResolver;
import com.javaAcademy.tictactoe.io.Printer;
import com.javaAcademy.tictactoe.io.UserInput;
import com.javaAcademy.tictactoe.io.inputImpl.ConsoleUserInput;
import com.javaAcademy.tictactoe.io.inputImpl.NetworkUserInput;
import com.javaAcademy.tictactoe.io.outputImpl.ConsolePrinter;
import com.javaAcademy.tictactoe.io.outputImpl.NetworkPrinter;
import com.javaAcademy.tictactoe.model.Type;

public class Main {
	
	static Scanner s = new Scanner(System.in);
	private static UserInput userInput;
	private static Printer printer;
	private static Type type;
	private static int port;
	private static String addressIP;
	private static ServerSocket serverSocket;
	
	public static void main(String[] args) throws IOException { 
        
    	System.out.println("Choose 1 to play 2-players game, choose 2 to play by network.");
    	String gameType = s.nextLine();
    	
    	if(gameType.equals("2")) {
    		System.out.println("If you want join to game press 1, else you will create a game:");
    		String typeNetworkGame = s.nextLine();
    		if(typeNetworkGame.equals("1")) {
    			System.out.println("Please insert IP addess of server:");
    			addressIP = s.nextLine();
    			
    			System.out.println("Please insert server port:");
    			String portID = s.nextLine();
    			port = Integer.parseInt(portID);
    			
    			System.out.println("Send message to server:");
    			
    			writeClientData();
    			
    			type = Type.CLIENT;
    		    printer = new NetworkPrinter(addressIP, port);
    			userInput = new NetworkUserInput(type);
    		} else {
    			System.out.println("Please choose server port:");
    			String portID = s.nextLine();
    			port = Integer.parseInt(portID);
    			
    			System.out.println("Your IP: ");
    			showServerIPAddresses();
    			System.out.println("Wait for connection.");
    			
    			readData();
    		   
    		    type = Type.SERVER;
    		    printer = new NetworkPrinter(serverSocket, port);
    			userInput = new NetworkUserInput(serverSocket, type);
    		}
    	} else {
    		printer = new ConsolePrinter();
    		userInput = new ConsoleUserInput();
    		type = Type.NORMAL;
    	}
    	System.out.println("Please choose the language/Wybierz język: 1 - English, 2 - Polish. Default English.");
    	String lang = s.nextLine();
    	
    	createIOResolver(lang);
    	IOResolver ioResolver = IOResolver.getIOResolverInstance();
		ioResolver.getPrinter().setType(Type.SERVER);
    	ioResolver.resolveIO("empty.chosenLanguage");
    	
    	if(type.equals(Type.CLIENT)) {
    		ClientGame clientGame = ClientGame.startGame(addressIP, port);
			clientGame.startClientGame();
		} else {
			GameCreator app = new GameCreator();
			app.startGame();
		}
	}

    private static void createIOResolver(String langNumber) {
		switch(langNumber) {
			case "1":
				IOResolver.createIOResolver(new Locale("en", "EN"), userInput, printer);
				break;
			case "2":
				IOResolver.createIOResolver(new Locale("pl", "PL"), userInput, printer);
				break;
			default:
				IOResolver.createIOResolver(new Locale("en", "EN"), userInput, printer);
		}
	}
    
    private static void showServerIPAddresses() throws SocketException {
    	Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(nets)) {
	        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
	        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
	        	if(!inetAddress.toString().contains(":") && !inetAddress.toString().equals("/127.0.0.1")) {
	        		System.out.printf("%s\n", inetAddress.toString().replace("/", ""));
	        	}
	        }
	        System.out.printf("\n");
        }
    }
    
	private static void writeClientData() throws IOException {
		Socket socket = new Socket(addressIP, port);
		String clientData = s.nextLine();

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bufferedWriter.write(clientData +" \n");
		bufferedWriter.flush();
		socket.close();
	}
	
	private static void readData() throws IOException {
		serverSocket = new ServerSocket(port);
		Socket socket = serverSocket.accept();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = reader.readLine();
		String msg = "";
        while (line != null) {
			msg += line;
        	line = reader.readLine();
		}
        System.out.println("From second player: " + msg);
        System.out.println("Connected!");
		socket.close();
	}
}
