package uiTests;

import config.TestBase;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import pages.DeleteProductToCartPage;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

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

//        TestBaseForDeleteProductTest.addToCartTestCall();
    }

    DeleteProductToCartPage deleteProductToCartPage = new DeleteProductToCartPage();

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
        deleteProductToCartPage.openSite()
                .goToCart()
                .selectAllProducts()
                .clickButtonUpdateCart()
                .checkResult();

    }
}
