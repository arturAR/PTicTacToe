package com.javaAcademy.tictactoe.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
	
	private static int port = 1978;
	private static String addressIP = "10.0.2.15";
	
	static Socket socket;
	static BufferedReader reader;
	static BufferedWriter bufferedWriter;

	public static void main(String[] args) throws Exception{

		socket = new Socket(addressIP, port);
		readData();
		socket.close();

		socket = new Socket(addressIP, port);
		writeData("Teraz moja kolej!");
		socket.close();


		socket = new Socket(addressIP, port);
		readData();
		socket.close();

		socket = new Socket(addressIP, port);
		writeData();
		socket.close();
		/*refresh();
		
		socket = new Socket(addressIP, port);
		writeData();
		readData();
		writeData();
		refresh();
		socket.close();*/
		
	}
	
	private static void refresh() throws IOException {
		String line = reader.readLine();
		while (line != null){
			System.out.flush();
			line = reader.readLine();
		}
	}
	static void writeData(String message) throws IOException {
		bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bufferedWriter.write(message +" \n");
		bufferedWriter.flush();
	}

	static void writeData() throws IOException {
		Scanner s = new Scanner(System.in);
		String a = s.nextLine();

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bufferedWriter.write(a +" \n");
		bufferedWriter.flush();
	}
	
	private static void readData() throws IOException {
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = reader.readLine();
		String msg = "";
        while (line != null) {
			msg += line;
        	line = reader.readLine();
		}
        System.out.println("cała wiadomość: " + msg);
	}
	
	
	
}





/*
 * 
	public static void main(String[] args) throws Exception{

		//for(int i = 0; i < 5 ; i++) {
		while(true) {
			Socket socket = new Socket("10.0.2.15", 12347);
			
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
			Scanner s = new Scanner(System.in);
			String a = s.nextLine();
			bufferedWriter.write(a +" \n");
			bufferedWriter.flush();


			while (line != null){
				System.out.flush();
				line = reader.readLine();
			}
		}
	}
 * 
 * */