package PetStorAutomation.api.enpoints;

import PetStorAutomation.api.payload.User.UserPOJO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static PetStorAutomation.api.enpoints.RequestBuilder.*;

import static io.restassured.RestAssured.given;

public class UserEndPoints {

   public static Response createUser(UserPOJO payload)
    {
        Response response = RestAssured.given(requestSpecification)
                .body(payload)
                .when()
                .post(getURL().getString("user_post_url"));
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);

        return response;
    }

    public static Response ReadUser(String userName)
    {
        Response response = RestAssured.given(requestSpecification)
                .pathParam("username", userName)
                .when()
                .get(getURL().getString("user_get_url"));
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }


    public static Response updateUser(UserPOJO payload, String userName)
    {

        Response response = RestAssured.given(requestSpecification)
                .body(payload)
                .pathParam("username", userName)
                .when()
                .put(getURL().getString("user_update_url"));
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    public static Response deleteUser(String userName)
    {
        Response response = RestAssured.given(requestSpecification)
                .pathParam("username", userName)
                .when()
                .delete(getURL().getString("user_delete_url"));
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }
}
