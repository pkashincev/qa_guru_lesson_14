package utils;

import com.github.javafaker.Faker;
import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;

import java.util.*;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class TestData {

    private final Faker faker = new Faker(new Locale("en-GB"));
    private final CredentialsConfig credentialsConfig = ConfigFactory.create(CredentialsConfig.class, System.getProperties());

    public final String randomLogin = faker.internet().emailAddress();
    public final String randomPassword = randomAlphanumeric(10);
    public final String login = credentialsConfig.getLogin();
    public final String password = credentialsConfig.getPassword();
}