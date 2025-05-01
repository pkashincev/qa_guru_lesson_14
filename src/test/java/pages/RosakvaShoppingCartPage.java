package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RosakvaShoppingCartPage {
    private final SelenideElement itemsTable = $(".revcart_table");
    private final ElementsCollection itemsNames = $(".revcart_table tbody").$$("tr td.name");
    private final ElementsCollection itemsDeleteButtons = $(".revcart_table tbody").$$("tr td.delete .fa-trash-o");

    @Step("Открыть корзину")
    public RosakvaShoppingCartPage openPage() {
        open("/checkout");

        return this;
    }

    @Step("Очистить корзину")
    public RosakvaShoppingCartPage clearCart() {
        while (itemsTable.isDisplayed()) {
            itemsDeleteButtons.first().click();
            sleep(1000);
        }

        return this;
    }

    @Step("Проверить наличие таблицы с товарами")
    public RosakvaShoppingCartPage checkThatItemsTableIsVisible() {
        itemsTable.shouldBe(visible);
        return this;
    }

    @Step("Проверить отсутствие таблицы с товарами")
    public RosakvaShoppingCartPage checkThatItemsTableIsNotVisible() {
        itemsTable.shouldNotBe(visible);
        return this;
    }

    @Step("Проверить, что в корзине есть товар с наименованием: {itemName}")
    public RosakvaShoppingCartPage checkThatItemIsPresentInShoppingCart(String itemName) {
        itemsNames.shouldHave(itemWithText(itemName));
        return this;
    }

    @Step("Проверить, что в корзине отсутствует товар с наименованием: {itemName}")
    public RosakvaShoppingCartPage checkThatItemIsNotPresentInShoppingCart(String itemName) {
        itemsNames.filterBy(text(itemName)).shouldHave(size(0));
        return this;
    }

    @Step("Удалить из корзины товар с наименованием: {itemName}")
    public RosakvaShoppingCartPage deleteItemFromShoppingCart(String itemName) {
        itemsNames.findBy(text(itemName)).parent().$("td.delete").click();
        return this;
    }
}