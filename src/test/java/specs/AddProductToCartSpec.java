package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.filter.log.LogDetail.BODY;

public class AddProductToCartSpec {
    public static RequestSpecification RequestSpec = with()
            .filter(withCustomTemplates())
            .contentType("application/x-www-form-urlencoded")
            .log().body()
            .log().all();

    public static ResponseSpecification ResponseSpec = new ResponseSpecBuilder()
            .log(BODY)
            .log(ALL)
            .expectStatusCode(200)
            .build();
}
