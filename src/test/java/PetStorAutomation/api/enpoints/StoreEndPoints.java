package PetStorAutomation.api.enpoints;

import PetStorAutomation.api.payload.Store.StorePOJO;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StoreEndPoints {

   public static Response placeORder(StorePOJO payload)
    {
        Response response = RestAssured.given(RequestBuilder.requestSpecification)
                .body(payload)
                .when()
                .post(RequestBuilder.getURL().getString("store_post_url"));
        RequestBuilder.printRequestLogInReport(RequestBuilder.requestSpecification);
        RequestBuilder.printResponseLogInReport(response);

        return response;
    }

    public static Response findOrderByID(int orderID)
    {
        Response response = RestAssured.given(RequestBuilder.requestSpecification)
                .pathParam("orderid", orderID)
                .when()
                .get(RequestBuilder.getURL().getString("store_get_url"));
        RequestBuilder.printRequestLogInReport(RequestBuilder.requestSpecification);
        RequestBuilder.printResponseLogInReport(response);

        return response;
    }

    public static Response getInventoryByStatus()
    {
        Response response = RestAssured.given(RequestBuilder.requestSpecification)
                .when()
                .get(RequestBuilder.getURL().getString("store_get_inventtory_url"));
        RequestBuilder.printRequestLogInReport(RequestBuilder.requestSpecification);
        RequestBuilder.printResponseLogInReport(response);
        return response;
    }


    public static Response deletePetByID(int orderID)
    {
        Response response = RestAssured.given(RequestBuilder.requestSpecification)
                .pathParam("orderid", orderID)
                .when()
                .delete(RequestBuilder.getURL().getString("store_delete_url"));
        RequestBuilder.printRequestLogInReport(RequestBuilder.requestSpecification);
        RequestBuilder.printResponseLogInReport(response);
        return response;
    }
}
