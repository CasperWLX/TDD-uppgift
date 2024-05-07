package se.reky.hakan.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
public class PlayerControllerTest {
    static ChromeDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/players");
    }

    @AfterEach
    void tearDown() {
        if(driver != null){
            driver.quit();
        }
    }

    @DisplayName("Testing 2 players shown")
    @Test
    void correctAmountOfPlayersAreShown(){
        List<WebElement> listOfPlayers = driver.findElements(By.tagName("li"));

        assertEquals(2, listOfPlayers.size());
    }

    @DisplayName("Tests if first player name is displayed")
    @Test
    void firstPlayerNameIsDisplayed(){
        WebElement firstElement = driver.findElement(By.className("player-name"));

        assertTrue(firstElement.isDisplayed());
    }

    @DisplayName("Tests if website title is correct")
    @Test
    void testWebsiteTitleIsCorrect(){
        assertEquals("Players List", driver.getTitle());
    }

    @DisplayName("Tests if button has correct text")
    @Test
    void testButtonHasCorrectText(){
        WebElement button = driver.findElement(By.tagName("button"));

        assertEquals("Logga in", button.getText());
    }

    @DisplayName("Tests if new endpoint works")
    @Test
    void testNavigationToNewEndpoint(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement firstPlayer = driver.findElement(By.className("player-name"));

        firstPlayer.click();

        WebElement playerName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("player-name")));

        assertTrue(playerName.isDisplayed());
    }
}

