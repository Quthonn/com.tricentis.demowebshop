package pages;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

public class DeleteProductToCartPage {
    private SelenideElement
            cart = $("#topcartlink"),
            updateCartButton = $(".update-cart-button"),
            orderSummaryContent = $(".order-summary-content");

    private ElementsCollection checkBoxSelector = $$("[type=checkbox]");

    @Step("Открытие сайта")
    public DeleteProductToCartPage openSite() {
        open("/");

        return this;
    }

    @Step("Переход в корзину")
    public DeleteProductToCartPage goToCart() {
        $(cart).click();

        return this;
    }

    @Step("Выделение всех товаров по CheckBox предусмотренных для удаления")
    public DeleteProductToCartPage selectAllProducts() {
        $$(checkBoxSelector).forEach(checkbox -> checkbox.click());

        return this;
    }

    @Step("Нажать кнопку обновления корзины")
    public DeleteProductToCartPage clickButtonUpdateCart() {
        $(updateCartButton).click();

        return this;
    }

    @Step("Проверить удалено ли все из корзины")
    public DeleteProductToCartPage checkResult() {
        String textInCart = $(orderSummaryContent).getText();
        System.out.println(textInCart);
        assertEquals("Your Shopping Cart is empty!", textInCart);

        return this;
    }
}
