package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.TestData;

@Feature("Корзина")
@Tag("SHOPPING_CART")
public class ShoppingCartTests extends BaseTest {

    private final TestData data = new TestData();
    private final RosakvaMainPage rosakvaMainPage = new RosakvaMainPage();
    private final RosakvaLoginPage rosakvaLoginPage = new RosakvaLoginPage();
    private final RosakvaShoppingCartPage rosakvaShoppingCartPage = new RosakvaShoppingCartPage();

    @Test
    @Story("Добавление в корзину")
    @DisplayName("Добавление единственного товара в корзину")
    public void addItemToShoppingCartTest() {
        rosakvaLoginPage.openPage()
                .setEmail(data.login)
                .setPassword(data.password)
                .submit();
        rosakvaMainPage.openPage()
                .selectCatalogCategoryByName("Питьевая вода");
        String itemName = rosakvaMainPage.addItemToCart(0);
        rosakvaMainPage.goToShoppingCart();
        rosakvaShoppingCartPage.checkThatItemsTableIsVisible()
                .checkThatItemIsPresentInShoppingCart(itemName)
                .clearCart();
    }

    @Test
    @Story("Удаление из корзины")
    @DisplayName("Удаление из корзины единственного товара")
    public void removeSingleItemFromShoppingCartTest() {
        rosakvaLoginPage.openPage()
                .setEmail(data.login)
                .setPassword(data.password)
                .submit();
        rosakvaMainPage.openPage()
                .selectCatalogCategoryByName("Питьевая вода");
        String itemName = rosakvaMainPage.addItemToCart(0);
        rosakvaMainPage.goToShoppingCart();
        rosakvaShoppingCartPage.deleteItemFromShoppingCart(itemName)
                .checkThatItemsTableIsNotVisible();
    }

    @Test
    @Story("Удаление из корзины")
    @DisplayName("Удаление из корзины одного из товаров")
    public void removeOneOfItemsFromShoppingCartTest() {
        rosakvaLoginPage.openPage()
                .setEmail(data.login)
                .setPassword(data.password)
                .submit();
        rosakvaMainPage.openPage()
                .selectCatalogCategoryByName("Питьевая вода");
        String firstItemName = rosakvaMainPage.addItemToCart(0);
        String secondItemName = rosakvaMainPage.addItemToCart(1);
        rosakvaMainPage.goToShoppingCart();
        rosakvaShoppingCartPage.deleteItemFromShoppingCart(firstItemName)
                .checkThatItemsTableIsVisible()
                .checkThatItemIsNotPresentInShoppingCart(firstItemName)
                .checkThatItemIsPresentInShoppingCart(secondItemName)
                .clearCart();
    }
}