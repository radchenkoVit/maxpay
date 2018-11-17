package rest;

import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static utils.PropertyLoader.getProperty;

public class Runner {

    @BeforeSuite
    public void beforeAll() {
        RestAssured.baseURI = getProperty("url");
    }


    @AfterSuite
    public void afterAll() {
    }
}
