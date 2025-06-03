package uiTests;

import config.TestBase;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteProductInCart extends TestBase {
    private static String COOKIEVALUE;

    @BeforeEach
    public void BeforeEach() {
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

        Allure.step("Д", () -> {

        });
//        TestBaseForDeleteProductTest.addToCartTestCall();
    }

    @Test
    @Feature("Тестирование удаления товаров из корзины")
    @Story("Пользователь удаляет товары из корзины")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Positive")
    @DisplayName("Тест удаления товаров")
    @Owner("Quthon")
    @Description("Этот тест проверяет, что пользователь может удалить " +
            "товары из корзины.")
    public void delete() {
        Allure.step("Открытие сайта", () -> {
            open("/");
        });

        Allure.step("Вход в корзину", () -> {
            $("#topcartlink").click();
        });

        Allure.step("Выделение всех товаров по CheckBox предусмотренных для удаления", () -> {
            $$("[type=checkbox]").forEach(checkbox -> checkbox.click());
        });

        Allure.step("Нажать кнопку обновления корзины", () -> {
            $(".update-cart-button").click();
        });

        Allure.step("Проверка стала ли корзина пустой после удаления всех товаров", () -> {
            String textInCart = $(".order-summary-content").getText();
            System.out.println(textInCart);

            assertEquals("Your Shopping Cart is empty!", textInCart);
        });
    }
}
