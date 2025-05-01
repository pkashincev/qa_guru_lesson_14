package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PopupNotificationComponent {
    private final SelenideElement window = $(".popup_notification");
    private final SelenideElement header = $(".popup_notification .popup_notification_heading");
    private final SelenideElement message = $(".popup_notification .popup_notification_message");
    private final SelenideElement closeButton = $(".popup_notification button.mfp-close");

    public void checkThatWindowIsVisible() {
        window.shouldBe(visible);
    }

    public void checkWindowHeader(String value) {
        header.shouldHave(text(value));
    }

    public void checkWindowMessage(String value) {
        message.shouldHave(text(value));
    }

    public void close() {
        closeButton.click();
    }
}