package PetStorAutomation.api.datagenerator;

import PetStorAutomation.api.payload.Store.StorePOJO;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class StoreDataGeneration {
    public static StorePOJO storePayload;
    public Logger logger;
    public static Faker faker;

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
}
