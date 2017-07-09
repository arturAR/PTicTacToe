package com.javaAcademy.tictactoe.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
	
	public static void main(String[] args) throws Exception{
		
		for(int i = 0; i < 5 ; i++) {
			Socket socket = new Socket("192.168.1.6", 1978);
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		    Scanner s = new Scanner(System.in);
		    String a = s.nextLine();
		    bufferedWriter.write("getLocalAddress: " + a + " adress: " + socket.getLocalAddress() +" \n");
		   // bufferedWriter.write("getRemoteSocketAddress: " + a + " adress: " + socket.getRemoteSocketAddress() +" \n");
		   // bufferedWriter.write("socket.getInetAddress: " + a + " adress: " + socket.getInetAddress() +" \n");
		   // bufferedWriter.write("socket.getInetAddress().getLoopbackAddress() : " + a + " adress: " + socket.getInetAddress().getLoopbackAddress() +" \n");
		   // bufferedWriter.write("socket.getLocalSocketAddress: " + a + " adress: " + socket.getLocalSocketAddress() +" \n\n");
		    bufferedWriter.flush();
		    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    String line = reader.readLine();
		    while (line != null){
		        System.out.println(line);
		        System.out.flush();
		        line = reader.readLine();
			}
		}
    }
}
