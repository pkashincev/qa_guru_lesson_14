package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:local.properties"
})

public interface BrowserConfig extends Config {

    @Key("browser")
    String getBrowser();

    @Key("browser.version")
    String getBrowserVersion();

    @Key("browser.size")
    String getBrowserSize();

    @Key("remote")
    boolean isRemote();

    @Key("base.url")
    String getBaseUrl();

    @Key("remote.host")
    String getRemoteHost();
}