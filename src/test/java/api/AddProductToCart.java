package api;

import config.TestBaseAPI;
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
    void addToCartTest() {
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
