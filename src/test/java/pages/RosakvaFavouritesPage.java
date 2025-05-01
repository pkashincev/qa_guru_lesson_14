package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RosakvaFavouritesPage {
    private final SelenideElement itemsTable = $(".table-revolution");
    private final ElementsCollection itemsNames = $(".table-revolution tbody")
            .$$("tr td.text-left");
    private final ElementsCollection itemsDeleteButtons = $(".table-revolution tbody")
            .$$(".fa-trash-o");

    @Step("Открыть избранное")
    public RosakvaFavouritesPage openPage() {
        open("/wishlist");

        return this;
    }

    @Step("Очистить избранное")
    public RosakvaFavouritesPage clearFavourites() {
        if (itemsTable.isDisplayed()) {
            int itemsCount = itemsDeleteButtons.size();
            for (int i = 0; i < itemsCount; ++i) {
                itemsDeleteButtons.first().click();
            }
        }

        return this;
    }

    @Step("Проверить наличие таблицы с товарами")
    public RosakvaFavouritesPage checkThatItemsTableIsVisible() {
        itemsTable.shouldBe(visible);
        return this;
    }

    @Step("Проверить отсутствие таблицы с товарами")
    public RosakvaFavouritesPage checkThatItemsTableIsNotVisible() {
        itemsTable.shouldNotBe(visible);
        return this;
    }

    @Step("Проверить, что в избранном есть товар с наименованием: {itemName}")
    public RosakvaFavouritesPage checkThatItemIsPresentInFavourites(String itemName) {
        itemsNames.shouldHave(itemWithText(itemName));
        return this;
    }

    @Step("Проверить, что в избранном отсутствует товар с наименованием: {itemName}")
    public RosakvaFavouritesPage checkThatItemIsNotPresentInFavourites(String itemName) {
        itemsNames.filterBy(text(itemName)).shouldHave(size(0));
        return this;
    }

    @Step("Удалить из избранного товар с наименованием: {itemName}")
    public RosakvaFavouritesPage deleteItemFromFavourites(String itemName) {
        itemsNames.findBy(text(itemName)).parent().$("td [data-original-title=Удалить]").click();
        return this;
    }
}