package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import model.LoginModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class LoginPage {
    private Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);
    private static final String EMAIL_INPUT = "#login-email";
    private static final String PASSWORD_INPUT = "#login-password";
    private static final String SIGNIN_BUTTON = "[name='loginForm'] button";

    public void login(LoginModel login) {
        fillForm(login);
        signIn();
    }

    public void fillForm(LoginModel login) {
        fillForm(login.getEmail(), login.getPassword());
    }

    @Step("Fill login form with email: {0}, pass: {1}")
    public void fillForm(String email, String password) {
        LOGGER.info(format("Fill form with data, email: %s, pass: %s", email, password));
        $(EMAIL_INPUT).val(email);
        $(PASSWORD_INPUT).val(password);
    }

    @Step("Click Sign in on LogIn page")
    public void signIn() {
        LOGGER.info("Click signin button");
        $(SIGNIN_BUTTON).click();
    }

    @Step("Validate email input Error text: {0}")
    public void validateEmailInputError(String error) {
        $("#login-email-error").shouldBe(Condition.text(error));
    }
}
