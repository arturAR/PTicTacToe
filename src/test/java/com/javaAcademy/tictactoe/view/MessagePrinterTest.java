package com.javaAcademy.tictactoe.view;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.javaAcademy.tictactoe.io.outputImpl.ConsolePrinter;

public class MessagePrinterTest {

    @Test
    public void testMessagePrinterSOut() {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        String testString = "hello world";
        ConsolePrinter.printMessageSOutLn(testString);
        testString = testString + "\n";
        
        assertEquals(out.toString(), testString);
    }

    @Test
    public void testMessagePrinterSErr() {
    	java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setErr(new java.io.PrintStream(out));

        String testString = "hello world";
        ConsolePrinter.printMessageSErr(testString);
        testString = testString + "\n";
        
        assertEquals(out.toString(), testString);
    }
}
