package lesson001.extended;

import io.qameta.allure.Feature;
import lesson001.extended.pages.HomePage;
import lesson001.extended.pages.WebFormPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@Feature("SmokeApiTests")
@Tag("ui")
@Tag("smoke")
public class SmokeUITests {
    HomePage homePage;

    @BeforeEach
    void setup() {
        homePage = new HomePage(new ChromeDriver());
    }

    @AfterEach
    void tearDown() {
        homePage.quit();
    }

    @Test
    @DisplayName("Check Form submitted and has Title")
    void submitWebFormTest() {
        WebFormPage webFormPage = homePage.openWebFormPage();

        webFormPage.fillTextInput("Test Text");
        webFormPage.submitForm();
        WebElement title = webFormPage.getTitle();

        Assertions.assertEquals("Form submitted", title.getText());
    }
}
