package com.javaAcademy.tictactoe.view;

import com.javaAcademy.tictactoe.helper.IOResolver;
import com.javaAcademy.tictactoe.model.Type;

public class NetworkPrinter implements Printer {

	private Type type;
	
	@Override
	public void printMessage(String key) {
		String message = IOResolver.getIOResolverInstance().getMsgByKey(key);
		if(type.equals(Type.SERVER)) {
			
		} else {
			
		}
	}
	
	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public void showMessageWithParam(String key, Object[] params) {
		// TODO Auto-generated method stub
		
	}
}
