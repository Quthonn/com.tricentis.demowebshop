package uiTests;

import config.TestBase;
import config.TestBaseForDeleteProduct;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.DeleteProductToCartPage;

public class DeleteProductInCart extends TestBase {
    TestBaseForDeleteProduct befofeEach = new TestBaseForDeleteProduct();
    DeleteProductToCartPage deleteProductToCartPage = new DeleteProductToCartPage();

    @BeforeEach
    public void BeforeEach() {
        befofeEach.addProductToCart();
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
        deleteProductToCartPage.openSite()
                .goToCart()
                .selectAllProducts()
                .clickButtonUpdateCart()
                .checkResult();

    }
}
