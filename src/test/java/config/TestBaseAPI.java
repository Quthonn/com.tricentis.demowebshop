package config;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBaseAPI {
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://demowebshop.tricentis.com";
    }
}
