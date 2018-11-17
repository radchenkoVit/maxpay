package ui;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static utils.PropertyLoader.getProperty;

public class Runner {
    @BeforeMethod
    public void beforeEach() {
        Selenide.open(getProperty("url"));
    }


    @AfterMethod
    public void afterEach() {
    }
}
