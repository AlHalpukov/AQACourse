package lesson000Intro.simpleExample;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SmokeUITests {
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java";
    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Check if form submitted if entered one title")
    void checkSubmitForm(){
        driver.get(BASE_URL);
        driver.findElement(By.linkText("Web form")).click();
        driver.findElement(By.id("my-text-id")).sendKeys("Test Title");

        WebElement submitButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        new Actions(driver)
                .moveToElement(submitButton)
                .perform();
        submitButton.click();
//        Thread.sleep(3000);
        // Это не сработало
        // Не отработало потому, что элемент на котором должен сработать метод click()
        // должен быть видимым на экране, для этого был добавлен сверху
//        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        // А вот это сработало
//        driver.findElement(By.xpath("//button[@type = 'submit']")).submit();
        WebElement submitTitle = driver.findElement(By.className("display-6"));

        Assertions.assertEquals("Form submitted", submitTitle.getText());
    }
}
