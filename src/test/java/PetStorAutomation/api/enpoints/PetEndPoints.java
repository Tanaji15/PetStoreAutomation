package PetStorAutomation.api.enpoints;
import PetStorAutomation.api.payload.Pet.PetPOJO;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PetEndPoints {

    public static Response createNewPet(PetPOJO payload)
    {
        Response response = RestAssured.given(RequestBuilder.requestSpecification)
                .body(payload)
                .when()
                .post(RequestBuilder.getURL().getString("pet_post_url"));
        RequestBuilder.printRequestLogInReport(RequestBuilder.requestSpecification);
        RequestBuilder.printResponseLogInReport(response);
        return response;
    }

    public static Response getPetDetailsByID(long petID)
    {
        Response response = RestAssured.given(RequestBuilder.requestSpecification)
                .pathParam("petID",petID)
                .when()
                .get(RequestBuilder.getURL().getString("pet_get_url"));
        RequestBuilder.printRequestLogInReport(RequestBuilder.requestSpecification);
        RequestBuilder.printResponseLogInReport(response);
        return response;
    }

    public static Response getPetDetailsByStatus(String status)
    {
        Response response = RestAssured.given(RequestBuilder.requestSpecification)
                .queryParam("status",status)
                .when()
                .get(RequestBuilder.getURL().getString("pet_get_url_ByStatus"));
        RequestBuilder.printRequestLogInReport(RequestBuilder.requestSpecification);
        RequestBuilder.printResponseLogInReport(response);
        return response;
    }

    public static Response updatePetDetailsByID(PetPOJO payload)
    {
        Response response = RestAssured.given(RequestBuilder.requestSpecification)
                .body(payload)
                .when()
                .put(RequestBuilder.getURL().getString("pet_update_url"));
        RequestBuilder.printRequestLogInReport(RequestBuilder.requestSpecification);
        RequestBuilder.printResponseLogInReport(response);
        return response;
    }

    public static Response deletePetDetailsByID(long petID)
    {
        Response response = RestAssured.given(RequestBuilder.requestSpecification)
                .pathParam("petID",petID)
                .when()
                .delete(RequestBuilder.getURL().getString("pet_delete_url"));
        RequestBuilder.printRequestLogInReport(RequestBuilder.requestSpecification);
        RequestBuilder.printResponseLogInReport(response);
        return response;
    }

}
