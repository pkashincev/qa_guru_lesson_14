package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ContentHeaderComponent {
    private final SelenideElement header = $(".main-content .inbreadcrumb");

    public void checkContentHeader(String value) {
        header.shouldHave(text(value));
    }
}