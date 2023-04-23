package restapipack;
import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


//Using Hashmap
//using Org.JSON
//POJO Class
// external json file.class

public class DiffWayForPostRequest {
    @Test
    public void testhashmap(){
        HashMap data = new HashMap();
        data.put("name","services");
        data.put("phone","876543");

        String data2[] = {"c","C++"};
        data.put("data" ,data2);

        given().contentType("application/json").body(data)
                .when().post("https://reqres.in/api/users")
                .then().statusCode(201)
                .body("name",equalTo("services"))
                .body("phone",equalTo("876543")).log().all();

    }
@Test
    public void pojo(){

        Pojo_PostRequest data = new Pojo_PostRequest();
        data.setName("services");
        data.setPhone("876543");
        given().contentType("application/json").body(data)
                .when().post("https://reqres.in/api/users")
                .then().statusCode(201)
                .body("name",equalTo("services"))
                .body("phone",equalTo("876543")).log().all();
    }

    @Test
    public void test(){
        TestDemo testDemo = new TestDemo();
        testDemo.setA(3);
        testDemo.setName("Singh Is alwys");

    }

}
