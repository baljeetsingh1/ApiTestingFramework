package restapipack;
import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParam {
    @Test
    public void testpathandQueryparam(){
        given()
                .pathParam("mypath","users")
                .queryParam("page",2)
                .queryParams("id",5)
                .when()
                .get("https://reqres.in/api/{mypath}")
                .then().statusCode(200).log().all();
    }

}











