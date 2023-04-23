package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User_POJO;
import com.github.javafaker.Faker;
import groovy.lang.DelegatesTo;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public  class UserTest {

    static Faker faker;
   static User_POJO payload;


    @BeforeClass
    public static void setupdata(){
        faker = new Faker();
        payload =new User_POJO();
        payload.setId(faker.idNumber().hashCode());
        payload.setUsername(faker.name().username());
        payload.setFirstname(faker.name().firstName());


    }
    @Test
    public void testpostuser(){
       Response response= UserEndPoints.createUser(payload);
       response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }
    @Test
    public void testgetuserdetails(){
        Response response = UserEndPoints.readUser(this.payload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),405);
    }

    @Test
    public void testupdateuser(){
        payload.setId(faker.idNumber().hashCode());
        payload.setUsername(faker.name().username());
        payload.setFirstname(faker.name().firstName());
        //update data using same payload
        Response response= UserEndPoints.updateUser(this.payload.getUsername(),payload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
@Test
    public void testdelete(){
        Response response = UserEndPoints.DeleteUser(this.payload.getUsername());
        Assert.assertEquals(response.getStatusCode(),404);
        response.then().log().all();

    }
    @Test
    public void login(){

        Response response = UserEndPoints.Loginusser("User","user");
        response.then().log().all();
    }
    @Test
    public void uploadfile(){

      //  Response response =
        UserEndPoints userTest =  new UserEndPoints();
               userTest.Uploadfile();
        //response.then().log().all();
    }



    @Test
    public void addpet(){
     UserEndPoints.addnewpewt();


}

}

























