package config;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    public static String MAIL;
    public static String PASSWORD;

    @BeforeAll
    public static void BeforeAll() {
        Dotenv dotenv = Dotenv.load();
        MAIL = dotenv.get("MAIL");
        PASSWORD = dotenv.get("PASSWORD");

        Configuration.baseUrl = "https://demowebshop.tricentis.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = System.getProperty("browserSize",
                "1920x1080");
    }

    @AfterEach
    public void AfterEach() {
        open("/logout");
    }


}
