package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.ContentHeaderComponent;
import pages.components.RightPanelActionsComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RosakvaLoginPage {

    private final SelenideElement inputEmail = $("#input-email");
    private final SelenideElement inputPassword = $("#input-password");
    private final SelenideElement submitButton = $(".form-group input.btn-primary");
    private final SelenideElement errorMessage = $(".alert-danger");
    private final ContentHeaderComponent header = new ContentHeaderComponent();
    private final RightPanelActionsComponent rightPanelActions = new RightPanelActionsComponent();

    @Step("Открыть страницу авторизации")
    public RosakvaLoginPage openPage() {
        open("/login");

        return this;
    }

    @Step("Ввести email: {value}")
    public RosakvaLoginPage setEmail(String value) {
        inputEmail.setValue(value);

        return this;
    }

    @Step("Ввести password: {value}")
    public RosakvaLoginPage setPassword(String value) {
        inputPassword.setValue(value);

        return this;
    }

    @Step("Передать введенные данные")
    public RosakvaLoginPage submit() {
        submitButton.click();

        return this;
    }

    @Step("Проверить, что заголовок имеет значение: {value}")
    public RosakvaLoginPage checkHeader(String value) {
        header.checkContentHeader(value);

        return this;
    }

    @Step("Проверить cписок доступных действий на боковой панели: {actions}")
    public RosakvaLoginPage checkRightPanelActions(String... actions) {
        rightPanelActions.checkAvailableActions(actions);

        return this;
    }

    @Step("Проверить, что на странице есть сообщение о неуспешной авторизации: {message}")
    public RosakvaLoginPage checkErrorMessage(String message) {
        errorMessage.shouldHave(text(message));

        return this;
    }
}