import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class WorldTimeAPITest
{
    @Test
    public void testWorldAPI()
    {
        get("http://worldtimeapi.org/api/timezone/Australia/Brisbane").then().assertThat().statusCode(200);
    }
}
