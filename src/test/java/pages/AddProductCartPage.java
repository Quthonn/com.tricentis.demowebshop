package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddProductCartPage {
    private SelenideElement
            productNameSelector = $(".product-name"),
            productImageSelector = $$(".picture").filter(visible).get(1),
            addToCartButtonSelector = $(".add-to-cart-button"),
            barNotificationSelector = $(".bar-notification");

    @Step("Открытие сайта")
    public AddProductCartPage openSite() {
        open("/");

        return this;
    }

    @Step("Переход на страницу товара")
    public AddProductCartPage goToProductPage() {
        $(productImageSelector).scrollTo().click();
        String ProductName = $(productNameSelector).getText();
        System.out.println("Название товара: " + ProductName);

        return this;
    }

    @Step("Нажать 'Добавить в корзину'")
    public AddProductCartPage addProductToCart() {
        $(addToCartButtonSelector).click();

        return this;
    }

    @Step("Проверка добавлен ли товар в корзину")
    public AddProductCartPage checkResult() {
        String notificationMessage = $(barNotificationSelector).shouldBe(visible).getText();
        System.out.println("Уведомление: " + notificationMessage);
        assertEquals("  The product has been added to your shopping cart", notificationMessage);

        return this;
    }
}

