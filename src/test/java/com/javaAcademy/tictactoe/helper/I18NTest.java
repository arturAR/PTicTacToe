package com.javaAcademy.tictactoe.helper;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.javaAcademy.tictactoe.helper.IOResolver;
import com.javaAcademy.tictactoe.helper.inputImpl.ConsoleUserInput;
import com.javaAcademy.tictactoe.view.ConsolePrinter;
import com.javaAcademy.tictactoe.view.Printer;

import static org.testng.Assert.*;

import java.util.Locale;
import java.util.ResourceBundle;


@Test
public class I18NTest {
	
	private String language = new String("en");
    private String country = new String("EN");
    private Locale locale;
    private UserInput userInput;
	private Printer printer;
    
	@BeforeTest
	public void createIOResolver() {
		locale = new Locale(language, country);
		printer = new ConsolePrinter();
		userInput = new ConsoleUserInput();
		
		IOResolver.createIOResolver(locale, userInput, printer);
	}
    
    
	@Test
	public void testInternationalization() {
        
        Locale defaultLocale = new Locale(language, country);
        ResourceBundle messages = ResourceBundle.getBundle("Messages", defaultLocale);
        
        assertEquals("Hello my friend!.", messages.getString("hello"));
	}
	
	@Test
	public void testInternationalizationFromMessageResolver() {
		IOResolver msgResolver = IOResolver.getIOResolverInstance();
		String key = "hello";
		
		assertEquals("Hello my friend!.", msgResolver.getMsgByKey(key));
		
	}
	
}
