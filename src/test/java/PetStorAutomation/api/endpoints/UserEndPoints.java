package PetStorAutomation.api.endpoints;
import PetStorAutomation.api.payload.UserPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static  io.restassured.RestAssured.*;


// User endpoints file
// Created for performing CRUD operations
public class UserEndPoints {

    public static Response createUser(UserPOJO payload)
        {

            Response response = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(payload)
                    .when()
                    .post(Routes.post_URL);

            return response;
        }

    public static Response ReadUser(String userName)
    {
        Response response = given()
                .pathParam("username", userName)
                .when()
                .get(Routes.get_URL);
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
                .put(Routes.update_URL);

        return response;
    }

    public static Response deleteUser(String userName)
    {
        Response response = given()
                .pathParam("username", userName)
                .when()
                .delete(Routes.delete_URL);
        return response;
    }

}
