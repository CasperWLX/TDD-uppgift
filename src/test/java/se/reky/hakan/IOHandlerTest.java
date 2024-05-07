package se.reky.hakan;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class IOHandlerTest
{
    private IOHandler ioHandler;

    private IOHandler testHandler(String dataForScanner){
        return new IOHandler(new Scanner(dataForScanner));
    }

    @DisplayName("Testing has next int")
    @Test
    void testIOHandlerHasNextInt() {
        ioHandler = testHandler("1");
        assertTrue(ioHandler.hasNextInt());
    }

    @DisplayName("Tests the next string in ioHandler")
    @Test
    void testNextStringInIOHandler(){
        ioHandler = testHandler("test");
        assertEquals("test", ioHandler.nextLine());
    }

    @DisplayName("Test if scanner has something inside it")
    @Test
    void testNextStringInScanner() {
        assertTrue(new Scanner("1").hasNext());
    }

    @DisplayName("Test if scanner.nextLine is a string")
    @Test
    void testNextLineIsAString(){
        assertInstanceOf(String.class, new Scanner("Test").nextLine());
    }
}
