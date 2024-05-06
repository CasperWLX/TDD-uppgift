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
    }

    @AfterEach
    void tearDown() {
        if(driver != null){
            driver.quit();
        }
    }


    @Test
    void correctAmountOfPlayersAreShown(){
        driver.get("http://localhost:8080/players");

        List<WebElement> listOfPlayers = driver.findElements(By.tagName("li"));

        assertEquals(2, listOfPlayers.size());
    }

    @Test
    void firstPlayerNameIsDisplayed(){
        driver.get("http://localhost:8080/players");
        WebElement firstElement = driver.findElement(By.className("player-name"));

        assertTrue(firstElement.isDisplayed());
    }

    @Test
    void testWebsiteTitleIsCorrect(){
        driver.get("http://localhost:8080/players");

        assertEquals("Players List", driver.getTitle());
    }

    @Test
    void testButtonHasCorrectText(){
        driver.get("http://localhost:8080/players");
        WebElement button = driver.findElement(By.tagName("button"));

        assertEquals("Logga in", button.getText());
    }

    @Test
    void testNewEndpoint(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("http://localhost:8080/players");

        WebElement firstPlayer = driver.findElement(By.className("player-name"));

        firstPlayer.click();

        WebElement playerName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("player-name")));

        assertTrue(playerName.isDisplayed());

    }
}
