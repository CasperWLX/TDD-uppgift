package se.reky.hakan;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IOHandlerTest
{
    private IOHandler ioHandler;

    private IOHandler testHandler(String dataForScanner){
        Scanner scanner = new Scanner(dataForScanner);
        return new IOHandler(scanner);
    }

    @DisplayName("Testing has next int")
    @Test
    void testIOHandlerHasNextInt() {
        ioHandler = testHandler("1");
        assertTrue(ioHandler.hasNextInt());
    }

    @DisplayName("Tests the next string in scanner")
    @Test
    void testNextStringInScanner(){
        ioHandler = testHandler("test");
        assertEquals("test", ioHandler.nextLine());
    }
}
