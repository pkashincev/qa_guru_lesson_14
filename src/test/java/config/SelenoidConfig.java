package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:credentials.properties"
})
public interface SelenoidConfig extends Config {
    @Key("selenoidLogin")
    String getSelenoidLogin();

    @Key("selenoidPassword")
    String getSelenoidPassword();
}
