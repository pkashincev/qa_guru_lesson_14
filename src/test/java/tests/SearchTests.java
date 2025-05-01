package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.RosakvaMainPage;

@Feature("Поиск товаров")
@Tag("SEARCH")
public class SearchTests extends BaseTest {

    private final RosakvaMainPage rosakvaMainPage = new RosakvaMainPage();

    @Story("Поиск на главной странице")
    @ValueSource(strings = {
            "вода", "кулер", "помпа"
    })
    @ParameterizedTest(name = "Поиск товаров по ключевому слову {0}")
    public void searchOnMainPageTest(String searchQuery) {
        rosakvaMainPage.openPage()
                .search(searchQuery)
                .checkHeader("Поиск - " + searchQuery)
                .checkContentSearchInputValue(searchQuery)
                .checkThatNumberOfFoundedItemsIsNonZero();
    }
}