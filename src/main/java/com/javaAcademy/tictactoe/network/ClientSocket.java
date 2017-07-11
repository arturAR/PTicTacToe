package com.javaAcademy.tictactoe.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
	
	private static int port = 1978;
	//private static String addressIP = "192.168.56.1";
	//private static String addressIP = "10.0.2.15";
	private static String addressIP = "10.30.1.118";

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

	
	
}
