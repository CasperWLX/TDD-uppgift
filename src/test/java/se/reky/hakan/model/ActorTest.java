package se.reky.hakan.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorTest
{
    @DisplayName("Tests if goblin can take damage")
    @Test
    void testGoblinCanTakeDamage(){
        Goblin goblin = new Goblin("Goblin", 10, 3);
        Player player1 = new Player("Player", 10, 3);

        int playerStartingHealth = player1.getHp();

        goblin.attack(player1);

        assertEquals(player1.getHp(), playerStartingHealth-goblin.getDamage());
    }

    @DisplayName("Test if player can take damage")
    @Test
    void testPlayerCanTakeDamage(){
        Goblin goblin = new Goblin("Goblin", 10, 3);
        Player player1 = new Player("Player", 10, 3);

        int goblinStartingHealth = goblin.getHp();

        player1.attack(goblin);
        assertEquals(goblin.getHp(), goblinStartingHealth-player1.getDamage());
    }
}
