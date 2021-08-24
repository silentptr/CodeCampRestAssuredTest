import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredTestSuite
{
    private static final String AUTH_KEY = "50bacafd-c2e4-411d-b6d4-cb36e261151b";

    @Test
    public void status200Test()
    {
        given()
        .param("q", "Tascott")
        .header("auth-key", AUTH_KEY)
        .when().get("https://digitalapi.auspost.com.au/postcode/search")
        .then()
        .statusCode(200);
    }

    @Test
    public void checkLetterCostTest()
    {
        Response response = given()
        .param("service_code", "AUS_LETTER_REGULAR_LARGE")
        .param("weight", 20)
        .header("auth-key", AUTH_KEY)
        .when().get("https://digitalapi.auspost.com.au/postage/letter/domestic/calculate")
        .then()
        .statusCode(200)/*.body("postage_result.costs.cost.cost", lessThanOrEqualTo(2.2d))*/
        .contentType(ContentType.JSON).extract().response();
        Assertions.assertTrue(Double.parseDouble(response.jsonPath().getString("postage_result.costs.cost.cost")) <= 2.2d);
    }
}
