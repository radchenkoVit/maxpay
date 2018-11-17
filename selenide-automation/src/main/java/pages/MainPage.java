package pages;

import com.codeborne.selenide.ex.ElementNotFound;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static utils.WaitingTime.SEVEN_SECONDS;

public class MainPage {
    private static final String SIDE_BAR = ".sidebar-content";

    public boolean isOnPage() {
        try {
            return $(SIDE_BAR).waitUntil(visible, SEVEN_SECONDS).isDisplayed();
        } catch (ElementNotFound e) {
            return false;
        }
    }
}
