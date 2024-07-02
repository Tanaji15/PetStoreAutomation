package PetStorAutomation.api.test;

import PetStorAutomation.api.endpoints.StoreEndPoints;
import PetStorAutomation.api.payload.Store.StorePOJO;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class StoreTests {

    StorePOJO storePayload;
    public Logger logger;
    Faker faker;
    Response response;
    @BeforeClass
    public void setupStoreData()
    {
        faker = new Faker();
        storePayload = new StorePOJO();
        String status = "Placed";
        storePayload.setId(faker.random().nextInt(500));
        storePayload.setPetID(faker.random().nextInt(501,1000));
        storePayload.setQuantity(faker.random().nextInt(5));
        storePayload.setShipDate(faker.date().future(5, TimeUnit.MILLISECONDS));
        storePayload.setStatus(status);
        storePayload.setComplete(faker.bool().bool());

        logger = LogManager.getLogger(this.getClass());
        logger.info("***************Store Debug Started *************");
    }

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
