package pages.components;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.exactTextsCaseSensitiveInAnyOrder;
import static com.codeborne.selenide.Selenide.$;

public class RightPanelActionsComponent {
    private final ElementsCollection rightPanelActions = $("#column-right").$$(".list-group-item");

    public void checkAvailableActions(String... actions) {
        rightPanelActions.shouldHave(exactTextsCaseSensitiveInAnyOrder(actions));
    }
}