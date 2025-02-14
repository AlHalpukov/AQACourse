package lesson001.extended.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebFormPage extends BasePage {

    public WebFormPage(WebDriver driver) {
        super(driver);
    }

    @Step("Pass in text input with {text}")
    public void fillTextInput(String text) {
        driver.findElement(By.id("my-text-id")).click();
    }

    @Step("Submit Form")
    public void submitForm() {
        WebElement submitButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        new Actions(driver)
                .moveToElement(submitButton)
                .perform();
        submitButton.click();
    }

    @Step("Get Title")
    public WebElement getTitle() {
        return driver.findElement(By.className("display-6"));
    }
}
