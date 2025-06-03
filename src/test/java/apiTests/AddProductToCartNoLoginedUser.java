package apiTests;

import config.TestBaseAPI;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static specs.AddProductToCartSpec.RequestSpec;
import static specs.AddProductToCartSpec.ResponseSpec;

public class AddProductToCartNoLoginedUser extends TestBaseAPI {

    @Test
    @Feature("Тестирование добавления товара в корзину без авторизации")
    @Story("Пользователь добавляет товар в корзину без авторизации")
    @Severity(SeverityLevel.TRIVIAL)
    @Tag("Positive")
    @DisplayName("Тест добавления товара в гостевую корзину")
    @Owner("Quthon")
    @Description("Этот тест проверяет, что пользователь может добавить товар в " +
            "гостевую корзину без авторизации.")
    void addToGuestCartTest() {
        var response =
        step("Добавление товара в корзину без авторизации", () ->
        given(RequestSpec)
                .formParam("product_attribute_72_5_18", "53")
                .formParam("product_attribute_72_6_19", "54")
                .formParam("product_attribute_72_3_20", "57")
                .formParam("addtocart_72.EnteredQuantity", "1")
                .when()
                .post("/addproducttocart/details/72/1")
                .then()
                .spec(ResponseSpec)
                .extract()
                .response());

        step("Проверка отказа API на добавление товара в корзину", () -> {
            assertTrue(response.jsonPath().getBoolean("success"));
            assertEquals("The product has been added to your <a href=\"/cart\">shopping cart</a>",
                    response.jsonPath().getString("message"));
        });
    }
}
