package uiTests;

import config.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.SearchPage;

public class SearchProduct extends TestBase {
    SearchPage searchPage = new SearchPage();

    @Feature("Тестирование поиска")
    @Story("Пользователь в поиске вводит название товара")
    @Severity(SeverityLevel.NORMAL)
    @Tag("Positive")
    @DisplayName("Тест поиска")
    @Owner("Quthon")
    @Description("Этот тест проверяет, что пользователь может в поиске все найти.")
    @ParameterizedTest(name = "(Поиск по слову: {0})")
    @ValueSource(strings = {"laptop", "book"})
    public void search(String query) {
        searchPage.openSite()
                .searchProduct(query)
                .viewFoundedProducts(query);
    }
}
