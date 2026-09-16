package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchPage {
    private SelenideElement
            searchField = $(".search-box-text"),
            placeWithProducts = $(".search-results");

    @Step("Открытие сайта")
    public SearchPage openSite() {
        open("/");

        return this;
    }

    @Step("Ввод названия товара в поле поиска и нажатие Enter")
    public SearchPage searchProduct(String query) {
        searchField.setValue(query).pressEnter();

        return this;
    }

    @Step("Проверка найденных товаров")
    public SearchPage viewFoundedProducts(String query) {
        String actualText = placeWithProducts.getText().toLowerCase();
        assertTrue(actualText.contains(query));

        return this;
    }
}
