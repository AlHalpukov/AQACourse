package lesson001.extended;

import io.qameta.allure.Feature;
import io.restassured.response.Response;
import lesson001.extended.controllers.UserController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static lesson001.extended.testData.Constants.DEFAULT_USER;


@Feature("SmokeApiTests")
@Tag("api")
@Tag("smoke")
public class SmokeApiTests {
    UserController userController = new UserController();

    @Test
    @DisplayName("Check create new User is returns 200 status ok")
    void createUserTest() {
        // Act
        Response response = userController.createUser(DEFAULT_USER);

        // Assert
        Assertions.assertEquals(200, response.statusCode());
    }
}
