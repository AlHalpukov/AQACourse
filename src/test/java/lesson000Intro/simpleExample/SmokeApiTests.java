package lesson000Intro.simpleExample;

import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SmokeApiTests {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    @Test
    void checkCreateUser() {
        // given (config) -> when (http) -> then (assert)

        // Arrange
        Header contentTypeHeader = new Header("Content-Type", "application/json");
        String bodyJson = """
                {
                  "id": 0,
                  "username": "string",
                  "firstName": "string",
                  "lastName": "string",
                  "email": "string",
                  "password": "string",
                  "phone": "string",
                  "userStatus": 0
                }
                """;
        String url = BASE_URL + "/user";

        // Act
        ValidatableResponse response = given()
                .header("accept", "application/json")
                .header(contentTypeHeader)
                .body(bodyJson)
                .when()
                .post(url)
                .then();

        // Assert
        // by RestAssured
        response.statusCode(200);
        response.body("code", Matchers.equalTo(200));
        response.body("type", Matchers.equalTo("unknown"));
        response.body("message", Matchers.notNullValue(String.class));

        // Можно вот так
        Response responseAsResponse = response.extract().response();
        responseAsResponse.prettyPrint();
        // или вот так (цепочка вызовов методов)
        response.extract().response().prettyPrint();

        // by JUnit
        Assertions.assertEquals(200, responseAsResponse.statusCode());
    }
}
