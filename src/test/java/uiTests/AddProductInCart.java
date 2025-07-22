package uiTests;

import config.TestBase;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Cookie;
import pages.AddProductCartPage;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

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

    AddProductCartPage addProductCartPage = new AddProductCartPage();

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
        addProductCartPage.openSite()
                .goToProductPage()
                .addProductToCart()
                .checkResult();
    }
}
