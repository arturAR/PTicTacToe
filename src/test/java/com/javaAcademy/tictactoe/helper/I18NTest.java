package com.javaAcademy.tictactoe.helper;

import org.testng.annotations.Test;

import com.javaAcademy.tictactoe.helper.IOResolver;

import static org.testng.Assert.*;

import java.util.Locale;
import java.util.ResourceBundle;


@Test
public class I18NTest {
	
	private String language = new String("en");
    private String country = new String("EN");
    
	@Test
	public void testInternationalization() {
        
        Locale defaultLocale = new Locale(language, country);
        ResourceBundle messages = ResourceBundle.getBundle("Messages", defaultLocale);
        
        assertEquals("Hello my friend!.", messages.getString("hello"));
	}
	
	@Test
	public void testInternationalizationFromMessageResolver() {
		Locale defaultLocale = new Locale(language, country);
		
		IOResolver msgResolver = IOResolver.createIOResolver(defaultLocale);
		String key = "hello";
		
		assertEquals("Hello my friend!.", msgResolver.getMsgByKey(key));
		
	}
	
}
