package PetStorAutomation.api.endpoints;

import PetStorAutomation.api.payload.User.UserPOJO;
import io.restassured.response.Response;
import static PetStorAutomation.api.endpoints.RequestBuilder.*;

import static io.restassured.RestAssured.given;

public class UserEndPoints {

   public static Response createUser(UserPOJO payload)
    {
        Response response = given(requestSpecification)
                .body(payload)
                .when()
                .post(getURL().getString("user_post_url"));
        RequestBuilder.printRequestLogInReport(requestSpecification);
        RequestBuilder.printResponseLogInReport(response);

        return response;
    }

    public static Response ReadUser(String userName)
    {
        Response response = given(requestSpecification)
                .pathParam("username", userName)
                .when()
                .get(getURL().getString("user_get_url"));
        RequestBuilder.printRequestLogInReport(requestSpecification);
        RequestBuilder.printResponseLogInReport(response);
        return response;
    }


    public static Response updateUser(UserPOJO payload, String userName)
    {

        Response response = given(requestSpecification)
                .body(payload)
                .pathParam("username", userName)
                .when()
                .put(getURL().getString("user_update_url"));
        RequestBuilder.printRequestLogInReport(requestSpecification);
        RequestBuilder.printResponseLogInReport(response);
        return response;
    }

    public static Response deleteUser(String userName)
    {
        Response response = given(requestSpecification)
                .pathParam("username", userName)
                .when()
                .delete(getURL().getString("user_delete_url"));
        RequestBuilder.printRequestLogInReport(requestSpecification);
        RequestBuilder.printResponseLogInReport(response);
        return response;
    }
}
