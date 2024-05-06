package se.reky.hakan;


import org.junit.jupiter.api.Test;
import se.reky.hakan.model.Goblin;
import se.reky.hakan.model.Player;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimplePlayerInteractionTest
{
    private Player player;
    private PlayerInteraction playerInteraction;

    private PlayerInteraction playerTestSetUp(String dataForScanner){
        Scanner scanner = new Scanner(dataForScanner);
        IOHandler ioHandler = new IOHandler(scanner);
        player = new Player();
        return new SimplePlayerInteraction(ioHandler);
    }

    @Test
    void testSetUpPlayer() {
        playerInteraction = playerTestSetUp("player1");
        playerInteraction.setupPlayer(player);

        assertEquals("player1", player.getName());
    }

    @Test
    void testUpdatePlayerHP(){
        playerInteraction = playerTestSetUp("player2");
        playerInteraction.setupPlayer(player);
        playerInteraction.updatePlayerHealth(player, 20);

        assertEquals(30, player.getHp());
    }
}
