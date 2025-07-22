package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddProductCartPage {
    private SelenideElement
            productNameSelector = $(".product-name"),
            productImageSelector = $$(".picture").filter(visible).get(1),
            addToCartButtonSelector = $(".add-to-cart-button"),
            barNotificationSelector = $(".bar-notification");

    public AddProductCartPage openSite() {
        Allure.step("Открытие сайта", () -> {
            open("/");
        });
        return this;
    }

    public AddProductCartPage goToProductPage() {
        Allure.step("Переход на страницу товара", () -> {
            $(productImageSelector).scrollTo().click();
            String ProductName = $(productNameSelector).getText();
            System.out.println("Название товара: " + ProductName);
        });
        return this;
    }

    public AddProductCartPage addProductToCart() {
        Allure.step("Нажать 'Добавить в корзину'", () -> {
            $(addToCartButtonSelector).click();
        });
        return this;
    }

    public AddProductCartPage checkResult() {
        Allure.step("Проверка добавлен ли товар в корзину", () -> {
            String notificationMessage = $(barNotificationSelector).shouldBe(visible).getText();
            System.out.println("Уведомление: " + notificationMessage);
            assertEquals("  The product has been added to your shopping cart", notificationMessage);
        });
        return this;
    }
}

