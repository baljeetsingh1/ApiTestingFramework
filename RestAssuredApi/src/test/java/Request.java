import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import java.util.HashMap;
import java.util.Scanner;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;


public class Request {
    int id;

    @BeforeClass
    public static void sum() {

        int a = 1;
        int b = 2;
        int c = a + b;
        System.out.println("this is my test");
        System.out.println(c);
        Assert.assertEquals(4, c);
    }

    @AfterClass
    public static void sub() {

        int a = 1;
        int b = 2;
        int c = a - b;
        System.out.println("this is my test");
        System.out.println(c);
        Assert.assertEquals(-1, c);
        System.out.println("my test has been passed");

    }

    @Test
    public void allgetuser() {
        given()

                .when().get("https://reqres.in/api/users?page=2")

                .then().statusCode(200)
                .body("page", equalTo(2)).log().all();
    }

    //@Test
    public void createrequest() {
        // String username;
        HashMap hm = new HashMap();
        hm.put("name", "praven");
        hm.put("job", "testeer");

        //Scanner myobject = new Scanner(System.in);
        //System.out.println("Enter username");
        //username = myobject.nextLine();
        //System.out.println("name" +username);

        System.out.println(id = given().contentType("application/json")
                .body(hm)
                .when().post("https://reqres.in/api/users").jsonPath().getInt("id"));


        System.out.println("value of the/" + id);
        //.then().statusCode(201).log().ifStatusCodeIsEqualTo(201);


    }

    //@Test
    public void updaterequest() {
        String username;

        HashMap hm = new HashMap();
        hm.put("name", "praven singh");
        hm.put("job", "teacher");

        given().contentType("application/json")
                .body(hm)
                .when().put("https://reqres.in/api/users/" + id)
                .then().statusCode(200).log().all();


    }

    // @Test
    public void deleterequest() {
        System.out.println(given().contentType("application/json")
                .when().delete("https://reqres.in/api/users/" + id)
                .then().statusCode(204).log().all());
    }

}


















