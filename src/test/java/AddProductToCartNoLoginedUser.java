import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class AddProductToCartNoLoginedUser {
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://demowebshop.tricentis.com";
    }

    @Test
    void addToCartTest() {
        String body = "product_attribute_72_5_18=53" +
                "&product_attribute_72_6_19=54" +
                "&product_attribute_72_3_20=57" +
                "&addtocart_72.EnteredQuantity=1";
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body(body)
                .when()
                .post("/addproducttocart/details/72/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"))
                .body("updatetopcartsectionhtm;", is("1"));

    }
}
