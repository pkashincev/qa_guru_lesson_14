package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static helpers.Attach.attachAsText;

public class ConfigApplier {
    private final BrowserConfig config;
    private final SelenoidConfig selenoidConfig = ConfigFactory.create(SelenoidConfig.class, System.getProperties());

    public ConfigApplier() {
        this.config = ConfigFactory.create(BrowserConfig.class, System.getProperties());
    }

    public void applyConfig() {
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.baseUrl = config.getBaseUrl();
        if (config.isRemote()) {
            Configuration.remote = "https://" + selenoidConfig.getSelenoidLogin() + ":" + selenoidConfig.getSelenoidPassword()
                    + "@" + config.getRemoteHost() + "/wd/hub";
            Configuration.browserCapabilities = new DesiredCapabilities();
            Configuration.browserCapabilities.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
        }
        Configuration.pageLoadStrategy = "eager";
        attachAppliedConfiguration();
    }

    private void attachAppliedConfiguration() {
        attachAsText("Applied configuration:",
                "\nbrowser = " + Configuration.browser +
                        "\nbrowser.version = " + Configuration.browserVersion +
                        "\nbrowser.size = " + Configuration.browserSize +
                        "\nbaseUrl = " + Configuration.baseUrl +
                        "\nremoteUrl = " + Configuration.remote);
    }
}