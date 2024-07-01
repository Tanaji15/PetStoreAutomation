package PetStorAutomation.api.endpoints;

import PetStorAutomation.api.payload.User.UserPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndPoints {

   public static Response createUser(UserPOJO payload)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.getURL().getString("user_post_url"));

        return response;
    }

    public static Response ReadUser(String userName)
    {
        Response response = given()
                .pathParam("username", userName)
                .when()
                .get(Routes.getURL().getString("user_get_url"));
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
                .put(Routes.getURL().getString("user_update_url"));

        return response;
    }

    public static Response deleteUser(String userName)
    {
        Response response = given()
                .pathParam("username", userName)
                .when()
                .delete(Routes.getURL().getString("user_delete_url"));
        return response;
    }
}
