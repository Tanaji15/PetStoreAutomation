package PetStorAutomation.api.test;

import PetStorAutomation.api.endpoints.PetEndPoints;
import PetStorAutomation.api.payload.Pet.PetCategory;
import PetStorAutomation.api.payload.Pet.PetPOJO;
import PetStorAutomation.api.payload.Pet.PetTags;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.*;

public class PetTests {

    Faker faker;
    PetPOJO petPayload;
    PetCategory petCategory;
    PetTags petTags;
    public Logger logger;


    @BeforeClass
    public void setupPetData() {

        faker = new Faker();
        String URL = "https://www.shutterstock.com/image-photo/funny-dog-licking-lips-tongue-out-1761385949";
        ArrayList<PetTags> tagDetails = new ArrayList<PetTags>();
        petTags = new PetTags();
        petTags.setId(faker.random().nextInt(500));
        petTags.setName(faker.animal().name());
        tagDetails.add(petTags);
        petCategory = new PetCategory();
        petCategory.setId(faker.random().nextLong(500));
        petCategory.setName(faker.funnyName().name());
        ArrayList<String> fURL = new ArrayList<String>();
        fURL.add(URL);

        petPayload = new PetPOJO();
        petPayload.setId(faker.random().nextLong(500));
        petPayload.setCategory(petCategory);
        petPayload.setName(faker.animal().name());
        petPayload.setPhotoUrls(fURL);
        petPayload.setTags(tagDetails);
        petPayload.setStatus("0");

        logger = LogManager.getLogger(this.getClass());
        logger.debug("Debugging petStore API.....");

    }

    @Test(priority = 1)
    public void testCreateNewPet(){
        logger.info("******** Creating New Pet **************");
        Response response = PetEndPoints.createNewPet(petPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("******** New Pet Created **************");
    }

    @Test(priority = 2)
    public void testGetPetDetails(){
          logger.info("******** Creating New Pet **************");
        Response response = PetEndPoints.getPetDetailsByID(this.petPayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
         logger.info("******** New Pet Created **************");
    }

    @Test(priority = 3)
    public void testUpdatePetDetailsByID(){

        petPayload.setName(faker.animal().name());
        petPayload.setStatus("1");
          logger.info("******** Creating New Pet **************");
        Response response = PetEndPoints.updatePetDetailsByID(petPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
         logger.info("******** New Pet Created **************");
    }

    @Test(priority = 4)
    public void testDeletePetByID(){
          logger.info("******** Creating New Pet **************");
        Response response = PetEndPoints.deletePetDetailsByID(this.petPayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
         logger.info("******** New Pet Created **************");
    }

    @Test(priority = 5)
    public void testGetPetDetailsByStatus(){
        logger.info("******** Creating New Pet **************");
        Response response = PetEndPoints.getPetDetailsByStatus("available");
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
       logger.info("******** New Pet Created **************");
    }


}
