package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.TestData;

@Feature("Избранное")
@Tag("FAVOURITES")
public class FavouritesTests extends BaseTest {

    private final TestData data = new TestData();
    private final RosakvaMainPage rosakvaMainPage = new RosakvaMainPage();
    private final RosakvaLoginPage rosakvaLoginPage = new RosakvaLoginPage();
    private final RosakvaFavouritesPage rosakvaFavouritesPage = new RosakvaFavouritesPage();

    @Test
    @Story("Добавление в избранное")
    @DisplayName("Проверка оповещения при добавлении товара в избранное")
    public void checkNotificationWindowWhenAddingItemToFavourites() {
        rosakvaLoginPage.openPage()
                .setEmail(data.login)
                .setPassword(data.password)
                .submit();
        rosakvaMainPage.openPage()
                .selectCatalogCategoryByName("Питьевая вода");
        String itemName = rosakvaMainPage.addItemToFavourites(0);
        rosakvaMainPage.checkThatPopupWindowIsVisible()
                .checkPopupWindowHeader("Мои закладки")
                .checkPopupWindowMessage("Товар " + itemName + " добавлен в закладки!")
                .closePopupWindow();
        rosakvaFavouritesPage.openPage().
                clearFavourites();
    }

    @Test
    @Story("Добавление в избранное")
    @DisplayName("Добавление единственного товара в избранное")
    public void addItemToFavouritesTest() {
        rosakvaLoginPage.openPage()
                .setEmail(data.login)
                .setPassword(data.password)
                .submit();
        rosakvaMainPage.openPage()
                .selectCatalogCategoryByName("Питьевая вода");
        String itemName = rosakvaMainPage.addItemToFavourites(0);
        rosakvaMainPage.closePopupWindow()
                .goToFavourites();
        rosakvaFavouritesPage.checkThatItemsTableIsVisible()
                .checkThatItemIsPresentInFavourites(itemName)
                .clearFavourites();
    }

    @Test
    @Story("Удаление из избранного")
    @DisplayName("Удаление из избранного единственного товара")
    public void removeSingleItemFromFavouritesTest() {
        rosakvaLoginPage.openPage()
                .setEmail(data.login)
                .setPassword(data.password)
                .submit();
        rosakvaMainPage.openPage()
                .selectCatalogCategoryByName("Питьевая вода");
        String itemName = rosakvaMainPage.addItemToFavourites(0);
        rosakvaMainPage.closePopupWindow()
                .goToFavourites();
        rosakvaFavouritesPage.deleteItemFromFavourites(itemName)
                .checkThatItemsTableIsNotVisible();
    }

    @Test
    @Story("Удаление из избранного")
    @DisplayName("Удаление из избранного одного из товаров")
    public void removeOneOfItemsFromFavouritesTest() {
        rosakvaLoginPage.openPage()
                .setEmail(data.login)
                .setPassword(data.password)
                .submit();
        rosakvaMainPage.openPage()
                .selectCatalogCategoryByName("Питьевая вода");
        String firstItemName = rosakvaMainPage.addItemToFavourites(0);
        rosakvaMainPage.closePopupWindow();
        String secondItemName = rosakvaMainPage.addItemToFavourites(1);
        rosakvaMainPage.closePopupWindow();
        rosakvaMainPage.goToFavourites();
        rosakvaFavouritesPage.deleteItemFromFavourites(firstItemName)
                .checkThatItemsTableIsVisible()
                .checkThatItemIsNotPresentInFavourites(firstItemName)
                .checkThatItemIsPresentInFavourites(secondItemName)
                .clearFavourites();
    }
}