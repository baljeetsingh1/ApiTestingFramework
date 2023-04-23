package api.endpoints;

import api.payload.User_POJO;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.Test;


import java.io.File;

import java.util.HashMap;

import static io.restassured.RestAssured.given;



//this is user end points, which is use for CURD operation
public class UserEndPoints  {


   public static Response createUser(User_POJO ypayload){

Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(ypayload)
        .when().post(Routes.post_url);
          return response;
    }

    public static Response readUser(String Username){

        Response response = given().queryParams("username",Username)
                .when().get(Routes.get_url);
        return response;
    }
    public static Response updateUser(String Username,User_POJO ypayload){

        Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .pathParam("username", Username).body(ypayload)
                .when().put(Routes.update_url);
        return response;
    }
    public static Response DeleteUser(String Username){

        Response response = given().pathParam("username",Username)
                .when().delete(Routes.Delete_url);
        return response;
    }
    public static Response Loginusser(String Username, String Password){

       Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
               .queryParam("username",Username,"password",Password)
               .when().get(Routes.Login_URl);
       return response;

    }
    @Test
    public  void Uploadfile(){
        File file = new File("E:\\TestFolder\\Screenshot (2).png");

       //Response response =
        given().contentType(ContentType.MULTIPART).accept(ContentType.JSON)
               .multiPart(file)
               .when().post(Routes.Upload_File).then().log().all();
      // return response;
   }
  //  @Test
    public static void addnewpewt(){
        HashMap hashMap = new HashMap();
        hashMap.put("name", "doggie");
        String photoUrlss[] = {"string"};
        hashMap.put("photoUrls", photoUrlss);
        given().contentType(ContentType.JSON).accept(ContentType.JSON).body(hashMap)
                .when().post(Routes.add_new_pet).then().log().all();

    }
}













