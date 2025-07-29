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
import io.github.cdimascio.dotenv.Dotenv;

public class AddProductToCart extends TestBaseAPI {
    private static String COOKIEVALUE;

    @Test
    @Feature("Тестирование добавления товара в корзину")
    @Story("Пользователь добавляет товар в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Positive")
    @DisplayName("Тест добавления товара")
    @Owner("Quthon")
    @Description("Этот тест проверяет, что пользователь может добавить " +
            "товар в корзину.")
    public void addToCartTest() {
        Dotenv dotenv = Dotenv.load();
        COOKIEVALUE = dotenv.get("COOKIEVALUE");

        var response =
        step("Добавление товара в корзину", () ->
         given(RequestSpec)
                .cookie("NOPCOMMERCE.AUTH", COOKIEVALUE)
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

        step("Проверка добавлен ли товар в корзину", () -> {
            assertTrue(response.jsonPath().getBoolean("success"));
            assertEquals("The product has been added to your <a href=\"/cart\">shopping cart</a>",
                    response.jsonPath().getString("message"));
        });
    }
}
