package controllers;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.String.format;

public abstract class AbstractController {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    @Step("Do Get with id: {0}")
    public ValidatableResponse doGet(Long id) {
        LOGGER.info(format("Get Calling %s controller with id: %s", this.getClass().getName(), id));
        return RestAssured.given()
                .log().all()
                .pathParam("id", id)
                .get(getStringUrl())
                .then();
    }

    @Step("Do Get with by uri: {0}")
    public ValidatableResponse doGet(String uri) {
        LOGGER.info(format("Get Calling %s controller with id: %s", this.getClass().getName(), uri));
        return RestAssured.given().baseUri(uri)
                .log().all()
                .get()
                .then();
    }

    public abstract String getStringUrl();
}
