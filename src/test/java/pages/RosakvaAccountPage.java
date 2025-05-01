package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.ContentHeaderComponent;
import pages.components.RightPanelActionsComponent;

import static com.codeborne.selenide.CollectionCondition.exactTextsCaseSensitiveInAnyOrder;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RosakvaAccountPage {
    private final ElementsCollection centralPanelActions = $$("#content li a");
    private final SelenideElement exitAction = $("#column-right").$(byText("Выход"));
    private final RightPanelActionsComponent rightPanelActions = new RightPanelActionsComponent();
    private final ContentHeaderComponent header = new ContentHeaderComponent();

    @Step("Проверить, что заголовок имеет значение: {value}")
    public RosakvaAccountPage checkHeader(String value) {
        header.checkContentHeader(value);

        return this;
    }

    @Step("Проверить cписок доступных действий на центральной панели: {actions}")
    public RosakvaAccountPage checkCentralPanelActions(String... actions) {
        centralPanelActions.shouldHave(exactTextsCaseSensitiveInAnyOrder(actions));

        return this;
    }

    @Step("Проверить cписок доступных действий на боковой панели: {actions}")
    public RosakvaAccountPage checkRightPanelActions(String... actions) {
        rightPanelActions.checkAvailableActions(actions);

        return this;
    }

    @Step("Выйти из аккаунта")
    public RosakvaAccountPage exit() {
        exitAction.click();

        return this;
    }
}