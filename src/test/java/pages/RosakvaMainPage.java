package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.ContentHeaderComponent;
import pages.components.PopupNotificationComponent;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RosakvaMainPage {

    private final SelenideElement mainSearchInput = $(".bigsearch input[name=search]");
    private final SelenideElement contentSearchInput = $("#content #input-search");
    private final ElementsCollection foundedItemsNames = $("#content")
            .$$(".product-layout .product-info [itemprop=name]");
    private final ElementsCollection foundedItemsAddToCartButtons = $("#content")
            .$$(".product-layout .product_buttons .cart");
    private final ElementsCollection foundedItemsAddToFavouritesButtons = $("#content")
            .$$(".product-layout .product_buttons .wishlist");
    private final SelenideElement shoppingCart = $("#cart");
    private final SelenideElement favourites = $("#wishlist-total");
    private final SelenideElement catalogButton = $("#top3 #menu2_button");
    private final ElementsCollection catalogCategories = $$("#menu2 .menu2categories");
    private final ContentHeaderComponent header = new ContentHeaderComponent();
    private final PopupNotificationComponent popupWindow = new PopupNotificationComponent();

    @Step("Открыть главную страницу")
    public RosakvaMainPage openPage() {
        open("/");

        return this;
    }

    @Step("Выполнить поиск по ключевому слову: {searchQuery}")
    public RosakvaMainPage search(String searchQuery) {
        mainSearchInput.click();
        mainSearchInput.setValue(searchQuery).pressEnter();

        return this;
    }

    @Step("Проверить, что заголовок имеет значение: {value}")
    public RosakvaMainPage checkHeader(String value) {
        header.checkContentHeader(value);

        return this;
    }

    @Step("Проверить, что поисковое поле в критериях поиска заполнено значением: {expected}")
    public RosakvaMainPage checkContentSearchInputValue(String expected) {
        assertThat(contentSearchInput.getAttribute("value")).isEqualTo(expected);

        return this;
    }

    @Step("Проверить, что результаты поиска содержат хотя бы 1 элемент")
    public RosakvaMainPage checkThatNumberOfFoundedItemsIsNonZero() {
        foundedItemsNames.shouldHave(sizeGreaterThan(0));

        return this;
    }

    @Step("Выбрать в каталоге категорию: {name}")
    public RosakvaMainPage selectCatalogCategoryByName(String name) {
        catalogButton.click();
        catalogCategories.findBy(text(name)).click();
        return this;
    }

    @Step("Добавить товар №{index} в корзину")
    public String addItemToCart(int index) {
        foundedItemsAddToCartButtons.get(index).click();

        return foundedItemsNames.get(index).getText();
    }

    @Step("Добавить товар №{index} в избранное")
    public String addItemToFavourites(int index) {
        foundedItemsAddToFavouritesButtons.get(index).click();

        return foundedItemsNames.get(index).getText();
    }

    @Step("Перейти в корзину")
    public RosakvaMainPage goToShoppingCart() {
        shoppingCart.click();

        return this;
    }

    @Step("Перейти в избранное")
    public RosakvaMainPage goToFavourites() {
        favourites.click();

        return this;
    }

    @Step("Проверить наличие окна с оповещением")
    public RosakvaMainPage checkThatPopupWindowIsVisible() {
        popupWindow.checkThatWindowIsVisible();

        return this;
    }

    @Step("Проверить, что окно с оповещением имеет заголовок: {header}")
    public RosakvaMainPage checkPopupWindowHeader(String header) {
        popupWindow.checkWindowHeader(header);

        return this;
    }

    @Step("Проверить, что окно с оповещением имеет содержит текст: {message}")
    public RosakvaMainPage checkPopupWindowMessage(String message) {
        popupWindow.checkWindowMessage(message);

        return this;
    }

    @Step("Закрыть окно с оповещением")
    public RosakvaMainPage closePopupWindow() {
        popupWindow.close();

        return this;
    }
}