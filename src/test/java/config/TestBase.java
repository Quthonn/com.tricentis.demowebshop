package config;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Cookie;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

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

    private static String COOKIEVALUE;

    public void Login() {
        Dotenv dotenv = Dotenv.load();
        COOKIEVALUE = dotenv.get("COOKIEVALUE");
        open("/Themes/DefaultClean/Content/images/logo.png");

        getWebDriver().manage().addCookie(
                new Cookie("NOPCOMMERCE.AUTH", COOKIEVALUE)
        );
    }
}
