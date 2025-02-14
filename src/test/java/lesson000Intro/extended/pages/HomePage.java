package lesson001.extended.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java";

    public HomePage (WebDriver driver){
        super(driver);
        driver.get(BASE_URL);
    }

    @Step("Open Web Form Page")
    public WebFormPage openWebFormPage() {
        driver.findElement(By.linkText("Web form")).click();
        return new WebFormPage(driver);
    }
}
