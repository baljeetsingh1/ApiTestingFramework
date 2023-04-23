package api.endpoints;
/*base url https://petstore.swagger.io/

 */
public class Routes {

    public static  String base_url = "https://petstore.swagger.io/v2";
//user module
    public static String post_url = base_url+"/user";
    public static String get_url = base_url+"/user ";

public static String update_url  = base_url+"/user/{username}";
public static String Delete_url = base_url+"/user/{username}";

public static String Login_URl = base_url+"/user/login";
    // https://petstore.swagger.io/v2/user/login?username=User&password=user
    public static String Upload_File = base_url+"/pet/1/uploadImage";
    public static  String add_new_pet = base_url+"/pet";
}


























