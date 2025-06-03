package uiTests;

import config.TestBase;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Cookie;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddProductInCart extends TestBase {
    private static String COOKIEVALUE;

    @BeforeEach
    public void BeforeEach() {
        Dotenv dotenv = Dotenv.load();
        COOKIEVALUE = dotenv.get("COOKIEVALUE");
        open("/Themes/DefaultClean/Content/images/logo.png");

        getWebDriver().manage().addCookie(
                new Cookie("NOPCOMMERCE.AUTH", COOKIEVALUE)
        );
    }

    @Test
    @Feature("Тестирование добавления товара в корзину")
    @Story("Пользователь добавляет товар в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Positive")
    @DisplayName("Тест добавления товара")
    @Owner("Quthon")
    @Description("Этот тест проверяет, что пользователь может добавить " +
            "товар в корзину.")
    public void search() {
        Allure.step("Открытие сайта", () -> {
            open("/");
        });

        Allure.step("Переход на страницу товара", () -> {
            $$(".picture").filter(visible).get(1).scrollTo().click();
            String ProductName = $(".product-name").getText();
            System.out.println("Название товара: " + ProductName);
        });

        Allure.step("Нажать 'Добавить в корзину'", () -> {
            $(".add-to-cart-button").click();

        });

        Allure.step("Проверка добавлен ли товар в корзину", () -> {
            String notificationMessage = $(".bar-notification").shouldBe(visible).getText();
            System.out.println("Уведомление: " + notificationMessage);
            assertEquals("  The product has been added to your shopping cart", notificationMessage);
        });
    }
}
