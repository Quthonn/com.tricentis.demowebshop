package pages;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.codeborne.selenide.ElementsCollection;

public class DeleteProductToCartPage {
    private SelenideElement
            cart = $("#topcartlink"),
            updateCartButton = $(".update-cart-button"),
            orderSummaryContent = $(".order-summary-content");

    private ElementsCollection checkBoxSelector = $$("[type=checkbox]");

    public DeleteProductToCartPage openSite() {
        Allure.step("Открытие сайта", () -> {
            open("/");
        });
        return this;
    }

    public DeleteProductToCartPage goToCart() {
        Allure.step("Переход в корзину", () -> {
            $(cart).click();
        });
        return this;
    }

    public DeleteProductToCartPage selectAllProducts() {
        Allure.step("Выделение всех товаров по CheckBox предусмотренных для удаления", () -> {
            $$(checkBoxSelector).forEach(checkbox -> checkbox.click());
        });
        return this;
    }

    public DeleteProductToCartPage clickButtonUpdateCart() {
        Allure.step("Нажать кнопку обновления корзины", () -> {
            $(updateCartButton).click();
        });
        return this;
    }

    public DeleteProductToCartPage checkResult() {
        Allure.step("Проверить удалено ли все из корзины", () -> {
            String textInCart = $(orderSummaryContent).getText();
            System.out.println(textInCart);
            assertEquals("Your Shopping Cart is empty!", textInCart);
        });
        return this;
    }
}
