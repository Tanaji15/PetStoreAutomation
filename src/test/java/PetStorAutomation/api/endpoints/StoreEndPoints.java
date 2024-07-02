package PetStorAutomation.api.endpoints;

import PetStorAutomation.api.payload.Store.StorePOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StoreEndPoints {

   public static Response placeORder(StorePOJO payload)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.getURL().getString("store_post_url"));

        return response;
    }

    public static Response findOrderByID(int orderID)
    {
        Response response = given()
                .pathParam("orderid", orderID)
                .when()
                .get(Routes.getURL().getString("store_get_url"));
        return response;
    }

    public static Response getInventoryByStatus()
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(Routes.getURL().getString("store_get_inventtory_url"));
        return response;
    }


    public static Response deletePetByID(int orderID)
    {
        Response response = given()
                .pathParam("orderid", orderID)
                .when()
                .delete(Routes.getURL().getString("store_delete_url"));
        return response;
    }
}
