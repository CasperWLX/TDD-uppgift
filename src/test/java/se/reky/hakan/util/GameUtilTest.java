package se.reky.hakan.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.reky.hakan.GameException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameUtilTest
{
    private GameUtil gameUtil;

    @BeforeEach
    void init(){
        gameUtil = new GameUtil();
    }

    @DisplayName("Tests exception when input is null")
    @Test
    void testExceptionIsThrownWhenInputIsNull(){
        assertThrows(GameException.class, () -> gameUtil.toLowerCaseButFirstLetterCapitalized(null));
    }

    @DisplayName("Test exception when input is empty")
    @Test
    void testExceptionIsThrownWhenInputIsEmpty() {
        assertThrows(GameException.class, () -> gameUtil.toLowerCaseButFirstLetterCapitalized(""));
    }
}
