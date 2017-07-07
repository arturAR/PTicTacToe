package com.javaAcademy.tictactoe.view;

import com.javaAcademy.tictactoe.helper.IOResolver;

public class MessagePrinter implements Printer {
	
	public static void printMessageSOutLn(String message) {
		System.out.println(message);
	}
	
	public static void printMessageSOut(String message) {
		System.out.print(message);
	}
	
	public static void printMessageSErr(String message) {
		System.err.println(message);
	}
	
	public void printMessage(String key) {
		String message = IOResolver.getIOResolverInstance().getMsgByKey(key);
		System.out.println(message);
	}
	
	public void showMessageWithParam(String key, Object[] params) {
		String message = IOResolver.getIOResolverInstance().getMsgByKey(key);
		for(Object param: params) {
			message += " " + param;
		}
		MessagePrinter.printMessageSOutLn(message);
	}
}
