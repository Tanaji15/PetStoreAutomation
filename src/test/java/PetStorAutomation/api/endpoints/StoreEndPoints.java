package PetStorAutomation.api.endpoints;

import PetStorAutomation.api.payload.Store.StorePOJO;
import io.restassured.response.Response;
import static PetStorAutomation.api.endpoints.RequestBuilder.*;

import static io.restassured.RestAssured.given;

public class StoreEndPoints {

   public static Response placeORder(StorePOJO payload)
    {
        Response response = given(requestSpecification)
                .body(payload)
                .when()
                .post(getURL().getString("store_post_url"));
        RequestBuilder.printRequestLogInReport(requestSpecification);
        RequestBuilder.printResponseLogInReport(response);

        return response;
    }

    public static Response findOrderByID(int orderID)
    {
        Response response = given(requestSpecification)
                .pathParam("orderid", orderID)
                .when()
                .get(getURL().getString("store_get_url"));
        RequestBuilder.printRequestLogInReport(requestSpecification);
        RequestBuilder.printResponseLogInReport(response);

        return response;
    }

    public static Response getInventoryByStatus()
    {
        Response response = given(requestSpecification)
                .when()
                .get(getURL().getString("store_get_inventtory_url"));
        RequestBuilder.printRequestLogInReport(requestSpecification);
        RequestBuilder.printResponseLogInReport(response);
        return response;
    }


    public static Response deletePetByID(int orderID)
    {
        Response response = given(requestSpecification)
                .pathParam("orderid", orderID)
                .when()
                .delete(getURL().getString("store_delete_url"));
        RequestBuilder.printRequestLogInReport(requestSpecification);
        RequestBuilder.printResponseLogInReport(response);
        return response;
    }
}
