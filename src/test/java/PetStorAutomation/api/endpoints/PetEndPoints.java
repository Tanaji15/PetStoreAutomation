package PetStorAutomation.api.endpoints;
import PetStorAutomation.api.payload.Pet.PetPOJO;
import io.restassured.response.Response;
import static PetStorAutomation.api.endpoints.RequestBuilder.*;
import static io.restassured.RestAssured.given;


public class PetEndPoints {

    public static Response createNewPet(PetPOJO payload)
    {
        Response response = given(requestSpecification)
                .body(payload)
                .when()
                .post(getURL().getString("pet_post_url"));
        RequestBuilder.printRequestLogInReport(requestSpecification);
        RequestBuilder.printResponseLogInReport(response);
        return response;
    }

    public static Response getPetDetailsByID(long petID)
    {
        Response response = given(requestSpecification)
                .pathParam("petID",petID)
                .when()
                .get(getURL().getString("pet_get_url"));
        RequestBuilder.printRequestLogInReport(requestSpecification);
        RequestBuilder.printResponseLogInReport(response);
        return response;
    }

    public static Response getPetDetailsByStatus(String status)
    {
        Response response = given(requestSpecification)
                .queryParam("status",status)
                .when()
                .get(getURL().getString("pet_get_url_ByStatus"));
        RequestBuilder.printRequestLogInReport(requestSpecification);
        RequestBuilder.printResponseLogInReport(response);
        return response;
    }

    public static Response updatePetDetailsByID(PetPOJO payload)
    {
        Response response = given(requestSpecification)
                .body(payload)
                .when()
                .put(getURL().getString("pet_update_url"));
        RequestBuilder.printRequestLogInReport(requestSpecification);
        RequestBuilder.printResponseLogInReport(response);
        return response;
    }

    public static Response deletePetDetailsByID(long petID)
    {
        Response response = given(requestSpecification)
                .pathParam("petID",petID)
                .when()
                .delete(getURL().getString("pet_delete_url"));
        RequestBuilder.printRequestLogInReport(requestSpecification);
        RequestBuilder.printResponseLogInReport(response);
        return response;
    }

}
