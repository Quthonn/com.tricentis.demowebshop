package config;

import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Allure;
import org.openqa.selenium.Cookie;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestBaseForDeleteProduct {
    public static String COOKIEVALUE;

    public TestBaseForDeleteProduct addProductToCart() {
        Dotenv dotenv = Dotenv.load();
        COOKIEVALUE = dotenv.get("COOKIEVALUE");
        open("/Themes/DefaultClean/Content/images/logo.png");

        getWebDriver().manage().addCookie(
                new Cookie("NOPCOMMERCE.AUTH", COOKIEVALUE)
        );

        Allure.step("Добавление товаров в корзину", () -> {
            open("/");
            $$(".picture").filter(visible).get(1).scrollTo().click();
            $(".add-to-cart-button").click();
            $$(".picture").filter(visible).get(2).scrollTo().click();
            $(".add-to-cart-button").click();
        });
        return this;
    }

}
