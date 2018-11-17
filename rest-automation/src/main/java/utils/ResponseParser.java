package utils;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class ResponseParser {

    @Step("Validate status code 200 and map json to object {1}")
    public static <T> T validateAndParse(ValidatableResponse response, Class<T> clazz) {
        return response
                .log().ifError()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract()
                .body().as(clazz);
    }
}
