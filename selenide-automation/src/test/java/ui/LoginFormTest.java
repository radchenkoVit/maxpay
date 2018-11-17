package ui;

import model.LoginModel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginFormTest extends Runner {
    private LoginPage loginPage = new LoginPage();
    private MainPage mainPage = new MainPage();
    private LoginModel validLogin = LoginModel.builder().email("qa+test+user@maxpay.com").password("21TSeWbq").build();


    @DataProvider(name = "testLoginForm")
    public static Object[][] getLoginData() {
        return new Object[][]{
                {"email@email", "pass"},
                {"", "pass"}};
    }

    @Test(dataProvider = "testLoginForm")
    public void negativeTestCase(String email, String password) {
        loginPage.fillForm(email, password);
        loginPage.signIn();
        assertThat("User is logged in", !mainPage.isOnPage());
    }


    @Test
    public void validateEmailInputError() {
        loginPage.fillForm("dummnyEmail@email", "pass");
        loginPage.signIn();
        loginPage.validateEmailInputError("Please enter a valid email address.");
    }

    @Test
    public void positiveTestCase() {
        loginPage.login(validLogin);
        assertThat("User is not logged in", mainPage.isOnPage());
    }
}
