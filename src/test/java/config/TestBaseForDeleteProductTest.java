package config;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.AddProductToCartSpec.RequestSpec;
import static specs.AddProductToCartSpec.ResponseSpec;

public class TestBaseForDeleteProductTest {
    public static String COOKIEVALUE;
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://demowebshop.tricentis.com";
        Configuration.baseUrl = "https://demowebshop.tricentis.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = System.getProperty("browserSize",
                "1920x1080");
    }

    @AfterEach
    public void AfterEach() {
//        open("/logout");
    }

    public static void addToCartTestCall() {
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
                                .response()
                );
    }

    public String getCookieValue() {
        if (COOKIEVALUE == null) {
            Dotenv dotenv = Dotenv.load();
            COOKIEVALUE = dotenv.get("COOKIEVALUE");
        }
        return COOKIEVALUE;
    }
}
