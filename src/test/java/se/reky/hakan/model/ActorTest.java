package se.reky.hakan.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorTest
{
    private Goblin goblin;
    private Player player;

    @BeforeEach
    void init(){
        goblin = new Goblin("Goblin", 10, 3);
        player = new Player("Player", 10, 3);
    }

    @DisplayName("Tests if goblin can take damage")
    @Test
    void testGoblinCanTakeDamage(){
        int playerStartingHealth = player.getHp();

        goblin.attack(player);

        assertEquals(player.getHp(), playerStartingHealth-goblin.getDamage());
    }

    @DisplayName("Test if player can take damage")
    @Test
    void testPlayerCanTakeDamage(){
        int goblinStartingHealth = goblin.getHp();

        player.attack(goblin);
        assertEquals(goblin.getHp(), goblinStartingHealth-player.getDamage());
    }
}
