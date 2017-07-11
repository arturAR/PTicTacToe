package com.javaAcademy.tictactoe.network;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ServerSocketExample {
	
	
	public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12347);
        int cnt = 0;
       // while (true){
        for(int i = 0; i < 3 ; i++) {
        	cnt++;
        	System.out.println(cnt);
            Socket socket = serverSocket.accept();
            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            bufferedWriter.write("Podaj mi imie: " +" \n");
            bufferedWriter.write("Tylko prawdziwe! \n\n");
			bufferedWriter.flush();
            
            String line = bufferedReader.readLine();
            System.out.println("TO JEST ODEBRANE: " + line);
          //  while (!line.equals("")){
               // bufferedWriter.write("\nSever says: ");
               // bufferedWriter.write(line);
               // bufferedWriter.write("\n");
              //  bufferedWriter.flush();
              //  line = bufferedReader.readLine();
           // }
            
           // bufferedWriter.write("Koniec polaczenia.");
           // bufferedWriter.flush();
            socket.close();
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1978);
        int cnt = 0;
        //while (true){
      //  for(int i = 0; i < 5 ; i++) {
        	cnt++;
        	System.out.println(cnt);
            Socket socket = serverSocket.accept();
            System.out.println(socket.getRemoteSocketAddress());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("getLocalAddress: " + socket.getLocalAddress() +" \n");
		    bufferedWriter.write("getRemoteSocketAddress: "  + socket.getRemoteSocketAddress() +" \n");
		    bufferedWriter.write("socketServer.getInetAddress: "  + serverSocket.getInetAddress() +" \n");
		    bufferedWriter.write("socket.getInetAddress().getLoopbackAddress() : "  + socket.getInetAddress().getLoopbackAddress() +" \n");
		    bufferedWriter.write("socket.getLocalSocketAddress: " + socket.getLocalSocketAddress() +" \n\n");
            
		    bufferedWriter.write("socket.getLocalSocketAddress: " + serverSocket.getLocalSocketAddress() +" \n\n");
		    bufferedWriter.write("socket.getLocalSocketAddress: " + serverSocket.getLocalPort() +" \n\n");
		    
		    bufferedWriter.write("Napisz: \"END\" by zakończyć połączenie.");
            String line = bufferedReader.readLine();
            System.out.println("TO JEST ODEBRANE: " + line);
            while (!line.equals("")){
                bufferedWriter.write("\nServer says: ");
                bufferedWriter.write(line);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
                line = bufferedReader.readLine();
                System.out.println("TO JEST ODEBRANE: " + line+".");
            }
            
            bufferedWriter.write("Koniec polaczenia.");
            bufferedWriter.flush();
            socket.close();
      //  }
    }
	*/
}

