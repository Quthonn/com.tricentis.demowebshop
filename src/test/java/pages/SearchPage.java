package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchPage {
    private SelenideElement
            searchField = $(".search-box-text"),
            placeWithProducts = $(".search-results");

    public SearchPage openSite() {
        Allure.step("Открытие сайта", () -> {
            open("/");
        });
        return this;
    }

    public SearchPage searchProduct(String query) {
        Allure.step("Ввод названия товара в поле поиска и нажатие Enter", () -> {
            searchField.setValue(query).pressEnter();
        });
        return this;
    }

    public SearchPage viewFoundedProducts(String query) {
        Allure.step("Проверка найденных товаров", () -> {
            String actualText = placeWithProducts.getText().toLowerCase();
            assertTrue(actualText.contains(query));
        });
        return this;
    }
}
