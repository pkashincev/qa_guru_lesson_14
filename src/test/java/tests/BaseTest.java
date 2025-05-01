package tests;

import com.codeborne.selenide.Configuration;
import config.ConfigApplier;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeAll
    static void setConfig() {
        ConfigApplier configApplier = new ConfigApplier();
        configApplier.applyConfig();
    }

    @BeforeEach
    void addAllureListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachmentsAndClose() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        if (!Configuration.browser.equals("firefox"))
            Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}