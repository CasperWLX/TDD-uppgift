package se.reky.hakan;


import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    void init(){
        playerInteraction = playerTestSetUp("player");
        playerInteraction.setupPlayer(player);
    }

    @DisplayName("Testing player is setup correctly")
    @Test
    void testSetUpPlayer() {
        assertEquals("player", player.getName());
    }

    @DisplayName("Testing player HP can be updated")
    @Test
    void testUpdatePlayerHP(){
        playerInteraction.updatePlayerHealth(player, 20);

        assertEquals(30, player.getHp());
    }
}
