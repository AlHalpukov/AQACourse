package lesson001.extended.controllers;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lesson001.extended.models.User;

import static io.restassured.RestAssured.given;

public class UserController {
    RequestSpecification requestSpecification = given();
    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    public UserController() {
        RestAssured.defaultParser = Parser.JSON;
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.baseUri(BASE_URL);
        requestSpecification.filter(new AllureRestAssured());
    }

    @Step("Create User")
    public Response createUser(User user) {
        requestSpecification.body(user);
        return given(requestSpecification).post("/user").andReturn();
    }
}
