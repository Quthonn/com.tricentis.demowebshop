package uiTests;

import config.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.AddProductCartPage;

public class AddProductInCart extends TestBase {
    TestBase testBase = new TestBase();
    AddProductCartPage addProductCartPage = new AddProductCartPage();

    @BeforeEach
    public void BeforeEach() {
        testBase.Login();
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
        addProductCartPage.openSite()
                .goToProductPage()
                .addProductToCart()
                .checkResult();
    }
}
