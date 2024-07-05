package PetStorAutomation.api.test;

import PetStorAutomation.api.datagenerator.StoreDataGeneration;
import PetStorAutomation.api.enpoints.StoreEndPoints;
import PetStorAutomation.api.payload.Store.StorePOJO;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class StoreTests extends StoreDataGeneration {

    Response response;
    @Test(priority = 1)
    public void testPlcePetOrder()
    {
        logger.info("******** Creating new pet Records **************");
        response = StoreEndPoints.placeORder(storePayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("******** new pet Record Created **************");
    }

    @Test(priority = 2)
    public void testGetPetOrderDetails()
    {
        logger.info("******** Getting Pet Order Details **************");
        response = StoreEndPoints.findOrderByID(this.storePayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        logger.info("******** Pet Order Detailes Retrieved  **************");
    }

    @Test(priority = 3)
    public void testGetPetStoreInventory()
    {
        logger.info("******** Getting Inventroy of Pet Store By Status **************");
        response = StoreEndPoints.getInventoryByStatus();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        logger.info("******** Invetory Displayed by Status **************");
    }

    @Test(priority = 4)
    public void testDeletePetByID()
    {
        logger.info("******** Deleting pet Records **************");
        response = StoreEndPoints.deletePetByID(this.storePayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        logger.info("******** pet Records deleted **************");
    }

}
