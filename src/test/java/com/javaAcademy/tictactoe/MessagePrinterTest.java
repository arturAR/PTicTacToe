package com.javaAcademy.tictactoe;

import static org.testng.Assert.assertEquals;

import com.javaAcademy.tictactoe.view.MessagePrinter;
import org.testng.annotations.Test;

public class MessagePrinterTest {

    @Test
    public void testMessagePrinterSOut() {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        String testString = "hello world";
        MessagePrinter.printMessageSOut(testString);
        testString = testString + "\n";
        
        assertEquals(out.toString(), testString);
    }

    @Test
    public void testMessagePrinterSErr() {
    	java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setErr(new java.io.PrintStream(out));

        String testString = "hello world";
        MessagePrinter.printMessageSErr(testString);
        testString = testString + "\n";
        
        assertEquals(out.toString(), testString);
    }
}
