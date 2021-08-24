import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class RestAssuredTestSuite
{
    @Test
    public void Status200Test()
    {
        given().param("q", "Tascott").and()
        .header("auth-key", "50bacafd-c2e4-411d-b6d4-cb36e261151b")
        .when().get().then().assertThat().statusCode(200);
    }
}
