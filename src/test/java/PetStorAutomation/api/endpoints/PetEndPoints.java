package PetStorAutomation.api.endpoints;
import PetStorAutomation.api.payload.Pet.PetPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetEndPoints {

    public static Response createNewPet(PetPOJO payload)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.getURL().getString("pet_post_url"));
        return response;
    }

    public static Response getPetDetailsByID(long petID)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("petID",petID)
                .when()
                .get(Routes.getURL().getString("pet_get_url"));
        return response;
    }

    public static Response getPetDetailsByStatus(String status)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("status",status)
                .when()
                .get(Routes.getURL().getString("pet_get_url_ByStatus"));
        return response;
    }

    public static Response updatePetDetailsByID(PetPOJO payload)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .put(Routes.getURL().getString("pet_update_url"));
        return response;
    }

    public static Response deletePetDetailsByID(long petID)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("petID",petID)
                .when()
                .delete(Routes.getURL().getString("pet_delete_url"));
        return response;
    }

}
