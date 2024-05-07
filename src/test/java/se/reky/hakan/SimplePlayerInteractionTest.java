package se.reky.hakan;


import org.junit.jupiter.api.DisplayName;
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
        player = new Player();
        return new SimplePlayerInteraction(new IOHandler(new Scanner(dataForScanner)));
    }

    @DisplayName("Testing player is setup correctly")
    @Test
    void testSetUpPlayer() {
        playerInteraction = playerTestSetUp("player1");
        playerInteraction.setupPlayer(player);

        assertEquals("player1", player.getName());
    }

    @DisplayName("Testing player HP can be updated")
    @Test
    void testUpdatePlayerHP(){
        playerInteraction = playerTestSetUp("player2");
        playerInteraction.setupPlayer(player);
        playerInteraction.updatePlayerHealth(player, 20);

        assertEquals(30, player.getHp());
    }
}
