package PetStorAutomation.api.endpoints;

import PetStorAutomation.api.payload.UserPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndPointsFromPropertiesFile {

    static ResourceBundle getURL()
    {
        //Load the properties file
        ResourceBundle routes = ResourceBundle.getBundle("routes");
        return routes;
    }

    public static Response createUser(UserPOJO payload)
    {
       // String post_URL = getURL().getString("post_url");
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(getURL().getString("post_url"));

        return response;
    }

    public static Response ReadUser(String userName)
    {
        Response response = given()
                .pathParam("username", userName)
                .when()
                .get(getURL().getString("get_url"));
        return response;
    }

    public static Response updateUser(UserPOJO payload, String userName)
    {

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .pathParam("username", userName)
                .when()
                .put(getURL().getString("update_url"));

        return response;
    }

    public static Response deleteUser(String userName)
    {
        Response response = given()
                .pathParam("username", userName)
                .when()
                .delete(getURL().getString("delete_url"));
        return response;
    }


}
