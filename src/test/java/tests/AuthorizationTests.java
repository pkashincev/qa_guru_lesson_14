package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RosakvaAccountPage;
import pages.RosakvaLoginPage;
import utils.TestData;

@Feature("Авторизация")
@Tag("AUTHORIZATION")
public class AuthorizationTests extends BaseTest {

    private final RosakvaLoginPage rosakvaLoginPage = new RosakvaLoginPage();
    private final RosakvaAccountPage rosakvaAccountPage = new RosakvaAccountPage();
    private final TestData data = new TestData();

    @Test
    @Story("Вход в аккаунт")
    @DisplayName("Успешная авторизация")
    public void successfulAuthorizationTest() {
        rosakvaLoginPage.openPage()
                .setEmail(data.login)
                .setPassword(data.password)
                .submit();
        rosakvaAccountPage.checkHeader("Личный кабинет")
                .checkCentralPanelActions("Мой аккаунт", "Мои закладки", "Мои заказы")
                .checkRightPanelActions("Мой аккаунт", "Мои закладки", "Мои заказы", "Выход");
    }

    @Test
    @Story("Вход в аккаунт")
    @DisplayName("Неуспешная авторизация")
    public void unsuccessfulAuthorizationTest() {
        rosakvaLoginPage.openPage()
                .setEmail(data.randomLogin)
                .setPassword(data.randomPassword)
                .submit()
                .checkHeader("Авторизация")
                .checkErrorMessage("Неправильно заполнены поля E-Mail и/или пароль!")
                .checkRightPanelActions("Авторизация", "Регистрация", "Восстановить пароль");
    }

    @Test
    @Story("Выход из аккаунта")
    @DisplayName("Выход из аккаунта")
    public void exitFromAccountTest() {
        rosakvaLoginPage.openPage()
                .setEmail(data.login)
                .setPassword(data.password)
                .submit();
        rosakvaAccountPage.exit()
                .checkHeader("Выход")
                .checkRightPanelActions("Авторизация", "Регистрация", "Восстановить пароль");
    }
}