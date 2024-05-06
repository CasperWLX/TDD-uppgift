package se.reky.hakan.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorTest
{
    @Test
    void testActorTakeDamage(){
        Goblin goblin = new Goblin("Goblin", 10, 3);
        Player player1 = new Player("Player", 10, 3);

        goblin.attack(player1);

        assertEquals(player1.getHp(), 10-goblin.getDamage());
    }
}
